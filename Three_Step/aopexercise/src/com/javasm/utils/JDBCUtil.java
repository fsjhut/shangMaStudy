package com.javasm.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author SunHang
 * @className: JDBCUtil
 * @description:
 * @createTime 2021/6/11 19:42
 */

public class JDBCUtil {

//    private DataSource dataSource;
//    private Connection conn;
//
//    {
//        Properties properties = new Properties();
//        try {
//            properties.load(JDBCUtil.class.getClassLoader().getResourceAsStream("jdbc.properties"));
//            this.dataSource = DruidDataSourceFactory.createDataSource(properties);
//            this.conn = dataSource.getConnection();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}

    private static DataSource dataSource;

     static {
        Properties properties = new Properties();
        try {
            properties.load(JDBCUtil.class.getClassLoader().getResourceAsStream("jdbc.properties"));
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static DataSource getDataSource() {
        return dataSource;
    }


    //服务于事务
    public static Connection getConn() {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
