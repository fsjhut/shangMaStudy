package com.javasm.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

@WebServlet("/mytest/*")
public class ServletDemo4 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*
          setCharacterEncoding  设置解析报文的字符编码
        * getParameter        获取普通参数
        * getParameterValues  获取同名参数
        * getParameterMap     获取完整参数键值对
        * getInputStream      获取请求正文部分的输入流
        * setAttribute
        * getAttribute
        * getContextPath      获取项目入口  与servletContext.getContextPath 相同
        *
        * req.getScheme()     获得协议
        * req.getServerName()  获取服务器地址
        * req.getServerPort()  获取服务器端口
        *
        * req.getServletContext().getRealPath("/"); 通过服务器对象获取 tomcat运行的代码的真实地址
        * req.getServletPath()  获取servlet的配置的路径 如果有通配符* 会忽略通配符
        * req.getRequestURI()   获取当次请求的路径
        * req.getRequestURL()   获取当次请求的真实路径
        *
        *
        * */

/*
        String myname = req.getParameter("myname");
        String[] hobbies = req.getParameterValues("hobby");

        for(String val:hobbies){
            System.out.println(val);
        }
*/
/*
        Map<String, String[]> parameterMap = req.getParameterMap();
        System.out.println(parameterMap.get("myname")[0]);*/
        //获取请求正文的输入流 如果把流读走 tomcat读不到了
        //可以自己按照需要的规则解析请求传递的参数
/*        BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
        String s = br.readLine();
        System.out.println(s);*/
/*        String myname = req.getParameter("myname");
        System.out.println(myname);
        String contextPath = req.getContextPath();
        System.out.println(contextPath);*/

        String myurl = req.getScheme()+"://"+req.getServerName()+":"+req.getServerPort()+req.getContextPath()+"/";
        System.out.println(myurl);

        //req.getRealPath()//获取服务器在本地的路径  //获取tomcat运行的项目的真实路径
        String realPath = req.getServletContext().getRealPath("/");

        System.out.println(realPath);
        //servlet配置的访问地址
        //servlet配置的路径 会忽略通配符部分
        // /mytest
        String servletPath = req.getServletPath();
        //相对根路径   URI 统一资源标示符
        //获取当次访问的路径  会在路径中体现出对应的填入地址 包含通配符部分
        ///day10/mytest/abc  /day10/mytest/ffff
        String requestURI = req.getRequestURI();
        //访问的真实路径 URL 统一资源定位符
        StringBuffer requestURL = req.getRequestURL();
        System.out.println(servletPath);
        System.out.println(requestURI);
        System.out.println(requestURL);


    }
}
