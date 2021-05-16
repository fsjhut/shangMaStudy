package com.javasm.dao.impl;

import com.javasm.dao.ProdDao;
import com.javasm.entity.MyProduct;
import com.javasm.utils.DBHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdDaoImpl implements ProdDao {
    @Override
    public MyProduct getProductById(String prodid) {

        MyProduct prod = null;
        Connection conn = DBHelper.getConn();
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        String sql = "select tp.prod_id,tp.prod_name,tp.prod_price,tp.prod_img,tp.prod_desc from tb_prod tp where tp.prod_id = ?";
        try {
            preparedStatement = conn.prepareStatement(sql);
            //设置参数
            preparedStatement.setString(1,prodid);
            rs = preparedStatement.executeQuery();
            while(rs.next()){
                String prodId = rs.getString("prod_id");
                String prodName = rs.getString("prod_name");
                Double prodPrice = rs.getDouble("prod_price");
                String prodImg = rs.getString("prod_img");
                String prodDesc = rs.getString("prod_desc");
                prod = new MyProduct(prodId, prodName, prodPrice, prodImg, prodDesc);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBHelper.CloseConn(conn,null,preparedStatement,rs);
        }
        return prod;
    }

    @Override
    public List<MyProduct> getAllProduct(Integer page,Integer pageSize) {

        List<MyProduct> lp = new ArrayList<MyProduct>();
        Connection conn = DBHelper.getConn();
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        String sql = "select tp.prod_id,tp.prod_name,tp.prod_price,tp.prod_img,tp.prod_desc from tb_prod tp limit ?,?";
        try {
            preparedStatement = conn.prepareStatement(sql);
            //设置参数
            page = (page-1)*pageSize;
            preparedStatement.setString(1,String.valueOf(page));
            preparedStatement.setString(2,String.valueOf(pageSize));
            rs = preparedStatement.executeQuery();
            while(rs.next()){
                String prodId = rs.getString("prod_id");
                String prodName = rs.getString("prod_name");
                Double prodPrice = rs.getDouble("prod_price");
                String prodImg = rs.getString("prod_img");
                String prodDesc = rs.getString("prod_desc");
                MyProduct myprod = new MyProduct(prodId, prodName, prodPrice, prodImg, prodDesc);
                lp.add(myprod);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBHelper.CloseConn(conn,null,preparedStatement,rs);
        }
        return lp;
    }
}
