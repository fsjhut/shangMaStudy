package com.javasm.config;

import com.javasm.dao.impl.SqlDaoImpl;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;

/**
 * @className: AppConfig
 * @description:   
 * @author SunHang
 * @createTime 2021/6/12 21:04
 */
@Configuration//表示当前类是一个配置类,同时该类会被注册容器
@ComponentScan("com.javasm")//<context:component-scan>
@EnableAspectJAutoProxy//开启aop注解识别
@Import(DaoConfig.class)
@ImportResource("classpath:dao.xml")
public class AppConfig {

    //先按照形参名注入,再按照形参类型注入值
    @Bean
    public SqlDaoImpl createUserDao(DataSource dataSource){
        SqlDaoImpl sysuserDao = new SqlDaoImpl();
        sysuserDao.setDataSource(dataSource);
        return  sysuserDao;
    }
}
