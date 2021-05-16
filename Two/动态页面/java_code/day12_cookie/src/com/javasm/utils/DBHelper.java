package com.javasm.utils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBHelper {
	static String username;
	static String pwd;
	static String url;
	static String drivername;
	
	
	static {
		Properties p = new Properties();
		try {
			//程序运行时 不一定在你的工程目录的编译目录下
			p.load(DBHelper.class.getResourceAsStream("/jdbc.properties"));
			username = p.getProperty("jdbc.user");
			pwd = p.getProperty("jdbc.pass");
			url = p.getProperty("jdbc.url");
			drivername = p.getProperty("jdbc.driver");
			//把对应的类 加载到虚拟机中
			Class.forName(drivername);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConn() {
		Connection con = null;
		
		try {
			con = DriverManager.getConnection(url, username, pwd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	
	public static void CloseConn(Connection conn,Statement stat,PreparedStatement psta,ResultSet rs){
		
			try {
				if(stat!=null)stat.close();
				if(psta!=null)psta.close();
				if(rs!=null)rs.close();
				if(conn!=null)conn.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
}
