package com.javasm.commons.utils;

import java.math.BigInteger;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Objects;


public class MD5Util {

    private MD5Util() {
    }

    private static final String[] ARRAY = {"0", "1**", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

    //制定盐值: 加盐
    private static final String SALT = "sh!@#￥%";

    public static String md5EncodeStr(String sourceStr) {

        Objects.requireNonNull(sourceStr);
        try {
            //1.创建信息摘要对象
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");

            //2.更新加密  将源数据提交到加密规则中
            sourceStr = sourceStr + SALT;
            messageDigest.update(sourceStr.getBytes(Charset.forName("UTF-8")));

            //3.加密
            byte[] bytes = messageDigest.digest();

            System.out.println(Arrays.toString(bytes));
            //4. 转字符串
            //System.out.println("加密之后数据:"+new String(bytes, Charset.forName("utf-8")));
            //将每个字节转换成16进制数据  拼接成字符串
            //0-F
            //一个字节: 8个二进制位
            //一个16进制数字: 4个二进制位
            //一个字节: == 2个16进制内容
            //高低位
            BigInteger bigInteger = new BigInteger(1, bytes);//1 正整数  -1 负整数
            return bigInteger.toString(16).toUpperCase();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String byteToHexStr(byte aByte) {//-128-127
        //先将byte转int
        int num = aByte;
        if (num < 0) {
            num += 256;
        }
        //高低位运算
        int lowIndex = num % 16;
        int highIndex = num / 16;
        return ARRAY[highIndex] + ARRAY[lowIndex];
    }

    public static void main(String[] args) {
        System.out.println(md5EncodeStr("1234"));
        //�ܛ�R�M� 6��1>�U
        //81dc9bdb52d04dc20036dbd8313ed055
        //16进制: 整数数据
    }
}
