package com.javasm;

import com.javasm.commons.utils.DateUtil;
import org.junit.Test;

/**
 * @className: UploadFile
 * @description:   
 * @author SunHang
 * @createTime 2021/6/30 15:47
 */
public class UploadFile {
    @Test
    public void test1(){
        System.out.println(DateUtil.getYMDHMS().
                replaceAll(":","-").
                replaceAll("\\s","_"));
    }
}
