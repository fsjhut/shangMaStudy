package com.test.servlet;

import com.test.http.MyRequest;
import com.test.http.MyResponse;

import java.io.IOException;
import java.io.OutputStream;

/**
 * @className: TestServlet
 * @description:   
 * @author SunHang
 * @createTime 2021/5/7 12:24
 */
public class TestServlet extends MyServlet{
    @Override
    protected void doPost(MyRequest myRequest, MyResponse myResponse) {

    }

    @Override
    protected void doGet(MyRequest myRequest, MyResponse myResponse) {
        OutputStream writer = myResponse.getWriter();

        try {
            writer.write(MyResponse.respHeader.getBytes());
            writer.write("<h1>学生信息表</h1>".getBytes());
            writer.write("<div>一个漂亮的table</div>".getBytes());
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
