package com.javasm.service.impl;

import com.javasm.dao.ProdDao;
import com.javasm.entity.MyProduct;
import com.javasm.service.ProdService;

import java.util.List;

public class ProdServiceImpl implements ProdService {

    @Override
    public List<MyProduct> getAllProduct() {

        ProdDao pd = new ProdDaoImpl();
        return pd.getAllProduct();
    }

    @Override
    public MyProduct getProductById(String prodid) {
        ProdDao pd = new ProdDaoImpl();
        return pd.getProductById(prodid);
    }
}
