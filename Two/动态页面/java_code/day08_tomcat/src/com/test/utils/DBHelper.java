package com.test.utils;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * @className: DBHelper
 * @description:   
 * @author SunHang
 * @createTime 2021/5/8 15:36
 */
public class DBHelper {
    static String userName;
    static String pass;
    static String url;
    static String driveName;

    static {
        Properties properties = new Properties();
        try {
            properties.load(DBHelper.class.getClassLoader().getResourceAsStream("jdbc.properties"));
            userName = properties.getProperty("jdbc.user");
            pass = properties.getProperty("jdbc.pass");
            url = properties.getProperty("jdbc.url");
            driveName = properties.getProperty("jdbc.driver");
            Class.forName(driveName);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConn(){
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url,userName,pass);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void CloseConn(Connection conn, Statement stat, PreparedStatement ps, ResultSet rs){

        try {
            if(stat!=null) { stat.close(); }
            if(ps!=null) { ps.close(); }
            if(rs!=null) { rs.close(); }
            if(conn!=null) { conn.close(); }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
