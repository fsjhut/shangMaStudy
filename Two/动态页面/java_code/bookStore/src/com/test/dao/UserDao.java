package com.test.dao;

import com.test.entity.MyUser;

import java.sql.SQLException;
import java.util.List;

/**
 * @author SunHang
 * @className: UserDao
 * @description:
 * @createTime 2021/5/10 16:30
 */
public interface UserDao {
    MyUser login(MyUser loginUser) throws SQLException;

    List<MyUser> getAllUser() throws SQLException;

}
