package com.test.dao.impl;

import com.test.entity.MyUser;
import com.test.dao.UserDao;
import com.test.utils.DBHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @className: UserDaoImpl
 * @description:   
 * @author SunHang
 * @createTime 2021/5/8 15:34
 */
public class UserDaoImpl implements UserDao {
    @Override
    public int insertUser(MyUser user) {
        Connection conn = DBHelper.getConn();
        String sql = "insert into `user`(`name`,`password`,phone,email,gender,birth,prov_code,city_code,county_code,area_detail,resume,`comment`)" +
                " values (?,?,?,?,?,?,?,?,?,?,?,?)";
        int resNum = 0;
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,user.getName());
            ps.setString(2,user.getPassWord());
            ps.setString(3,user.getPhone());
            ps.setString(4,user.getEmail());
            ps.setObject(5,user.getGender());
            ps.setObject(6,user.getBirth());
            ps.setString(7,user.getProvCode());
            ps.setString(8,user.getCityCode());
            ps.setString(9,user.getCountyCode());
            ps.setString(10,user.getAreaDetail());
            ps.setString(11,user.getResume());
            ps.setString(12,user.getComment());
            resNum = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resNum;
    }
}
