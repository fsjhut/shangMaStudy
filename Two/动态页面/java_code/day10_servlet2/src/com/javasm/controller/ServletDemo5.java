package com.javasm.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebServlet("/demo5")
public class ServletDemo5 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String id = session.getId();
        /*
        * MaxInactiveInterval  最大有效非活动时间 (两次有效访问的间隔)
        *超过最大有效非活动时间之后 session会失效  tomcat默认设置 半个小时
        *session失效
        *1.超过最大有效非活动时间 tomcat默认设置 半个小时  setMaxInactiveInterval(秒)
        *2.用户关闭浏览器
        *3.invalidate() 设置session对象失效 会清掉所有数据
        *
        * removeAttribute()清除键值对  登出时 把用户登录setAttribute("xxx")
        *                                               removeAttribute("xxx")
        * */
        //session.setMaxInactiveInterval(5);
        session.invalidate();
        //session.removeAttribute("key");
        System.out.println(id);


    }
}
