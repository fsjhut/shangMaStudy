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
import java.util.List;

@WebServlet("/user")
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        //获取登录的用户对象
        MyUser user = (MyUser) session.getAttribute("loginuser");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        if(user!=null){
            //正常提供服务
            //提供服务的代码
            UserService us = new UserServiceImpl();
            List<MyUser> allUser = us.getAllUser();
            writer.print("<html>");
            writer.print("<head>");
            writer.print("<title>userpage</title>");
            writer.print("<link rel=\"stylesheet\" type=\"text/css\" href=\""+req.getContextPath()+"/css/bootstrap.css\"/>");
            writer.print("</head>");
            writer.print("<body>");
            writer.print("欢迎你 "+user.getUname());
           writer.print("<hr/>");
           writer.print("<table class='table'>");
            writer.print("<caption>用户表</caption>");
            writer.print("<thead>");
            writer.print("<tr>");
            writer.print("<th>用户id</th><th>用户名</th><th>用户电话</th><th>备注</th>");
            writer.print("</tr>");
            writer.print("</thead>");
            writer.print("<tbody>");

            for(MyUser mu : allUser){
                writer.print("<tr>");
                writer.print("<td>");
                writer.print(mu.getUid());
                writer.print("</td>");
                writer.print("<td>");
                writer.print(mu.getUname());
                writer.print("</td>");
                writer.print("<td>");
                writer.print(mu.getUphone());
                writer.print("</td>");
                writer.print("<td>");
                writer.print(mu.getUremark());
                writer.print("</td>");
                writer.print("</tr>");
            }

            writer.print("</tbody>");
            writer.print("</table>");
            writer.print("</body>");
            writer.print("</html>");
        }else{
            writer.print("您还没有登录 请先<a href='"+req.getContextPath()+"/loginPage.html'>登录</a>");
        }
        writer.flush();
        writer.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
