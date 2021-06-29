package com.javasm.commons.utils;
/**
 * @className: StringUtil
 * @description:   
 * @author SunHang
 * @createTime 2021/6/22 9:34
 */
public class StringUtil {
    public static String randomValicode(){

        int min=123456;
        int max=999999;
        int r = (int)(Math.random()*(max-min)+min);
        return String.valueOf(r);
    }

//    public static void main(String[] args) {
//        System.out.println(randomValicode());
//    }
}
