package com.javasm.commons.sms;


public class SmsUtil {
    public static void sendValiCode(String uphone, String code) {

        System.out.println("发短信的线程:"+Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
