package com.javasm.service.impl;

import com.javasm.dao.ProdDao;
import com.javasm.dao.impl.ProdDaoImpl;
import com.javasm.entity.MyProduct;
import com.javasm.service.ProdService;

import java.util.List;

public class ProdServiceImpl implements ProdService {

    @Override
    public List<MyProduct> getAllProduct(Integer page,Integer pageSize,MyProduct queryProd) {

        ProdDao pd = new ProdDaoImpl();
        return pd.getAllProduct(page,pageSize,queryProd);
    }

    @Override
    public MyProduct getProductById(String prodid) {
        ProdDao pd = new ProdDaoImpl();
        return pd.getProductById(prodid);
    }

    @Override
    public Integer getTotalPage(Integer pageSize ,MyProduct queryProd) {
        //总记录数  每页显示记录数
        //数据模型 显示模型 格式 数值 需要改变
        //service层调用不同的dao
        ProdDao pd = new ProdDaoImpl();
        Integer totalPage = 0;
        Integer allProductNum = pd.getAllProductNum(queryProd);
        totalPage = allProductNum%pageSize>0?(allProductNum/pageSize)+1:allProductNum/pageSize;
        return totalPage;
    }

    @Override
    public Integer inserProd(MyProduct insertProd) {
        ProdDao pd = new ProdDaoImpl();
        return pd.inserProd(insertProd);
    }

    @Override
    public Integer editProd(MyProduct editProd) {
        ProdDao pd = new ProdDaoImpl();
        return pd.editProd(editProd);
    }
}
