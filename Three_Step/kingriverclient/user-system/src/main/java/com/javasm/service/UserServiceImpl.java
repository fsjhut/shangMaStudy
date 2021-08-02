package com.javasm.service;

import com.javasm.entity.UserInfo;
import org.springframework.stereotype.Service;

/**
 * @className: UserServiceImpl
 * @description:   
 * @author SunHang
 * @createTime 2021/7/20 15:15
 */
@Service
public class UserServiceImpl implements UserService{

    @Override
    public UserInfo selectById(Integer uid) {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(String.valueOf(uid));
        userInfo.setUserInfo("我是用户模块的userinfo：");
        userInfo.setUserName("hhhh");
        return userInfo;
    }
}
