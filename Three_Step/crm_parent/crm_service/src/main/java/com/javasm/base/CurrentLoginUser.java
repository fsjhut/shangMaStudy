package com.javasm.base;

import com.javasm.commons.utils.ServletUtil;
import com.javasm.sys.entity.Sysuser;

/**
 * @author SunHang
 * @className: CurrentLoginUser
 * @description:
 * @createTime 2021/6/17 21:10
 */
public class CurrentLoginUser {


    public static void setLoginUser(Sysuser user) {
        ServletUtil.getSession().setAttribute("LOGIN_USER", user);
    }

    public static Sysuser getLoginUser() {
        Object login_user = ServletUtil.getSession().getAttribute("LOGIN_USER");
        return login_user != null ? (Sysuser) login_user : null;
    }

    public static String getUname() {
        Sysuser loginUser = getLoginUser();
        return loginUser == null ? null : loginUser.getUname();
    }
}

