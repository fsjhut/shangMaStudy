package com.javasm.commons.utils;

import com.javasm.sys.entity.Sysuser;

public class CurrentLoginUser {
    public static void setLoginUser(Sysuser u){
        ServletUtil.getSession().setAttribute("LOGIN_USER",u);
    }

    public static Sysuser getLoginUser(){
        Object login_user = ServletUtil.getSession().getAttribute("LOGIN_USER");
        if(login_user!=null) {
            return (Sysuser)login_user;
        }
        return null;
    }

    public static String getUname(){
        Sysuser loginUser = getLoginUser();
        if(loginUser==null)return null;
        return loginUser.getUname();
    }
}
