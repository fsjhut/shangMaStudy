package com.javasm.entity;

import lombok.*;

import java.util.List;

/**
 * @className: Sysrole
 * @description:   
 * @author SunHang
 * @createTime 2021/6/8 12:38
 */
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Sysrole {
    private Integer rid;
    private String rname;
    private String rdesc;
    private String createTime;
    private String updateTime;
    private List<Sysuser> allUser;
}
