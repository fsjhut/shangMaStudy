package com.javasm.commons.utils;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.DateUtil;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * @author: JAVASM
 * @className: EXCEutils
 * @date: 2021/7/5 19:30
 * @version: 8.8.8
 * @since:6.6.6
 */
public class EXCEutils {
    public static void main(String[] args) throws Exception {
        String path="E:/B2C.xlsx";
        InputStream input=new FileInputStream(path);
        List<Map<String, Object>> list = readExcel(input);
        System.out.println(list);

    }
//    private static  List<Map<String,Object>> readExcl(InputStream input){
//        Workbook sheets = null;
//        try {
//            sheets = WorkbookFactory.create(input);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        if(sheets==null) return null ;
//        List<Map<String,Object>>list=new ArrayList<>();//每行封为map，每个map放到一个list，组成该excl
//        Sheet sheetAt = sheets.getSheetAt(0);//按照索引取sheet对象
//        //  Sheet sheet1 = sheets.getSheet("B2C销售订单详情");//按照sheet名称取sheet对象
//        Row headRow = sheetAt.getRow(0);//第一行
//        Object[] headCells = redRow(headRow);
////        for (Object headCell : headCells) {
////            System.out.print(headCell+"\t ");
////        }
//        System.out.println();
//        int rows = sheetAt.getPhysicalNumberOfRows();//int型的行数
//        Map<String,Object>map=null;
//        for (int i=1;i<rows;i++){
//            Row row = sheetAt.getRow(i);//每一行对象
//            Object[] objects = redRow(row);//行数据
//           for (int j=1;j<objects.length;j++){
//               map=new HashMap<>();
//               String key =(String) headCells[j];
//               Object value = objects[j];
//               map.put(key,value);
//           }
//            list.add(map);
//            System.out.println();
//        }
//        return list;
//    }
//    private static Object[] redRow(Row row){
//        int cols = row.getPhysicalNumberOfCells();//列数
//        Object[]result=new Object[cols];
//        for(int i=0;i<cols;i++){
//            Cell cell = row.getCell(i);//获得某行的单元格对象
//            CellType cellTypeEnum = cell.getCellTypeEnum();//获取单元格类型
//            Object value=null;
//            if (cellTypeEnum.equals(CellType.STRING)){
//                value = cell.getStringCellValue();
//
//            }else if (cellTypeEnum.equals(CellType.NUMERIC)){
//                if(DateUtil.isCellDateFormatted(cell)){
//                    //   obj = cell.getDateCellValue();//Date型数据
//                    value= com.javasm.commons.utils.DateUtil.formatYMD(cell.getDateCellValue());//字符串，日期进行格式转换
//                }else {
//                    double objs= cell.getNumericCellValue();
//                    int intValue=(int)objs;
//                    if(intValue==objs){
//                        value=(int)objs;
//                    }else {
//                        value=objs;
//                    }
//                }
//
//                }
//            result[i]=value;
//        }
//        return result;
//    }
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
                    value = com.javasm.commons.utils.DateUtil.formatYMD(dateCellValue);
                } else {
                    double doubleValue = cell.getNumericCellValue();

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
