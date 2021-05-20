package test.controller;


import test.entity.MyUser;
import test.service.UserService;
import test.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

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
        HttpSession session = req.getSession();

        UserService us = new UserServiceImpl();
        MyUser loginUser = us.login(inserUser);

        if(loginUser!=null){
            session.setAttribute("loginuser",loginUser);
            //验证成功
            resp.sendRedirect(req.getContextPath()+"/mypage/main.jsp");

        }else{
           // resp.sendRedirect(req.getContextPath()+"/login.jsp");
            req.setAttribute("inserUser",inserUser);
            req.setAttribute("loginFailed","用户名或密码错误");
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
        }
    }
}
