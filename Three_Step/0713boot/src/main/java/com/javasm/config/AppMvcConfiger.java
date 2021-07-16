package com.javasm.config;

import com.javasm.interceptor.LoginIterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

@Component
public class AppMvcConfiger implements WebMvcConfigurer {

    @Resource
    private LoginIterceptor loginIterceptor;
    //拦截器配置
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(loginIterceptor).addPathPatterns("/**").excludePathPatterns("");
    }


}
