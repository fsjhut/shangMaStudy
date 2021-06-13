package com.javasm.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @className: SSF
 * @description:   
 * @author SunHang
 * @createTime 2021/6/7 19:34
 */
public class SSF {
    // 使用单例模式
    private static volatile SqlSessionFactory factory = null;
    private SSF(){}
    public static SqlSessionFactory getFactory(){
        if(factory==null){
            synchronized (SqlSessionFactory.class){
                if(factory==null){
                    InputStream in = null;
                    try {
                        in = Resources.getResourceAsStream("mybatis-config.xml");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    factory = new SqlSessionFactoryBuilder().build(in);
                }
            }
        }
        return factory;
    }
}
