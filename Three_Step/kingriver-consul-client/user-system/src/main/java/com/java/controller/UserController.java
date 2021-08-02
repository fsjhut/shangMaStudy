package com.java.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @className: UserController
 * @description:   
 * @author SunHang
 * @createTime 2021/7/19 18:04
 */
@RestController
public class UserController {
    @RequestMapping("/query/{uid}")
    public String queryUser(@PathVariable Integer uid){

        String userInfo = "欢迎使用用户查询模块："+ uid;
        return userInfo;
    }
}
