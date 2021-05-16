package com.test.controller;

import com.test.entity.MyUser;
import com.test.service.UserService;
import com.test.service.impl.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @className: Login
 * @description:   
 * @author SunHang
 * @createTime 2021/5/10 16:30
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
//        req.setCharacterEncoding("utf-8");
//        System.out.println("1111");
//        String name = req.getParameter("username");
//        String pwd = req.getParameter("password");
//        MyUser insertUser = new MyUser(name,pwd);
//        // 验证用户名和密码
//        resp.setContentType("text/html;charset=utf-8");
//        PrintWriter writer = resp.getWriter();
//        HttpSession session = req.getSession();
//
//        UserService userService = new UserServiceImpl();
//        MyUser loginUser = userService.login(insertUser);
//
//        if(loginUser!=null){
//            session.setAttribute("loginUser",loginUser);
//
//            //验证成功
////            writer.print("欢迎你 请使用服务<br/>");
////            writer.print("<a href='"+req.getContextPath()+"/user'>用户服务</a>");
////            writer.print("<a href='"+req.getContextPath()+"/order'>订单服务</a>");
//            // 请求转发
//            RequestDispatcher view = req.getRequestDispatcher("http://localhost:8080/book/pages/manager/manager.html");
//            view.forward(req,resp);
//        }else{
//            writer.print("用户名或密码错误 请<a href='"+req.getContextPath()+"/pages/user/login.jsp'>重新登录</a>");
//        }
//
//        writer.flush();
//        writer.close();
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("1111");
        req.setCharacterEncoding("utf-8");
        String name = req.getParameter("username");
        System.out.println(name);
        String pwd = req.getParameter("password");
        MyUser insertUser = new MyUser(name,pwd);
        // 验证用户名和密码
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        HttpSession session = req.getSession();

        UserService userService = new UserServiceImpl();
        MyUser loginUser = userService.login(insertUser);

        if(loginUser!=null){
            session.setAttribute("loginUser",loginUser);

            //验证成功
//            writer.print("欢迎你 请使用服务<br/>");
//            writer.print("<a href='"+req.getContextPath()+"/user'>用户服务</a>");
//            writer.print("<a href='"+req.getContextPath()+"/order'>订单服务</a>");
            // 请求转发
//            RequestDispatcher view = req.getRequestDispatcher("/pages/manager/manager.jsp");
//            view.forward(req,resp);
            // 重定向
            resp.sendRedirect(req.getContextPath()+"/pages/manager/manager.jsp");
        }else{
            writer.print("用户名或密码错误 请<a href='"+req.getContextPath()+"/pages/user/login.jsp'>重新登录</a>");
        }

        writer.flush();
        writer.close();
    }
}
