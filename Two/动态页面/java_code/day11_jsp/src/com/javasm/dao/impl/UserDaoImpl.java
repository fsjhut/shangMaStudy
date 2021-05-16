package com.javasm.dao.impl;

import com.javasm.dao.UserDao;
import com.javasm.entity.MyUser;
import com.javasm.utils.DBHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public List<MyUser> getAllUser() {
        Connection conn = DBHelper.getConn();
        List<MyUser> userList = new ArrayList<MyUser>();
        String sql = "select tu.uid,tu.uname,tu.uphone,tu.uremark from tb_user tu ";
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            preparedStatement = conn.prepareStatement(sql);
            rs = preparedStatement.executeQuery();
            while(rs.next()){
                int uid = rs.getInt("uid");
                String uname = rs.getString("uname");
                String uphone = rs.getString("uphone");
                String uremark = rs.getString("uremark");
                MyUser mu = new MyUser(uid,uname,uphone,uremark);
                userList.add(mu);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBHelper.CloseConn(conn,null,preparedStatement,rs);
        }
        return userList;
    }

    @Override
    public int insertUser(MyUser insertUser) {
        Connection conn = DBHelper.getConn();
        String sql = "insert into tb_user(uname,upwd,uphone,uremark) VALUES (?,?,?,?)";
        int resnum = 0;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1,insertUser.getUname());
            preparedStatement.setString(2,insertUser.getUpwd());
            preparedStatement.setString(3,insertUser.getUphone());
            preparedStatement.setString(4,insertUser.getUremark());

            resnum = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBHelper.CloseConn(conn,null,preparedStatement,null);
        }
        return resnum;
    }

    @Override
    public MyUser login(MyUser loginUser) {
        Connection conn = DBHelper.getConn();
        MyUser mu = null;
        String sql = "select tu.uid,tu.uname,tu.uphone,tu.uremark from tb_user tu WHERE tu.uname = ? and tu.upwd = ? ";
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1,loginUser.getUname());
            preparedStatement.setString(2,loginUser.getUpwd());
            rs = preparedStatement.executeQuery();
               while(rs.next()){
                   int uid = rs.getInt("uid");
                   String uname = rs.getString("uname");
                   String uphone = rs.getString("uphone");
                   String uremark = rs.getString("uremark");
                   mu = new MyUser(uid,uname,uphone,uremark);
               }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBHelper.CloseConn(conn,null,preparedStatement,rs);
        }
        return mu;
    }
}
