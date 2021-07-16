package com.javasm.commons.interceptor;


import com.javasm.commons.cache.Keys;
import com.javasm.commons.cache.RedisService;
import com.javasm.commons.entity.S;
import com.javasm.commons.exception.MvcException;
import com.javasm.commons.utils.JJWTUtil;
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

        //获取请求头中的token字符串
        String token = request.getHeader("token");
        System.out.println("token=="+token);

        //如果为null，则未登录
        if (token == null) throw new MvcException(S.NO_LOGIN);

        //校验token
        Claims claims = JJWTUtil.parse(token);
        if (claims == null) throw new MvcException(S.NO_LOGIN);
        String uname = JJWTUtil.getUname(claims);


        String userStr = rs.hget(Keys.USERS_HASH, uname);
        //Sysuser loginUser = JSON.parseObject(userStr, Sysuser.class);
        //com.bjpowernode.commons.utils.CurrentLoginUser.setLoginUser(loginUser);

        //设置token时间为30分钟，如果三十分钟用户没有发情任何请求，则需要从新登陆
        //如果三十分钟内用户发起任何一个请求，在从新计时30分钟
        //来达到刷新token的目的
        String newToken = JJWTUtil.generate(uname);
        response.addHeader("token", newToken);

        return true;






    }


}
