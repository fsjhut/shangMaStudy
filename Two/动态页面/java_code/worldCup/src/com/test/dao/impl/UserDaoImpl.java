package com.test.dao.impl;

import com.test.dao.UserDao;
import com.test.entity.User;
import com.test.utils.DBHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author SunHang
 * @className: UserDaoImpl
 * @description:
 * @createTime 2021/5/15 14:35
 */
public class UserDaoImpl implements UserDao {
    @Override
    public User selectByName(String userName) {
        Connection conn = DBHelper.getConn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select p.user_name,p.goal_count,p.get_card,p.no_card " +
                " from cup_user as p where p.user_name = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, userName);
            rs = ps.executeQuery();
            if (rs.next()) {
                String name = rs.getString("user_name");
                Integer goalCount = rs.getInt("goal_count");
                String getCardStr = rs.getString("get_card");
                String noCardStr = rs.getString("no_card");
                // 数据处理 字符串转为list
                ArrayList<Integer> getCard = new ArrayList<>();
                ArrayList<Integer> noCard = new ArrayList<>();
                if (getCardStr != null) {
                    char[] chars = getCardStr.toCharArray();
                    for (char aChar : chars) {
                        getCard.add(aChar - 48);
                    }
                }
                if (noCardStr != null) {
                    char[] chars = noCardStr.toCharArray();
                    for (char aChar : chars) {
                        noCard.add(aChar - 48);
                    }
                }
                return new User(name, goalCount, getCard, noCard);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBHelper.CloseConn(conn, null, ps, rs);
        }
        return null;
    }

    @Override
    public void updateUser(User myUser) {
        Connection conn = DBHelper.getConn();
        PreparedStatement ps = null;
        String sql = "update cup_user set goal_count=?,get_card=?,no_card=?" +
                " where user_name = ?";
        // 需要将集合转为字符串
        ArrayList<Integer> getCard = myUser.getGetCard();
        ArrayList<Integer> noCard = myUser.getNoCard();

        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, myUser.getGoalCount());
            ps.setString(2, listToString(getCard));
            ps.setString(3, listToString(noCard));
            ps.setString(4, myUser.getUserName());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBHelper.CloseConn(conn, null, ps, null);
        }
    }
    private String listToString(ArrayList<Integer> list){
        if(list==null){
            return null;
        }
        StringBuilder builder = new StringBuilder();
        for (Integer integer : list) {
            builder.append(integer);
        }
        return builder.toString();
    }
}
