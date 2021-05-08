package com.test.server;

import com.test.servlet.MyServlet;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * @className: MyServer
 * @description:   
 * @author SunHang
 * @createTime 2021/5/7 12:23
 */
public class MyServer {
    public static Map<String,MyServlet> servletMap = new HashMap<>();
    public static void init(){
        Properties properties = new Properties();
        try {
            properties.load(MyServer.class.getClassLoader().getResourceAsStream("myMapping.properties"));
            System.out.println(properties);
            Set<Object> keys = properties.keySet();
            for (Object key : keys) {
                if(key.toString().contains("url")){
                    String myUrl = properties.getProperty(key.toString());
                    String classNameKey = key.toString().replace("url", "classname");
                    String className = properties.getProperty(classNameKey);
                    System.out.println(myUrl+"----------"+className);
                    MyServlet myServlet = (MyServlet)Class.forName(className).newInstance();
                    servletMap.put(myUrl,myServlet);
                }
            }
        } catch (IOException | IllegalAccessException | ClassNotFoundException | InstantiationException e) {
            e.printStackTrace();
        }
    }
    public static void startServer(){
        try {
            ServerSocket ss = new ServerSocket(8084);
            System.out.println("服务器开启，监听8084端口");
            while (true){
                Socket accept = ss.accept();
                Thread myProcess = new MyProcess(accept);
                myProcess.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MyServer.init();
        MyServer.startServer();
    }
}
