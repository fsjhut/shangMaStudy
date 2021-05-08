package com.test.servlet;

import com.test.http.MyRequest;
import com.test.http.MyResponse;

import java.io.IOException;
import java.io.OutputStream;

/**
 * @className: LoginServlet
 * @description:   
 * @author SunHang
 * @createTime 2021/5/7 12:24
 */
public class LoginServlet extends MyServlet{
    @Override
    protected void doPost(MyRequest myRequest, MyResponse myResponse) {

    }

    @Override
    protected void doGet(MyRequest myRequest, MyResponse myResponse) {
        OutputStream writer = myResponse.getWriter();

        try {
            writer.write(MyResponse.respHeader.getBytes());
            writer.write("login ok !!!".getBytes());
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
