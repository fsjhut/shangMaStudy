package com.javasm.commons.task;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;

/**
 * @className: TestQuartz2
 * @description:   
 * @author SunHang
 * @createTime 2021/6/25 10:34
 */
//@Configuration
//public class TestQuartz2 {
//    @Bean
//    public void quartzTask(){
//        MethodInvokingJobDetailFactoryBean factoryBean = new MethodInvokingJobDetailFactoryBean();
//        factoryBean.setTargetObject(MyTasks.class);
//        factoryBean.setTargetMethod("task1");
//        CronTriggerFactoryBean cron = new CronTriggerFactoryBean();
//        cron.setJobDetail(factoryBean.getObject());
//        cron.setCronExpression("0/5 * * * * ?");
//    }
//}
