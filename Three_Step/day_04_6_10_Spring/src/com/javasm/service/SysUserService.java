package com.javasm.service;

/**
 * @author SunHang
 * @className: SysUserService
 * @description:
 * @createTime 2021/6/10 12:58
 */
public interface SysUserService {
    String login(String name,String pwd);
    void logout(String name);

}
