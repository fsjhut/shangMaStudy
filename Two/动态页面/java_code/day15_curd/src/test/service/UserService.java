package test.service;

import test.entity.MyUser;

import java.util.List;

public interface UserService {

    Integer insertUser(MyUser insertUser);
    MyUser login(MyUser loginUser);
    List<MyUser> getAllUser();
}
