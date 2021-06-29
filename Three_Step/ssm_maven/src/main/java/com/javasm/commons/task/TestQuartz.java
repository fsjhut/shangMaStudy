package com.javasm.commons.task;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.JobDetailImpl;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.text.ParseException;

/**
 * @author SunHang
 * @className: TestQuartz
 * @description:
 * @createTime 2021/6/25 10:09
 */
@Component
public class TestQuartz implements InitializingBean {

    @Resource
    private MyTasks myTasks;

    @Override
    public void afterPropertiesSet() {
        StdSchedulerFactory f =new StdSchedulerFactory();

        // task2 的配置
        MethodInvokingJobDetailFactoryBean factoryBean2 = new MethodInvokingJobDetailFactoryBean();
        factoryBean2.setTargetObject(myTasks);
        factoryBean2.setTargetMethod("task2");
        try {
            factoryBean2.afterPropertiesSet();
        } catch (Exception e) {
            e.printStackTrace();
        }

        CronTriggerFactoryBean cron2 = new CronTriggerFactoryBean();
        cron2.setJobDetail(factoryBean2.getObject());
        cron2.setCronExpression("3/5 * * * * ?");
        try {
            cron2.afterPropertiesSet();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        try {
            Scheduler scheduler1 = f.getScheduler();
            scheduler1.scheduleJob(factoryBean2.getObject(),cron2.getObject());
            scheduler1.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
