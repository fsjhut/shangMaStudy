package com.javasm.commons.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @className: DateUtil
 * @description:   
 * @author SunHang
 * @createTime 2021/6/17 21:21
 */

public class DateUtil {
    public static String getYMDHMS(){
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(new Date());
    }
}
