package com.javasm.commons.interceptor;

import com.javasm.commons.entity.S;
import com.javasm.commons.exception.MvcException;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;

public class LoginInterceptor implements HandlerInterceptor {

    //前拦截
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        HandlerMethod m = (HandlerMethod)handler;
//        Object bean = m.getBean();//handler类的bean对象
//        Method method = m.getMethod();//处理器方法
        HttpSession session = request.getSession();
        Object loginuser = session.getAttribute("loginuser");
        if(loginuser==null) {
            throw new MvcException(S.NO_LOGIN);//返回给前端数据
        }

        return true;
    }

    //出异常,该方法不执行
//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        System.out.println("postHandle");
//    }
//    //最终
//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        System.out.println("afterCompletion");
//    }
}
