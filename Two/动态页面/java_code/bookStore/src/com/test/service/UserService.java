package com.test.service;

import com.test.entity.MyUser;

import java.util.List;

/**
 * @author SunHang
 * @className: UserService
 * @description:
 * @createTime 2021/5/10 16:31
 */
public interface UserService {
    MyUser login(MyUser inserUser);

    List<MyUser> getAllUser();
}
