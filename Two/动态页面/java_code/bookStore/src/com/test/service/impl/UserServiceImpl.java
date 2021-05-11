package com.test.service.impl;

import com.test.dao.UserDao;
import com.test.dao.impl.UserDaoImpl;
import com.test.entity.MyUser;
import com.test.service.UserService;

import java.sql.SQLException;
import java.util.List;

/**
 * @className: UserServiceImpl
 * @description:   
 * @author SunHang
 * @createTime 2021/5/10 16:31
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();
//    @Override
//    public MyUser insertUser(MyUser insertUser) {
//        UserDao ud = new UserDaoImpl();
//        //业务逻辑
//        insertUser.setUphone("(+86)"+insertUser.getUphone());
//        return ud.insertUser(insertUser);
//    }

    @Override
    public MyUser login(MyUser loginUser) {
        try {
            return userDao.login(loginUser);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<MyUser> getAllUser() {
        try {
            return userDao.getAllUser();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
