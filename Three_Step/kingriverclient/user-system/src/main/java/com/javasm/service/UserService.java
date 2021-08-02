package com.javasm.service;

import com.javasm.entity.UserInfo;

/**
 * @author SunHang
 * @className: UserService
 * @description:
 * @createTime 2021/7/20 15:15
 */
public interface UserService {
    UserInfo selectById(Integer uid);
}
