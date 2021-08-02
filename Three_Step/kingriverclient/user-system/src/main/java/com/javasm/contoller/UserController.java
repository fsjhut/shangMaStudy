package com.javasm.contoller;

import com.javasm.entity.UserInfo;
import com.javasm.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @className: UserController
 * @description:   
 * @author SunHang
 * @createTime 2021/7/19 14:59
 */
@RestController()
@RequestMapping("user")
public class UserController {
    @Resource
    private UserService userService;
    @GetMapping("/query/{uid}")
    public String getUser(@PathVariable Integer uid){
        String msg = "这个是用户的信息：" + uid;
        return msg;
    }
    @GetMapping("/select/{uid}")
    public UserInfo getUserInfo(@PathVariable Integer uid){
        UserInfo userInfo = userService.selectById(uid);
        return userInfo;
    }
}
