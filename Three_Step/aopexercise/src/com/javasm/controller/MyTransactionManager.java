package com.javasm.controller;

import com.javasm.service.SqlService;
import com.javasm.utils.JDBCUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @className: MyTransactionManager
 * @description:   
 * @author SunHang
 * @createTime 2021/6/11 19:12
 */
@Component
public class MyTransactionManager {
    @Resource
    private DataSource ds;

    public Connection getConn(){
        try {
            Connection connection = ds.getConnection();
            CurrentThreadConnection.setConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return CurrentThreadConnection.getConnection();
    }

    public void beginWork(Connection conn) throws SQLException {
        System.out.println("前置通知");
        conn.setAutoCommit(false);
    }

    public void commitWork(Connection conn) throws SQLException {
        System.out.println("返回通知");
        conn.commit();
    }

    public void rollBackWork(Connection conn) throws SQLException {
        System.out.println("异常通知");
        conn.rollback();
    }

    public void closeWork(Connection conn) {
        System.out.println("最终通知");
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
