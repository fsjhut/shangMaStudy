package com.javasm.commons.async;


import com.javasm.commons.utils.SpringUtil;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

public class AsyncThreadManager {

    public static void execute(Runnable runnable) {
        ThreadPoolTaskExecutor bean = SpringUtil.getBean(ThreadPoolTaskExecutor.class);
        bean.execute(runnable);
    }
}
