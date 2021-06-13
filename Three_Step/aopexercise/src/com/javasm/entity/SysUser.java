package com.javasm.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @className: SysUser
 * @description:   
 * @author SunHang
 * @createTime 2021/6/11 19:18
 */
@Getter
@Setter
@ToString
public class SysUser {
    private Integer uid;
    private String uname;
    private String upwd;

    public SysUser(String uname, String upwd) {
        this.uname = uname;
        this.upwd = upwd;
    }

    public SysUser() {
    }
}
