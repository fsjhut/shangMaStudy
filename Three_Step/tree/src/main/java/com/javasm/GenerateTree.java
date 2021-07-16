package com.javasm;

import sun.security.util.ArrayUtil;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @className: GenerateTree
 * @description:   
 * @author SunHang
 * @createTime 2021/7/6 19:37
 */
public class GenerateTree {

    private static ArrayList<Integer> cityList = new ArrayList<>();
    private static Object[] objects = new Object[17];
    private final Integer LENGTH = 6;
    private final Integer STEP = 2;

    public static void main(String[] args) {
        // 获取所有有维修点的地区对象
        getAllCity();
        // 对所有数据创建node节点

        // 如何将所有的地区数据拼接成树型
        Object[] objects = cityList.toArray();

        Arrays.sort(objects);
        System.out.println(objects.length);
        Arrays.stream(objects).forEach(System.out::println);
        StringBuilder value = new StringBuilder("140211");
        String substring = value.substring(0, 2);
        StringBuilder delete = value.delete(0, 2);
        System.out.println(delete);
        System.out.println(value);
        System.out.println(substring);

    }
//    private static void test(int j,){
//
//        for (int i = 0; i < objects.length-1; i++) {
//            String preStr = objects[i].toString().substring(j, j + 2);
//            String nestStr = objects[i+1].toString().substring(j, j + 2);
//            if(preStr.equals(nestStr)){
////                nestStr+LENGTH
//            }
//        }
//    }


    private static void getAllCity() {
        cityList.add(320323);
        cityList.add(230710);
        cityList.add(220821);
        cityList.add(220422);
        cityList.add(152528);
        cityList.add(141025);
        cityList.add(140881);
        cityList.add(140700);
        cityList.add(140521);
        cityList.add(140430);
        cityList.add(140223);
        cityList.add(131081);
        cityList.add(110100);
        cityList.add(120100);
        cityList.add(110100);
        cityList.add(140105);
        cityList.add(120200);
    }
}
