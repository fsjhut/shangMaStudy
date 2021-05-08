package com.test.http;

import java.io.OutputStream;

/**
 * @className: MyResponse
 * @description:   
 * @author SunHang
 * @createTime 2021/5/7 12:23
 */
public class MyResponse {
    private OutputStream writer;
    public static final String respHeader =   "HTTP/1.1 200 OK\r\n" +
            "Content-Type:text/html;charset=utf-8\r\n" +
            "\r\n";

    public MyResponse(OutputStream os){
        writer = os;
    }

    public OutputStream getWriter() {
        return writer;
    }
}
