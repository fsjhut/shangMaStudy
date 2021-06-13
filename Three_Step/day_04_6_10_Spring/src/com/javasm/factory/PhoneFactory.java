package com.javasm.factory;

import lombok.SneakyThrows;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Proxy;
import java.util.Properties;

/**
 * @className: PhoneFactory
 * @description:   
 * @author SunHang
 * @createTime 2021/6/10 21:11
 */
public class PhoneFactory {
    private static Properties properties = new Properties();
    // 静态工厂方法
    public static Phone createPhone(String type){
        if("mi".equals(type)){
            return new MiPhone();
        }else if("honor".equals(type)){
            return new HonorPhone();
        }else if("apple".equals(type)){
            return new ApplePhone();
        }else{
            return null;
        }
    }
    static {
        InputStream resource = PhoneFactory.class.getClassLoader().getResourceAsStream("phoneType.properties");
        try {
            properties.load(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // 反射工厂方法 需要加载配置文件
    @SneakyThrows
    public static Phone createPhone2(String type){
        String className = properties.getProperty(type);
        Class<?> aClass = Class.forName(className);
        Object instance = aClass.newInstance();
        if(instance instanceof Phone){
            return (Phone)instance;
        }
        return null;
    }
}
