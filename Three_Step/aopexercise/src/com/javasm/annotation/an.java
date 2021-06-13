package com.javasm.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @className: an
 * @description:   
 * @author SunHang
 * @createTime 2021/6/11 21:37
 */
@Retention(RetentionPolicy.RUNTIME)//定义注解的类型
@Target({ElementType.METHOD})//定义注解目标
public @interface an {

}
