//import com.javasm.commons.task.MyTasks;
import org.junit.Test;
import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

/**
 * @className: QuartzTest
 * @description:   
 * @author SunHang
 * @createTime 2021/6/25 9:48
 */
//public class QuartzTest {
//    @Test
//    public void quartzTest(){
//        MethodInvokingJobDetailFactoryBean factoryBean = new MethodInvokingJobDetailFactoryBean();
//        factoryBean.setTargetObject(MyTasks.class);
//        factoryBean.setTargetMethod("task1");
//        CronTriggerFactoryBean cron = new CronTriggerFactoryBean();
//        cron.setJobDetail(factoryBean.getObject());
//        cron.setCronExpression("0/5 * * * * ?");
//        SchedulerFactoryBean scheduler = new SchedulerFactoryBean();
//        scheduler.setTriggers(cron.getObject());
//    }
//}
