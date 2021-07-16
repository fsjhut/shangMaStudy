package com.javasm.commons.interceptor;


import com.alibaba.fastjson.JSON;
import com.javasm.commons.cache.Keys;
import com.javasm.commons.cache.RedisService;
import com.javasm.commons.entity.S;
import com.javasm.commons.exception.MvcException;
import com.javasm.commons.utils.CurrentLoginUser;
import com.javasm.commons.utils.JJWTUtil;
import com.javasm.sys.entity.CrmSysuser;
import io.jsonwebtoken.Claims;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {

    @Resource
    private RedisService rs;

    //前拦截器
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String token = request.getHeader("token");
        System.out.println("token=="+token);
        //System.out.println("getRequestURI=="+request.getRequestURI());

        if (token == null) throw new MvcException(S.NO_LOGIN);

        Claims claims = JJWTUtil.parse(token);
        if (claims == null) throw new MvcException(S.NO_LOGIN);
        String uname = JJWTUtil.getUname(claims);


        String userStr = rs.hget(Keys.USERS_HASH, uname);

        CrmSysuser sysuser = JSON.parseObject(userStr, CrmSysuser.class);
        //System.out.println("sysuser===="+sysuser);
        CurrentLoginUser.setLoginUser(sysuser);

        String newToken = JJWTUtil.generate(uname);
        response.addHeader("token", newToken);

        return true;
    }


}
