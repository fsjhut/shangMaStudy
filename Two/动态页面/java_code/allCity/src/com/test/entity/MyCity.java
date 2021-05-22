package com.test.entity;

import lombok.*;

/**
 * @className: MyCity
 * @description:   
 * @author SunHang
 * @createTime 2021/5/22 10:23
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MyCity {
    private Integer id;
    private Integer pid;
    private String areaName;
    private Integer type;
}
