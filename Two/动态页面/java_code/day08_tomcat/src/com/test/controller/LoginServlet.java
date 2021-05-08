package com.test.controller;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @className: LoginServlet
 * @description:   
 * @author SunHang
 * @createTime 2021/5/7 16:04
 */
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String mykey = this.getInitParameter("mykey");
        System.out.println(mykey);
        // 设置编码格式，告诉tomcat，利用什么编码格式来解析数据  用来处理请求时的乱码 使用细节：在getParameter之前执行
        req.setCharacterEncoding("utf-8");
        // 获取url中的参数  参数名为 myname
        String myname = req.getParameter("myname");
        ServletContext servletContext = this.getServletContext();
        String mykeyg = servletContext.getInitParameter("mykeyg");
        System.out.println(mykeyg);
        // 设置响应头,根据什么格式解析数据 --处理响应乱码---告诉游览器如何处理响应报文
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.print("hello <span>" + myname + "</span>");
        writer.print("loginOK!!!");
        writer.flush();
        writer.close();
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp){

    }

}
