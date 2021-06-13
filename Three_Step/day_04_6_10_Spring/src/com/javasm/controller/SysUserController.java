package com.javasm.controller;

import com.javasm.service.SysUserService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @className: SysUserController
 * @description:   
 * @author SunHang
 * @createTime 2021/6/10 12:44
 */
@Getter
@Setter
@Controller
public class SysUserController {
    @Autowired
    private SysUserService userService;
    public SysUserController(){
        System.out.println("SysUserController构造器");
    }
    public void login(){
        System.out.println("--------login-------");
    }
    public void exists(){
        System.out.println("--------退出-------");
    }
}
