package com.javasm.entity;

import lombok.*;

import java.util.List;

/**
 * @className: SysDept
 * @description:   
 * @author SunHang
 * @createTime 2021/6/8 20:08
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SysDept {
    private Integer deptId;
    private Integer deptParentId;
    private Integer deptManagerId;
    private String deptName;
    private String deptPhone;
    private String updateTime;

    private SysUser sysUser;
    private SysDept sysDept;
    private List<SysUser> sysUsers;

}
