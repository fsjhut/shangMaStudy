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
    public List<MyProduct> getAllProduct(Integer page,Integer pageSize,MyProduct queryProd) {

        List<MyProduct> lp = new ArrayList<MyProduct>();
        Connection conn = DBHelper.getConn();
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        List paramList = new ArrayList();
        String sql = "select tp.prod_id,tp.prod_name,tp.prod_price,tp.prod_img,tp.prod_desc from tb_prod tp ";
        //where  tp.prod_id = 'dq010001'  and  tp.prod_name like '%游戏%'
        //用户在商品编号框填入了值
        Boolean isWhere = true;
        if(queryProd.getProdId()!=null&&!"".equals(queryProd.getProdId())){
            if(isWhere){
                sql+=" where ";
                isWhere = false;
            }else{
                sql+=" and ";
            }
            sql+=" tp.prod_id = ? ";
            paramList.add(queryProd.getProdId());
        }


        if(queryProd.getProdName()!=null&&!"".equals(queryProd.getProdName())){
            if(isWhere){
                sql+=" where ";
                isWhere = false;
            }else{
                sql+=" and ";
            }
            sql+=" tp.prod_name like ? ";
            paramList.add("%"+queryProd.getProdName()+"%");
        }


        sql+=" limit  "+(page-1)*pageSize+","+pageSize;

        System.out.println(sql);

        try {
            preparedStatement = conn.prepareStatement(sql);
            //设置参数

            for(int i = 0;i<paramList.size();i++){
                preparedStatement.setObject(i+1, paramList.get(i));
            }

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
        if(queryProd.getProdId()!=null&&!"".equals(queryProd.getProdId())){
            if(isWhere){
                sql+=" where ";
                isWhere = false;
            }else{
                sql+=" and ";
            }
            sql+=" tp.prod_id = ? ";
            paramList.add(queryProd.getProdId());
        }


        if(queryProd.getProdName()!=null&&!"".equals(queryProd.getProdName())){
            if(isWhere){
                sql+=" where ";
                isWhere = false;
            }else{
                sql+=" and ";
            }
            sql+=" tp.prod_name like ? ";
            paramList.add("%"+queryProd.getProdName()+"%");
        }

        System.out.println(sql);

        try {
            preparedStatement = conn.prepareStatement(sql);
            //设置参数
            for(int i = 0;i<paramList.size();i++){
                preparedStatement.setObject(i+1, paramList.get(i));
            }
            rs = preparedStatement.executeQuery();
            while(rs.next()){
                totalNum = rs.getInt("totalnum");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBHelper.CloseConn(conn,null,preparedStatement,rs);
        }
        return totalNum;
    }


    @Override
    public Integer inserProd(MyProduct insertProd) {


        /*
        * insert INTO tb_prod(prod_id,prod_name,prod_price,prod_img,prod_desc) VALUES ('333333','333333','333333','333333','333333')
        * */

        Connection conn = DBHelper.getConn();
        String sql = "insert INTO tb_prod(prod_id,prod_name,prod_price,prod_img,prod_desc) VALUES (?,?,?,?,?)";
        int resnum = 0;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1,insertProd.getProdId());
            preparedStatement.setString(2,insertProd.getProdName());
            preparedStatement.setDouble(3,insertProd.getProdPrice());
            preparedStatement.setString(4,insertProd.getProdImg());
            preparedStatement.setString(5,insertProd.getProdDesc());

            resnum = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBHelper.CloseConn(conn,null,preparedStatement,null);
        }
        return resnum;

    }

    @Override
    public Integer editProd(MyProduct editProd) {
        Connection conn = DBHelper.getConn();
        String sql = "update tb_prod set prod_name = ?,prod_price = ?,prod_img = ?,prod_desc = ? where prod_id = ?";
        int resnum = 0;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setString(1,editProd.getProdName());
            preparedStatement.setDouble(2,editProd.getProdPrice());
            preparedStatement.setString(3,editProd.getProdImg());
            preparedStatement.setString(4,editProd.getProdDesc());
            preparedStatement.setString(5,editProd.getProdId());

            resnum = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBHelper.CloseConn(conn,null,preparedStatement,null);
        }
        return resnum;
    }
}
