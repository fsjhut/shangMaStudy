package com.javasm.dao.impl;

import com.javasm.dao.AreaDao;
import com.javasm.entity.MyArea;
import com.javasm.utils.DBHelper;


import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AreaDaoImpl implements AreaDao {

    @Override
    public List<MyArea> getAreaByParentCode(Integer pcode) {

        List<MyArea> lp = new ArrayList<MyArea>();
        Connection conn = DBHelper.getConn();
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        String sql = "select ta.area_code,ta.area_name from tb_area ta where ta.parent_code = ?";
        try {
            preparedStatement = conn.prepareStatement(sql);
            //设置参数
            preparedStatement.setInt(1,pcode);
            rs = preparedStatement.executeQuery();
            while(rs.next()){
                int areaCode = rs.getInt("area_code");
                String areaName = rs.getString("area_name");

                MyArea myprod = new MyArea(areaCode, areaName);
                lp.add(myprod);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBHelper.CloseConn(conn,null,preparedStatement,rs);
        }
        return lp;
    }
}
