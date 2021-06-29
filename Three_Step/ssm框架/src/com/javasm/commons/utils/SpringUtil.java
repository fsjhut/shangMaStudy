package com.javasm.commons.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @className: SpringUtil
 * @description:   
 * @author SunHang
 * @createTime 2021/6/17 21:20
 */

@Component
public class SpringUtil implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext ac) throws BeansException {
        applicationContext=ac;
    }

    public static ApplicationContext getParentApplicationContext(){
        return applicationContext;
    }

    public static <T> T getBean(Class<T> clz){
        return applicationContext.getBean(clz);
    }

    public static Object getBean(String beanId){
        return applicationContext.getBean(beanId);
    }

    public static <T> T getBean(String beanId,Class<T> clz){
        return applicationContext.getBean(beanId,clz);
    }
}
