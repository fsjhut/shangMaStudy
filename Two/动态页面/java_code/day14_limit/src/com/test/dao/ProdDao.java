package com.test.dao;

import com.test.entity.MyProduct;

import java.util.List;

/**
 * @className: ProdDao
 * @description:   
 * @author SunHang
 * @createTime 2021/5/14 16:25
 */
public interface ProdDao {
    List<MyProduct> getAllProduct(Integer page, Integer pageSize, MyProduct queryProd);

    Integer getAllProductNum(MyProduct queryProd);
}
