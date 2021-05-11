package com.javasm.test;

import com.javasm.dao.UserDao;
import com.javasm.dao.impl.UserDaoImpl;
import com.javasm.entity.MyUser;

import java.util.List;

public class MyTest {
    public static void main(String[] args) {
        UserDao ud = new UserDaoImpl();
/*        MyUser newuser = new MyUser("bbb2","bbb");
        MyUser login = ud.login(newuser);*/
        List<MyUser> allUser = ud.getAllUser();
        System.out.println(allUser);

    }

}
