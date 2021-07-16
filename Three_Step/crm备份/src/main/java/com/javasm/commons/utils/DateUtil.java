package com.javasm.commons.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    public static Date currentDate(){
        return new Date();
    }

    public static String getYMDHMS(){
        DateFormat df =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(new Date());
    }

    public static String formatYMD(Date date){
        DateFormat df =new SimpleDateFormat("yyyy-MM-dd");
        return df.format(date);
    }

    public static Date getNextDate(Date current, Long expTime) {
        Long time = current.getTime()+ expTime;
        return new Date(time);
    }
}
