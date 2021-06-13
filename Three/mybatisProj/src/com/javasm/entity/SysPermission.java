package com.javasm.entity;

import lombok.*;

import java.util.List;

/**
 * @className: SysPermission
 * @description:   
 * @author SunHang
 * @createTime 2021/6/8 20:11
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SysPermission {
    private Integer pid;
    private Integer perParentId;
    private String pname;
    private String perPath;
    private String createTime;
    private String updateTime;
    private Integer persort;

    private List<SysRole> sysRoles;
}
