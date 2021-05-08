package com.test.controller;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * @className: TestServlet
 * @description:   
 * @author SunHang
 * @createTime 2021/5/7 16:26
 */
@WebServlet("/test")
public class TestServlet implements Servlet {
    // 实例被创建时，init方法会被触发，可以在里面写自己的逻辑代码
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("01-init示例被创建，初始化----------");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("02--service被运行");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    // 实例被销毁时，destory()会被销毁  ------注意因果关系
    @Override
    public void destroy() {
        System.out.println("04--示例被销毁了---------------");
    }
}
