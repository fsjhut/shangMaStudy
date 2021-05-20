package com.javasm.controller2;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

public class BaseServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //重写方法细分规则
        //1.需要让servlet执行的时候 不同的方法 进入同一个servlet   /prod/*
        //2.根据传入的路径 获取需要调用的方法
        /* 获取servlet配置的路径 */
        String servletPath = req.getServletPath();
        /* 统一资源标识符    */
        String requestURI = req.getRequestURI();
        /* 统一资源定位符    */
        StringBuffer requestURL1 = req.getRequestURL();
        System.out.println(servletPath);
        System.out.println(requestURI);
        System.out.println(requestURL1);
        System.out.println(requestURI.substring(requestURI.lastIndexOf("/")+1) );
        String methodName = requestURI.substring(requestURI.lastIndexOf("/")+1);

        try {
            Method method = this.getClass().getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(this,req,resp);
        } catch (Exception e) {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
            //e.printStackTrace();
        }
    }
}
