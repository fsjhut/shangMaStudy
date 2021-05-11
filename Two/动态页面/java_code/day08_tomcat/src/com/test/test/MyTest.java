package com.test.test;

import com.test.entity.MyUser;
import com.test.dao.UserDao;
import com.test.dao.impl.UserDaoImpl;

/**
 * @author SunHang
 * @className: myTest
 * @description:
 * @createTime 2021/5/8 15:36
 */

public class MyTest {
    public static void main(String[] args) {
        UserDao ud = new UserDaoImpl();
        MyUser newuser = new MyUser("sun");
        int i = ud.insertUser(newuser);
        System.out.println(i);
    }
}

