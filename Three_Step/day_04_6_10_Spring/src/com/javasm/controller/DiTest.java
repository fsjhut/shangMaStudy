package com.javasm.controller;

import com.javasm.entity.SysUser;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @className: DiTest
 * @description:   
 * @author SunHang
 * @createTime 2021/6/10 20:53
 */
@Getter
@Setter
@ToString
public class DiTest {
    private String name;
    private String pwd;
    private SysUser sysUser;

    public DiTest(String name, String pwd, SysUser sysUser) {
        this.name = name;
        this.pwd = pwd;
        this.sysUser = sysUser;
    }
    public DiTest(){

    }
}
