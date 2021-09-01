package com.javasm.controller;

import com.alibaba.fastjson.JSON;
import com.javasm.entity.Menu;
import com.javasm.entity.ReturnCode;
import com.javasm.entity.ReturnEntity;
import com.javasm.entity.User;
import com.javasm.service.LoginService;
import com.javasm.service.impl.LoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/user/*")
public class UserServlet extends baseServlet {

    // 根据id查询单个用户的详细信息
    public void query(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        // 自定义的查询方法
        System.out.println("查询");
        req.setCharacterEncoding("utf-8");
        // 获取前端页面传递的参数
        String uid = req.getParameter("uid");


    }
}
