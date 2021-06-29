package com.javasm.commons.excel;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.DateUtil;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author SunHang
 * @className: ExcelUtil
 * @description:
 * @createTime 2021/6/26 9:57
 */
public class ExcelUtil {

    public static void main(String[] args) throws Exception {
        String path = "C:\\Users\\JAVASM\\Downloads\\W020170213333264378621.xls";
        InputStream in = new FileInputStream(path);
        List<Map<String, Object>> maps = readExcel(in);
        System.out.println(maps);

    }

    public static List<Map<String,Object>> readExcel(InputStream in){
        Workbook book = null;
        try {
            book = WorkbookFactory.create(in);
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<Map<String,Object>> list = new ArrayList<>(); // 行数
        assert book != null;
        Sheet sheet = book.getSheetAt(0);
        Row headRow = sheet.getRow(0);
        Object[] headRowCells = readRow(headRow);

        int rows = sheet.getPhysicalNumberOfRows();
        Map<String,Object> map = null;
        for (int i = 1; i < rows; i++) {
            map = new HashMap<>();
            Row row = sheet.getRow(i);
            Object[] datas = readRow(row);
            for (int j = 0; j < datas.length-1; j++) {
                String key =(String)headRowCells[j];
                Object data = datas[j];
                map.put(key,data);
            }
            list.add(map);
        }
        return list;
    }

    private static Object[] readRow(Row headRow) {
        int colums = headRow.getPhysicalNumberOfCells();
        Object[] result = new Object[colums];
        for (int i = 0; i < colums; i++) {
            Cell cell = headRow.getCell(i); // 获取每行的单元格对象
            CellType cellType = cell.getCellTypeEnum();
            Object value = null;
            if (cellType.equals(CellType.STRING)) {
                value = cell.getStringCellValue();
            } else if (cellType.equals(CellType.NUMERIC)) {
                // numeric：可以读取到日期格式的
                if (DateUtil.isCellDateFormatted(cell)) {  // 判断是否是日期格式的
                    value = cell.getDateCellValue();
                    // 将日期转为字符串数据
                } else {
                    double doubleValue = cell.getNumericCellValue(); // 判断是否是整形
                    int valueInt = (int) doubleValue;
                    if(valueInt == doubleValue){
                        value = valueInt;
                    }else {
                        value = doubleValue;
                    }
                }
            }
            result[i] = value;
        }
        return result;
    }
}
