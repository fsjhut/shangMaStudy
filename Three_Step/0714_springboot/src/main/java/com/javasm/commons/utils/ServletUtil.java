package com.javasm.commons.utils;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ServletUtil {

    public static ServletRequestAttributes getRequestAttributes(){
        ServletRequestAttributes requestAttributes =  (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        return requestAttributes;
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
        if(value==null)return defaultValue;
        else return value;
    }

    public static Integer getParameter(String name,Integer defaultValue){
        String value = getRequest().getParameter(name);
        if(value==null)return defaultValue;
        else return Integer.parseInt(value);
    }

    public static Double getParameter(String name,Double defaultValue){
        String value = getRequest().getParameter(name);
        if(value==null)return defaultValue;
        else return Double.parseDouble(value);
    }
}
