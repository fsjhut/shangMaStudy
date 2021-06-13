package com.javasm.service.impl;

import com.javasm.service.SysUserService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * @className: SysUserServiceImpl
 * @description:   
 * @author SunHang
 * @createTime 2021/6/10 12:58
 */
@Service
public class SysUserServiceImpl implements SysUserService,InitializingBean {

    public SysUserServiceImpl(){
        System.out.println("serviceImpl的构造器");
    }
    public void init(){
        System.out.println("ServiceImpl的第一种实例化方法");
    }
    @Override
    public String login(String name, String pwd) {
        System.out.println("Impl的login方法");
        return "欢迎你" + name;
    }

    @Override
    public void logout(String name) {
        System.out.println("Impl的logout方法");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("sysUserServiceImpl的第二种实例化方法");
    }
}
