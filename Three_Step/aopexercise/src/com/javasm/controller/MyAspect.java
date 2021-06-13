package com.javasm.controller;

import com.javasm.annotation.an;
import com.javasm.utils.JDBCUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author SunHang
 * @className: MyAspect
 * @description:
 * @createTime 2021/6/11 21:32
 */

@Controller//注册容器
@Aspect//定义该bean时切面对象
public class MyAspect {
    @Resource
    private MyTransactionManager manager;


    @Pointcut("@annotation(com.javasm.annotation.an)")
    public void pc(){}

//    @Pointcut("execution(* com.javasm.*.service.impl.*.*(..))")
//    public void pc2(){}

    @Around("pc()")
    public Object aroundAdvice(ProceedingJoinPoint jp){
        //jp对象能够得到所有连接点信息
        Object result = null;
        Connection conn = null;
        try {
            conn = manager.getConn();
            manager.beginWork(conn);
            result = jp.proceed();//Object result = method.invoke(target,args)
            manager.commitWork(conn);
        } catch (Throwable throwable) {
            try {
                manager.rollBackWork(conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } finally {
            try {
                manager.closeWork(conn);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }

}
