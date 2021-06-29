package com.javasm.commons.excel;

import cn.hutool.core.io.FileUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;

import java.util.List;
import java.util.Map;

/**
 * @className: ExcelTest
 * @description:   
 * @author SunHang
 * @createTime 2021/6/26 13:04
 */
public class ExcelTest {
//    ExcelReader reader;
    public static void main(String[] args) {
        ExcelReader reader = ExcelUtil.getReader(FileUtil.file
                ("C:\\Users\\JAVASM\\Downloads\\W020170213333264378621.xls"),0);

        //通过sheet编号获取
//        reader = ExcelUtil.getReader(FileUtil.file("test.xlsx"), 0);
        //通过sheet名获取
//        reader = ExcelUtil.getReader(FileUtil.file("test.xlsx"), "sheet1");
        List<Map<String,Object>> readAll = reader.readAll();
        System.out.println(readAll);

    }
}
