package com.test.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @className: MyRequest
 * @description:   
 * @author SunHang
 * @createTime 2021/5/7 12:23
 */

public class MyRequest {
    private String method;
    private String url;

    public MyRequest(InputStream is){
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        try {
            String reqHeader = reader.readLine();
            String[] reqHeaderArr = reqHeader.split(" ");
            method = reqHeaderArr[0];
            url = reqHeaderArr[1];
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getMethod() {
        return method;
    }

    public String getUrl() {
        return url;
    }
}
