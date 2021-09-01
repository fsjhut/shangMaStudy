package com.javasm.entity;

import lombok.*;

import java.util.Date;

/**
 * @author:sunhang
 * @className: User
 * @description:
 * @date: 2021-06-02 16:10
 * @version:0.1
 * @since: 1.8
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String uid;
    private String userName;
    private String phone;
    private Integer gender;
    private String headPic;
    private String headPicThumb;
    private String hobby;
    private Integer grade;
    private String desc;
    private Date birthday;
}
