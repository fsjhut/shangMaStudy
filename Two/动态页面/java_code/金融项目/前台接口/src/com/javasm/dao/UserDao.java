package com.javasm.dao;

import com.javasm.entity.Suggestion;
import com.javasm.entity.User;

import java.sql.SQLException;

/**
 * @author:sunhang
 * @className: UserDao
 * @description:
 * @date: 2021-06-02 10:04
 * @version:0.1
 * @since: 1.8
 */
public interface UserDao {
    User queryById(String uid) throws SQLException;
    int editUser(User user) throws SQLException;
    int suggestion(Suggestion suggestion) throws SQLException;
}
