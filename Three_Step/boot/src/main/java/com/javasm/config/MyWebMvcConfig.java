package com.javasm.config;

import com.javasm.interceptor.LoginInterceptor;
import org.springframework.format.FormatterRegistry;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

@Component
public class MyWebMvcConfig implements WebMvcConfigurer {

    @Resource
    private DateConverter dc;

    @Resource
    private LoginInterceptor loginInterceptor;

    //请求参数格式化处理.只用在日期处理.不重要.因为如果是json参数的话,是通过jackson来处理日期
    //没用的东西
//    @Override
//    public void addFormatters(FormatterRegistry registry) {
//        registry.addConverter(dc);
//    }

    //springmvc:访问url,handler返回视图名,在通过视图解析器前缀+视图名+后缀,得到完整视图路径,forward
    //没用,同步开发中使用.用户访问url,返回页面(html(jsp,freemarker,thymleaf)).依赖视图解析器
/*    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/rolelist").setViewName("rl");
        registry.addViewController("/goadd").setViewName("add");
    }*/

    //配置拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor).addPathPatterns("/**").excludePathPatterns("/rolelist", "/goadd");
    }

    //跨域配置<mvc:cors >,基于跨域拦截器生效,一旦自定义了拦截器
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**").allowCredentials(true).allowedHeaders("*").allowedMethods("*").allowedOrigins("http://localhost:8088").exposedHeaders("token");
//    }
}
