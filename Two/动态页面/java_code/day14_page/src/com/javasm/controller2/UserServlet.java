package com.javasm.controller2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

@WebServlet("/user/*")
public class UserServlet extends BaseServlet {


    public void mytest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("执行了mytest");


    }

}
