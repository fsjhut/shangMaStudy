package com.javasm.commons.interceptor;

import com.javasm.commons.entity.S;
import com.javasm.commons.exception.MvcException;
import com.javasm.commons.utils.CurrentLoginUser;
import com.javasm.sys.entity.Sysuser;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        Sysuser loginUser = CurrentLoginUser.getLoginUser();
        if(loginUser==null) {
            throw new MvcException(S.NO_LOGIN);
        }
        return true;
    }
}
