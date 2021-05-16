package com.test.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

/**
 * @className: User
 * @description:   
 * @author SunHang
 * @createTime 2021/5/15 14:34
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String userName;
    private Integer goalCount;
    private ArrayList<Integer> getCard;
    private ArrayList<Integer> noCard;

    public User(String userName) {
        this.userName = userName;
    }
}
