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
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet resnum = preparedStatement.executeQuery();
            while(resnum.next()){
                int uid = resnum.getInt("uid");
                String uname = resnum.getString("uname");
                String uphone = resnum.getString("uphone");
                String uremark = resnum.getString("uremark");
                MyUser mu = new MyUser(uid,uname,uphone,uremark);
                userList.add(mu);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    public int insertUser(MyUser insertUser) {
        Connection conn = DBHelper.getConn();
        String sql = "insert into tb_user(uname,upwd,uphone,uremark) VALUES (?,?,?,?)";
        int resnum = 0;
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1,insertUser.getUname());
            preparedStatement.setString(2,insertUser.getUpwd());
            preparedStatement.setString(3,insertUser.getUphone());
            preparedStatement.setString(4,insertUser.getUremark());

            resnum = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resnum;
    }

    @Override
    public MyUser login(MyUser loginUser) {
        Connection conn = DBHelper.getConn();
        MyUser mu = null;
        String sql = "select tu.uid,tu.uname,tu.uphone,tu.uremark from tb_user tu WHERE tu.uname = ? and tu.upwd = ? ";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1,loginUser.getUname());
            preparedStatement.setString(2,loginUser.getUpwd());
            ResultSet resnum = preparedStatement.executeQuery();
               while(resnum.next()){
                   int uid = resnum.getInt("uid");
                   String uname = resnum.getString("uname");
                   String uphone = resnum.getString("uphone");
                   String uremark = resnum.getString("uremark");
                   mu = new MyUser(uid,uname,uphone,uremark);
               }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mu;
    }
}
