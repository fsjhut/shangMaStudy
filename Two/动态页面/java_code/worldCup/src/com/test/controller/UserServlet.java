package com.test.controller;

import com.alibaba.fastjson.JSON;
import com.test.entity.ReturnEntity;
import com.test.entity.User;
import com.test.service.UserService;
import com.test.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @className: UserServlet
 * @description:   
 * @author SunHang
 * @createTime 2021/5/15 14:32
 */
@WebServlet("/getcount")
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 接口的文档信息
        /*获取商品信息服务接口
         * 接口访问地址  : getcount
         * 接收的参数    : "userName":"aaaa"
         * 接收方式      : post
         * 返回数据格式  : json
         ** */
        req.setCharacterEncoding("utf-8");
        String userName = req.getParameter("userName");
        UserService userService = new UserServiceImpl();
        User myUser = userService.selectByName(userName);
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        ReturnEntity re = new ReturnEntity();
        // 判断是否查询到数据
        if(myUser!=null){
            re.setCode(200);
            re.setReturnMsg("获取对象成功");
            re.setReturnData(myUser);
        }else{
            re.setCode(400);
            re.setReturnMsg("获取用户对象失败");
        }
        // 将对象ReturnEntity()转为json
        writer.print(JSON.toJSONString(re));
        writer.flush();
        writer.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
