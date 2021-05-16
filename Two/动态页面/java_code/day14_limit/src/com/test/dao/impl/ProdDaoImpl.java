package com.test.dao.impl;

import com.test.dao.ProdDao;
import com.test.entity.MyProduct;
import com.test.utils.DBHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author SunHang
 * @className: ProdDaoImplt
 * @description:
 * @createTime 2021/5/14 16:25
 */
public class ProdDaoImpl implements ProdDao {
    @Override
    public List<MyProduct> getAllProduct(Integer page, Integer pageSize, MyProduct queryProd) {
//        private String prodId;
//        private String prodName;
//        private Double prodPrice;
//        private String prodImg;
//        private String prodDesc;
//        //购物车显示数量使用
//        private Integer prodNum;
        // 变量的定义
        List<MyProduct> prodList = new ArrayList<>();
        Connection conn = DBHelper.getConn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List paramList = new ArrayList();
        String sql = "select p.prod_Id,p.prod_name,p.prod_price,p.prod_img,p.prod_desc from tb_prod as p ";
        // 需要满足用户的查询功能
        //      1. 用户可以根据Id进行查找
        //      2. 用户可以根据name查找 模糊查询
        //      3. 根据Id和name进行查找
        // 需要进行字符串的拼接  queryProd中有前端传递过来的数据，id、name
        Boolean isFirst = true;
        System.out.println(queryProd.getProdId());
        System.out.println(queryProd.getProdName());
        if (queryProd.getProdId() != null && (!"".equals(queryProd.getProdId()))) {
            // 说明用户有输入getProdId
            // 判断是否是第一次进入拼接
            isFirst = false;
            // 拼接数据
            sql += " where  p.prod_Id = ? ";
            paramList.add(queryProd.getProdId());
        }
        if (queryProd.getProdName() != null && (!"".equals(queryProd.getProdName()))) {
            // 说明用户有输入Name
            // 判断是否是第一次进入拼接
            if (isFirst) {
                sql += " where ";
//                isFirst = false;
            } else {
                sql += " and ";
            }
            // 拼接数据
            sql += " p.prod_name like ?";
            paramList.add("%" + queryProd.getProdName() + "%");
        }
        System.out.println(page);
        System.out.println((page - 1) * pageSize);
        sql += " order by p.prod_price " + " limit  " + (page - 1) * pageSize + "," + pageSize;
        System.out.println(sql);
//        System.out.println(paramList.get(0));
        try {
            ps = conn.prepareStatement(sql);
            // 将参数传递给？中
            for (int i = 0; i < paramList.size(); i++) {
                ps.setObject(i + 1, paramList.get(i));
            }
            rs = ps.executeQuery();
            while (rs.next()) {
                String prodId = rs.getString("prod_id");
                String prodName = rs.getString("prod_name");
                Double prodPrice = rs.getDouble("prod_price");
                String prodImg = rs.getString("prod_img");
                String prodDesc = rs.getString("prod_desc");
                MyProduct myprod = new MyProduct(prodId, prodName, prodPrice, prodImg, prodDesc);
                System.out.println(myprod);
                prodList.add(myprod);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBHelper.CloseConn(conn, null, ps, rs);
        }
        return prodList;
    }

    @Override
    public Integer getAllProductNum(MyProduct queryProd) {
        Integer totalNum = 0;
        Connection conn = DBHelper.getConn();
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        List paramList = new ArrayList();
        String sql = "select count(0) as totalnum from tb_prod tp ";
        //where  tp.prod_id = 'dq010001'  and  tp.prod_name like '%游戏%'
        //用户在商品编号框填入了值
        Boolean isWhere = true;
        if (queryProd.getProdId() != null && !"".equals(queryProd.getProdId())) {
            isWhere = false;
            sql += " where tp.prod_id = ? ";
            paramList.add(queryProd.getProdId());
        }

        if (queryProd.getProdName() != null && !"".equals(queryProd.getProdName())) {
            if (isWhere) {
                sql += " where ";
            } else {
                sql += " and ";
            }
            sql += " tp.prod_name like ? ";
            paramList.add("%" + queryProd.getProdName() + "%");
        }
        System.out.println(sql);

        try {
            preparedStatement = conn.prepareStatement(sql);
            //设置参数
            for (int i = 0; i < paramList.size(); i++) {
                preparedStatement.setObject(i + 1, paramList.get(i));
            }
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                totalNum = rs.getInt("totalnum");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBHelper.CloseConn(conn, null, preparedStatement, rs);
        }
        return totalNum;
    }
}
