package com.javasm.commons.utils;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @className: ServletUtil
 * @description:   
 * @author SunHang
 * @createTime 2021/6/17 21:14
 */
public class ServletUtil {

    public static ServletRequestAttributes getRequestAttributes(){

        return (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
    }

    public static HttpServletRequest getRequest(){
        return getRequestAttributes().getRequest();
    }

    public static HttpServletResponse getResponse(){
        return getRequestAttributes().getResponse();
    }

    public static HttpSession getSession(){
        return getRequest().getSession();
    }

    public static ServletContext getServletContext(){
        return getRequest().getServletContext();
    }

    //获取k=v参数格式的参数值.
    public static String getParameter(String name,String defaultValue){
        String value = getRequest().getParameter(name);
        return value == null ? defaultValue : value;
    }

    public static Integer getParameter(String name,Integer defaultValue){
        String value = getRequest().getParameter(name);
        return value == null ? defaultValue : Integer.valueOf(Integer.parseInt(value));
    }

    public static Double getParameter(String name,Double defaultValue){
        String value = getRequest().getParameter(name);
        return value == null ? defaultValue : Double.valueOf(Double.parseDouble(value));
    }
}
