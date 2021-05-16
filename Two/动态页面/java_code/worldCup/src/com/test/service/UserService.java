package com.test.service;

import com.test.entity.User;

/**
 * @author SunHang
 * @className: UserService
 * @description:
 * @createTime 2021/5/15 14:33
 */
public interface UserService {
    User selectByName(String userName);

    Integer getCardNo(User myUser);

    void updateUser(User myUser);
}
