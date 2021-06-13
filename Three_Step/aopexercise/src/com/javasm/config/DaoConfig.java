package com.javasm.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

/**
 * @className: DaoConfig
 * @description:   
 * @author SunHang
 * @createTime 2021/6/12 21:11
 */
@Configuration
@PropertySource("classpath:jdbc.properties")//context:property-placeholder
public class DaoConfig {
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.driverClassName}")
    private String driverClassname;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;
    @Value("${jdbc.initialSize}")
    private Integer initSize;

    //把方法的返回值注册容器,id默认是方法名
    @Bean(initMethod = "init",destroyMethod = "close")
    public DataSource createDruidDataSource(){
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl(url);
        druidDataSource.setDriverClassName(driverClassname);
        druidDataSource.setUsername(username);
        druidDataSource.setPassword(password);
        druidDataSource.setInitialSize(initSize);
        return druidDataSource;
    }
}
