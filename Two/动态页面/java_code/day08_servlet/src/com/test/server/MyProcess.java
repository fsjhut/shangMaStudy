package com.test.server;

import com.test.http.MyRequest;
import com.test.http.MyResponse;
import com.test.servlet.MyServlet;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @className: MyProcess
 * @description:   
 * @author SunHang
 * @createTime 2021/5/7 12:23
 */
public class MyProcess extends Thread{
    private Socket soc;

    public MyProcess(Socket soc) {
        this.soc = soc;
    }
    @Override
    public void run(){
        try {
            MyRequest myRequest = new MyRequest(soc.getInputStream());
            MyResponse myResponse = new MyResponse(soc.getOutputStream());
            MyServlet myServlet = MyServer.servletMap.get(myRequest.getUrl());
            if(myServlet!=null){
                myServlet.service(myRequest,myResponse);
            }else{
                OutputStream writer = myResponse.getWriter();
                writer.write(MyResponse.respHeader.getBytes());
                writer.write("404 not found !!!".getBytes());
                writer.flush();
                writer.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
