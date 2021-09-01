package com.javasm.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @className: baseServlet
 * @description: 设置一个baseServlet可以实现多个访问不同的地址
 *                需要重写service方法
 * @author SunHang
 * @createTime 2021/5/17 16:53
 */
public class baseServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //重写方法细分规则
        //1.需要让servlet执行的时候 不同的方法 进入同一个servlet   /prod/*
        //2.根据传入的路径 获取需要调用的方法
        /* 获取servlet配置的路径 */
        String requestURI = req.getRequestURI();
        //获取*号中的内容 
        String methodName = requestURI.substring(requestURI.lastIndexOf("/") + 1);
        System.out.println(methodName);
        // 利用反射获取方法的执行
        try {
            Method method = this.getClass().getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            // 方法的执行
            method.invoke(this,req,resp);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            // 返回一个未找到的页面即使
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }
}
