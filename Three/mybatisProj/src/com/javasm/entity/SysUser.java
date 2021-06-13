package com.javasm.entity;

import lombok.*;

import java.util.List;

/**
 * @className: Sysuser
 * @description:   
 * @author SunHang
 * @createTime 2021/6/8 19:56
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SysUser {
    private Integer uid;
    private Integer rid;
    private Integer deptId;
    private Integer userGender;
    private String uname;
    private String upwd;
    private String uphone;
    private String uwechat;
    private String uemail;
    private String createTime;
    private String updateTime;
    private String createBy;

    private SysRole sysRole;
    private SysDept sysDept;
    private SysDicts sysDicts;
    private List<SysPermission> permissions;

    public SysUser(Integer deptId, String uname, String upwd) {
        this.deptId = deptId;
        this.uname = uname;
        this.upwd = upwd;
    }
}
