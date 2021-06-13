package com.javasm.entity;

import lombok.*;

import java.util.List;

/**
 * @className: Sysrole
 * @description:   
 * @author SunHang
 * @createTime 2021/6/8 19:56
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SysRole {
    private Integer rid;
    private String rname;
    private String rdesc;
    private String createTime;
    private String updateTime;

    private List<SysUser> sysUsers;
    private List<SysPermission> sysPermissions;
}
