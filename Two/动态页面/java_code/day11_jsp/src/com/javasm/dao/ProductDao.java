package com.javasm.dao;

import com.javasm.entity.Product;

import java.util.List;

/**
 * @className: ProductDao
 * @description:   
 * @author SunHang
 * @createTime 2021/5/11 21:21
 */
public interface ProductDao {
    List<Product> selectAll();
}
