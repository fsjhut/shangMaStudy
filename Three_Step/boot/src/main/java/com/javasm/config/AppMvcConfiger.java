package com.javasm.config;

import com.javasm.interceptor.LoginInterceptor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

@Component
public class AppMvcConfiger implements WebMvcConfigurer {

    @Resource
    private LoginInterceptor loginIterceptor;
    //拦截器配置
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(loginIterceptor).addPathPatterns("/**").excludePathPatterns("");
    }


}
