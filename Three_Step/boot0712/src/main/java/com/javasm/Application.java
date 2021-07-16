package com.javasm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.javasm.*.dao")
@EnableTransactionManagement //<tx:annotion-driven>
public class Application {

    public static void main(String[] args)
    {
        //初始化spring容器:AnnotationConfigServletWebServerApplicatinContext,加载主配置类
        //主配置类:开启包扫描;注册当前类的包名为扫描路径;ImportSelecter对象来导入jar包中预配置类.
//        SpringApplication.run(Application.class, args);
        SpringApplication springApplication = new SpringApplication(Application.class);
//        springApplication.setBannerMode(Banner.Mode.OFF);
        springApplication.run(args);
    }

}
