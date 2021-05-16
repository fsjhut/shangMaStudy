package com.javasm.dao;

import com.javasm.entity.MyUser;

import java.util.List;

public interface UserDao {
    //用户插入方法  入参 用户对象 返回值 执行成功的记录数
    int insertUser(MyUser insertUser);
    MyUser login(MyUser loginUser);

    List<MyUser> getAllUser();

}
