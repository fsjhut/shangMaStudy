package com.javasm.service.impl;

import com.javasm.dao.ProdDao;
import com.javasm.dao.impl.ProdDaoImpl;
import com.javasm.entity.MyProduct;
import com.javasm.service.ProdService;

import java.util.List;

public class ProdServiceImpl implements ProdService {

    @Override
    public List<MyProduct> getAllProduct(Integer page,Integer pageSize) {

        ProdDao pd = new ProdDaoImpl();
        return pd.getAllProduct(page,pageSize);
    }

    @Override
    public MyProduct getProductById(String prodid) {
        ProdDao pd = new ProdDaoImpl();
        return pd.getProductById(prodid);
    }
}
