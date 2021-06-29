package com.javasm.commons.sms;

public class SmsUtil {

    public static void sendValicode(String uphone,String code){
        //todo 发短信.是网络请求(耗时,失败).
        System.out.println("发短信的线程:"+Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
