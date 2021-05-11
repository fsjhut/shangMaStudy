package com.javasm.controller2;

import com.javasm.entity.MyUser;
import com.javasm.service.UserService;
import com.javasm.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*
        * uname: 小明
          upwd: 123
        *
        * */
        req.setCharacterEncoding("utf-8");
        String uname = req.getParameter("uname");
        String upwd = req.getParameter("upwd");
        MyUser inserUser = new MyUser(uname,upwd);
        //验证用户名密码
/*
  session典型场景
* 1.访问控制   粗粒度  登录访问控制
* 2.共享数据
*
* */

        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        HttpSession session = req.getSession();

        UserService us = new UserServiceImpl();
        MyUser loginUser = us.login(inserUser);

        if(loginUser!=null){
            session.setAttribute("loginuser",loginUser);

            //验证成功
            writer.print("欢迎你 请使用服务<br/>");
            writer.print("<a href='"+req.getContextPath()+"/user'>用户服务</a>");
            writer.print("<a href='"+req.getContextPath()+"/order'>订单服务</a>");
        }else{
            writer.print("用户名或密码错误 请<a href='"+req.getContextPath()+"/loginPage.html'>重新登录</a>");
        }

        writer.flush();
        writer.close();

    }
}
