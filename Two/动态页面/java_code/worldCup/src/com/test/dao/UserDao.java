package com.test.dao;

import com.test.entity.User;

/**
 * @author SunHang
 * @className: UserDao
 * @description:
 * @createTime 2021/5/15 14:33
 */
public interface UserDao {
    User selectByName(String userName);

    void updateUser(User myUser);
}
