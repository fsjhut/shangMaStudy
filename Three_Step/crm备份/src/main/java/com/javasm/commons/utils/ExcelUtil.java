package com.javasm.commons.utils;


import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class ExcelUtil {
    public static void main(String[] args) throws IOException, InvalidFormatException {

        String path = "D:/员工信息.xls";
        InputStream in = new FileInputStream(path);
        List<Map<String, Object>> maps = readExcel(in);
        maps.forEach(System.out::println);



    }

    public static List<Map<String, Object>> readExcel(InputStream in) {
        Workbook book = null;

        try {
            book = WorkbookFactory.create(in);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (book == null)
            return null;

        //把Excel中的每一行封装到map集合中，所有的map集合封装成list集合
        List<Map<String, Object>> list = new ArrayList<>();
        //第一行
        Sheet sheet = book.getSheetAt(0);
        Row headRow = sheet.getRow(0);
        Object[] headRowCells = readRow(headRow);



        //得到行数
        int rows = sheet.getPhysicalNumberOfRows();
        Map<String, Object> map = null;
        for (int i = 1; i < rows; i++) {
            map = new HashMap<>();
            Row row = sheet.getRow(i);
            Object[] datas = readRow(row);

            //向map中put数据
            for (int j = 0; j < datas.length; j++) {
                String key = (String) headRowCells[j];
                Object value = datas[j];
                map.put(key, value);

            }

            list.add(map);

        }

        return list;


    }


    public static Object[] readRow(Row row) {
        //得到列数
        int cols = row.getPhysicalNumberOfCells();
        Object[] result = new Object[cols];

        for (int i = 0; i < cols; i++) {
            //每一行的单元格对象
            Cell cell = row.getCell(i);
            Object value = null;
            CellType type = cell.getCellTypeEnum();
            if (type.equals(CellType.STRING)) {
                value = cell.getStringCellValue();

            } else if (type.equals(CellType.NUMERIC)) {
                if (org.apache.poi.ss.usermodel.DateUtil.isCellDateFormatted(cell)) {
                    Date dateCellValue = cell.getDateCellValue();
                    value = DateUtil.formatYMD(dateCellValue);
                } else {
                    double doubleValue = cell.getNumericCellValue();
                    value = cell.getNumericCellValue();
                    int intValue = (int) doubleValue;
                    if (intValue == doubleValue) {
                        value = intValue;
                    } else {
                        value = doubleValue;
                    }


                }
            }
            result[i] = value;

        }
        return result;
    }
}
