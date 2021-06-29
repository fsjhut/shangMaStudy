package com.javasm.commons.interceptor;

import com.alibaba.fastjson.JSON;
import com.javasm.commons.cache.Keys;
import com.javasm.commons.cache.RedisService;
import com.javasm.commons.entity.S;
import com.javasm.commons.exception.MvcException;
import com.javasm.commons.utils.CurrentLoginUser;
import com.javasm.commons.utils.JJWTUtil;
import com.javasm.sys.entity.Sysuser;
import io.jsonwebtoken.Claims;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @className: LoginInterceptor
 * @description:   
 * @author SunHang
 * @createTime 2021/6/24 19:33
 */
public class LoginInterceptor implements HandlerInterceptor {

    @Resource
    private RedisService rs;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        // 获取请求头中的token字符串，若为空，则说明未登录
        String token = request.getHeader("token");
        // 不为空，则进行token的校验，通过则可以正常访问。
        if(null==token){
            throw new MvcException(S.NO_LOGIN);
        }
        Claims parse = JJWTUtil.parse(token);
        if(parse==null){
            throw new MvcException(S.NO_LOGIN);
        }
        String uphone = JJWTUtil.getUhpone(parse);
        String hget = rs.hget(Keys.PHONE_HASH, uphone);
        Sysuser loginUser = JSON.parseObject(hget, Sysuser.class);
        // 将登录用户对象放入线程变量中，可以确保后面的可以方便的拿到。
        CurrentLoginUser.setLoginUser(loginUser);
        // 重新修改token，将有效期延长
        String newToken = JJWTUtil.generate(uphone);
        response.addHeader("token",newToken);
        return true;
    }
}
