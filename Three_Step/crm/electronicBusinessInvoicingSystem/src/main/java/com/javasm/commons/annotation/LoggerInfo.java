package com.javasm.commons.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)//定义注解类型
@Target({ElementType.METHOD })//注解目标
@Documented
public @interface LoggerInfo {
    String operModul() default ""; // 操作模块

    String operType() default ""; // 操作类型

    String operDesc() default ""; // 操作说明

}
