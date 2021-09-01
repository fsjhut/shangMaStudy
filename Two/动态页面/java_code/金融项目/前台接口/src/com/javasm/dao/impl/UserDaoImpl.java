package com.javasm.dao.impl;

import com.javasm.dao.UserDao;
import com.javasm.entity.Suggestion;
import com.javasm.entity.User;

import java.sql.SQLException;

/**
 * @author:sunhang
 * @className: UserDaoImpl
 * @description:
 * @date: 2021-06-02 10:05
 * @version:0.1
 * @since: 1.8
 */
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {
    private String sql;
    @Override
    public User queryById(String uid) throws SQLException {
        sql = "";
        return queryOne(sql, uid);
    }
    @Override
    public int editUser(User user) throws SQLException {
        sql = "";
        return update(sql, );
    }

    @Override
    public int suggestion(Suggestion suggestion) throws SQLException {
        sql = "";
        return update(sql, );
    }
}
