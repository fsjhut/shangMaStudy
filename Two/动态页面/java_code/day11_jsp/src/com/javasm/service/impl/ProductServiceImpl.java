package com.javasm.service.impl;

import com.javasm.dao.ProductDao;
import com.javasm.dao.impl.ProductDaoImpl;
import com.javasm.entity.Product;
import com.javasm.service.ProductService;

import java.util.List;

/**
 * @className: productServiceImpl
 * @description:   
 * @author SunHang
 * @createTime 2021/5/11 21:21
 */
public class ProductServiceImpl implements ProductService {
    @Override
    public List<Product> getAllProduct() {
        ProductDao productDao = new ProductDaoImpl();
        return productDao.selectAll();
    }
}
