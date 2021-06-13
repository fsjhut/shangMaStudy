package com.javasm.controller;

import com.javasm.utils.SpringUtil;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @className: CurrentThreadConnection
 * @description:   
 * @author SunHang
 * @createTime 2021/6/12 11:47
 */
public class CurrentThreadConnection {
    private static ThreadLocal<Connection> connectionThreadLocal = new ThreadLocal<>();// 线程隔离
    public static void setConnection(Connection conn){
        connectionThreadLocal.set(conn);
    }
    public static Connection getConnection(){

        return CurrentThreadConnection.connectionThreadLocal.get();

//        if(connection !=null) {
//            return connection;
//        } else {
//            DataSource bean = SpringUtil.getBean(DataSource.class);
//            try {
//                Connection connection1 = bean.getConnection();
//                setConnection(connection1);
//                return connection1;
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//        return null;
    }
}
