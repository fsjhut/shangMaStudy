package com.test.utils;

import java.security.MessageDigest;

public class MD5Util {

    private MD5Util() {
    }

    private static final String SALT = "LISA@#**_&";

    /**
     * 密码加密
     *
     * @param source 源字符串
     * @return 加密之后的数据
     */
    public static String md5EncodeUtf8(String source) {
        return md5Encode(source + SALT, "UTF-8").toUpperCase();
    }


    /**
     * 加密
     *
     * @param source   源字符串+盐值
     * @param encoding 编码格式
     * @return
     */
    private static String md5Encode(String source, String encoding) {
        String encodeStr = null;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            if (encoding == null || " ".equals(encoding)) {
                //字节转换成16进制的数据
                encodeStr = byteArrayToHexString(messageDigest.digest(source.getBytes()));
            } else {
                encodeStr = byteArrayToHexString(messageDigest.digest(source.getBytes(encoding)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return encodeStr;
    }

    //16进制的组成部分内容
    private static final String[] hexDigits = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};
    private static String byteArrayToHexString(byte[] bytes) {
        StringBuilder stringBuilder = new StringBuilder();
        for (byte aByte : bytes) {
            stringBuilder.append(byteToHexString(aByte));
        }
        return stringBuilder.toString();
    }

    private static String byteToHexString(byte aByte) {
        int n = aByte;
        if (n < 0) {
            n += 256;//补数 补码 反码
        }
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
    }

    public static void main(String[] args) {
        System.out.println(md5EncodeUtf8("1234"));
    }
}
