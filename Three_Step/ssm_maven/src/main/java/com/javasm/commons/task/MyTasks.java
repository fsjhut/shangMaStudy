package com.javasm.commons.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MyTasks {

//    @Scheduled(cron = "0/5 * * * * ?")
    public  void task1(){
        System.out.println(Thread.currentThread().getName()+".......task1.......");
//        try {
//            Thread.sleep(60*1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }

//    @Scheduled(cron = "3/5 * * * * ?")
    public  void task2(){
        System.out.println(Thread.currentThread().getName()+".....task2........");
    }
}
