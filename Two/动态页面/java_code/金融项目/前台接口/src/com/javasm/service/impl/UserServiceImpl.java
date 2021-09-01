package com.javasm.service.impl;

import com.javasm.dao.UserDao;
import com.javasm.dao.impl.UserDaoImpl;
import com.javasm.entity.Suggestion;
import com.javasm.entity.User;
import com.javasm.service.UserService;

import java.sql.SQLException;

/**
 * @author:sunhang
 * @className: UserServiceImpl
 * @description:
 * @date: 2021-06-02 10:06
 * @version:0.1
 * @since: 1.8
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao  =  new UserDaoImpl();
    @Override
    public User queryOneById(String uid){
        User user = null;
        try {
            user = userDao.queryById(uid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
    @Override
    public int updateUser(User user){
        int opt = -1;
        try {
            opt = userDao.editUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return opt;
    }

    @Override
    public int userIdea(Suggestion suggestion){
        int opt = -1;
        try {
            opt = userDao.suggestion(suggestion);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return opt;
    }
}
