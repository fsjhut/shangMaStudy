package com.javasm;

import com.javasm.config.AppConfig;
import com.javasm.dao.SqlDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @className: TestAppConfig
 * @description:   
 * @author SunHang
 * @createTime 2021/6/12 21:05
 */
public class TestAppConfig {
    @Test
    public void test1_initApplication(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        SqlDao bean = ac.getBean(SqlDao.class);
        System.out.println(bean);
    }
}
