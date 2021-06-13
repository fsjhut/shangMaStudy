package com.javasm.factory;


import com.javasm.entity.SysUser;

/**
 * @className: SessionFactoryBean
 * @description:   
 * @author SunHang
 * @createTime 2021/6/10 20:04
 */
public class SessionFactoryBean {
    public SysUser createFactory(){
        return new SysUser();
    }
}
