package com.javasm.dao.impl;

import com.javasm.dao.ProductDao;
import com.javasm.entity.MyUser;
import com.javasm.entity.Product;
import com.javasm.utils.DBHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @className: ProductDaoImpl
 * @description:   
 * @author SunHang
 * @createTime 2021/5/11 21:21
 */
public class ProductDaoImpl implements ProductDao {
    @Override
    public List<Product> selectAll() {
        Connection conn = DBHelper.getConn();
        List<Product> productList = new ArrayList<>();
        String sql = "select tu.id,tu.name,tu.number,tu.remark from tb_product tu ";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet resnum = preparedStatement.executeQuery();
            while(resnum.next()){
                int id = resnum.getInt("id");
                String name = resnum.getString("name");
                Integer number = resnum.getInt("number");
                String remark = resnum.getString("remark");
                Product mu = new Product(id,name,number,remark);
                productList.add(mu);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }
}
