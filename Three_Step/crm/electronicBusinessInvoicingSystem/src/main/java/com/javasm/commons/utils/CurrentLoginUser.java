package com.javasm.commons.utils;


import com.javasm.sys.entity.CrmSysuser;
import com.javasm.sys.entity.Sysuser;

import com.javasm.sys.entity.Sysuser;

import com.javasm.sys.entity.CrmSysuser;

public class CurrentLoginUser {

    public static ThreadLocal<CrmSysuser> loginUserThread = new ThreadLocal<>();

    public static void setLoginUser(CrmSysuser u){
        loginUserThread.set(u);
    }

    public static CrmSysuser getLoginUser(){
        //Object login_user = ServletUtil.getSession().getAttribute("LOGIN_USER");
       // if(login_user!=null) return (Sysuser)login_user;
        return loginUserThread.get();
    }

    public static String getUname(){
        CrmSysuser loginUser = getLoginUser();
        if(loginUser==null)return null;
        return loginUser.getUname();
    }
}
