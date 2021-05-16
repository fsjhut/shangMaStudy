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
import java.util.ArrayList;

/**
 * @className: GoBall
 * @description:   
 * @author SunHang
 * @createTime 2021/5/16 16:21
 */
@WebServlet("/startball")
public class GoBall extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 接口的文档信息
        /*踢球服务接口
         * 接口访问地址  : startball
         * 接收的参数    : "goStatus":0/1 1:进球  0：未进球
         *              : "userName":"aaaa"
         * 接收方式      : post
         * 返回数据格式  : json
         ** */
        req.setCharacterEncoding("utf-8");
        String userName = req.getParameter("userName");
        String status = req.getParameter("goStatus");
        UserService userService = new UserServiceImpl();
        User myUser = userService.selectByName(userName);
        // 用户剩余次数-1
        myUser.setGoalCount(myUser.getGoalCount()-1);
        Integer cardNo = -1;
        if("1".equals(status)){
            cardNo = userService.getCardNo(myUser);
//            System.out.println(cardNo);
            ArrayList<Integer> getCard = myUser.getGetCard();
            getCard.add(cardNo);
            ArrayList<Integer> noCard = myUser.getNoCard();
            for (int i = 0; i < noCard.size(); i++) {
                if(cardNo.equals(noCard.get(i))){
                    noCard.remove(i);
                }
            }
            myUser.setGetCard(getCard);
            myUser.setNoCard(noCard);
        }
        // 更新数据库信息 用户剩余次数，已抽中卡片  未抽中卡片
        userService.updateUser(myUser);

        resp.setContentType("application/json;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        ReturnEntity re = new ReturnEntity();
        // 判断是否查询到数据
        if(myUser!=null){
            re.setCode(200);
            re.setReturnMsg("获取用户对象成功");
            re.setCardNo(cardNo);
        }else{
            re.setCode(400);
            re.setReturnMsg("获取用户对象失败");
            re.setCardNo(-1);
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
