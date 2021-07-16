package com.javasm.task;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MyTask {

//    @Async//使用ThreadPoolTaskExecutor执行task1
    @Scheduled(cron = "0/5 * * * * ?")//使用ThreadPoolTaskScheduler来调度任务
    public void task1(){
        System.out.println("task1111--"+Thread.currentThread().getName());
    }

//    @Async//使用ThreadPoolTaskExecutor执行task2
    @Scheduled(cron = "3/5 * * * * ?")
    public void task2(){
        System.out.println("task2222--"+Thread.currentThread().getName());
    }
}
