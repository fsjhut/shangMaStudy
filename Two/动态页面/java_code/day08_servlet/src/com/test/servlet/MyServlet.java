package com.test.servlet;

import com.test.http.MyRequest;
import com.test.http.MyResponse;

/**
 * @className: MyServlet
 * @description:   
 * @author SunHang
 * @createTime 2021/5/7 12:24
 */
public abstract class MyServlet {
    public  void service(MyRequest myRequest, MyResponse myResponse){
        if("GET".equals(myRequest.getMethod())){
            doGet(myRequest,myResponse);
        }else if("POST".equals(myRequest.getMethod())){
            doPost(myRequest,myResponse);
        }
    }

    protected abstract void doPost(MyRequest myRequest, MyResponse myResponse);

    protected abstract void doGet(MyRequest myRequest, MyResponse myResponse);
}
