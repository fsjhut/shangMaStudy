package com.javasm.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.commons.dbutils.DbUtils;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;


public class DBUtil {
    private DBUtil() {
    }

    private static DataSource dataSource;

    static {
        Properties properties = new Properties();
        try {
            properties.load(DBUtil.class.getClassLoader().getResourceAsStream("druid.properties"));
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static DataSource getDataSource() {
        return dataSource;
    }

    public static Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
//    // 关闭连接
//    public static void closeResource(Connection conn, Statement ps) {
//        try {
//            if (conn != null && ps != null) {
//                ps.close();
//                conn.close();
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    // 当是查询操作时，有返回值ResultSet,则重载本方法
//    public static void closeResource(Connection conn, Statement ps, ResultSet rs) {
//        closeResource(conn, ps);
//        try {
//            if (rs != null) {
//                rs.close();
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
}
