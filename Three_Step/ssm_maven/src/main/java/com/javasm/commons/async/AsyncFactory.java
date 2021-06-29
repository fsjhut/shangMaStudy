package com.javasm.commons.async;

import com.javasm.commons.sms.SmsUtil;

public class AsyncFactory {

    //该工厂类负责生成Runnable对象.
    public static Runnable valicode(String uphone, String code) {
        return new Runnable() {
            @Override
            public void run() {
                SmsUtil.sendValicode(uphone, code);
            }
        };
    }
}
