package com.javasm.controller;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/demo1")
public class ServletDemo1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //request对象  HttpServletRequest req
        //在不同的请求间 每次会新建request对象
        //request在多次请求间独立

        //session  在同一个用户多次访问时 使用同一个session对象
        //不同用户间独立
        //1.超过服务器设置的有效时间
        //2.浏览器关闭
        //3.服务器设置session失效

        //servletContext 服务器对象 全局共享
        //尽量不要做写操作
        /*
        * 把一些常用的数据(在数据库中的) 直接加载到内存中 方便使用
        *
        *
        * */


        req.setAttribute("reqkey","reqval");

        String reqkey = (String) req.getAttribute("reqkey");
        System.out.println(reqkey);
        //HttpSession session  会话对象
        HttpSession session = req.getSession();
        session.setAttribute("seskey","sesval");
        String seskey = (String) session.getAttribute("seskey");
        System.out.println(seskey);

        //ServletContext 服务器对象
        ServletContext servletContext = req.getServletContext();

        servletContext.setAttribute("contextkey","contextval");

        String contextkey = (String) servletContext.getAttribute("contextkey");
        System.out.println(contextkey);
    }
}
