package com.javasm.commons.utils;

import com.javasm.sys.entity.Sysuser;

/**
 * @author SunHang
 * @className: CurrentLoginUser
 * @description:
 * @createTime 2021/6/17 21:10
 */
public class CurrentLoginUser {

    private static ThreadLocal<Sysuser> loginUserThread = new ThreadLocal<>();

    public static void setLoginUser(Sysuser user) {
        loginUserThread.set(user);
//        ServletUtil.getSession().setAttribute("LOGIN_USER", user);

    }

    public static Sysuser getLoginUser() {
//        Object login_user = ServletUtil.getSession().getAttribute("LOGIN_USER");
//        return login_user != null ? (Sysuser) login_user : null;
        return loginUserThread.get();
    }

    public static String getUname() {
        Sysuser loginUser = getLoginUser();
        return loginUser == null ? null : loginUser.getUname();
    }
}

