package com.javasm.entity;

import java.io.Serializable;

/**
 * @className: User
 * @description:   
 * @author SunHang
 * @createTime 2021/7/20 15:13
 */
public class UserInfo  {
    private String userId;
    private String userName;
    private String userInfo;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(String userInfo) {
        this.userInfo = userInfo;
    }
}
