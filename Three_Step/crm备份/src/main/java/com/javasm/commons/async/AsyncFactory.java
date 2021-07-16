package com.javasm.commons.async;


import com.javasm.commons.sms.SmsUtil;

public class AsyncFactory {

    public static Runnable valiCode(String uphone, String code) {
        return new Runnable() {
            @Override
            public void run() {
                SmsUtil.sendValiCode(uphone, code);

            }
        };
    }
}
