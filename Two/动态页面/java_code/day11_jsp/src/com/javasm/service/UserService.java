package com.javasm.service;

import com.javasm.entity.MyUser;

import java.util.List;

public interface UserService {

    int insertUser(MyUser insertUser);
    MyUser login(MyUser loginUser);
    List<MyUser> getAllUser();
}
