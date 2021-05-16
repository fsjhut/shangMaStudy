package com.javasm.dao;

import com.javasm.entity.MyProduct;
import com.javasm.entity.MyUser;

import java.util.List;

public interface ProdDao {

    List<MyProduct> getAllProduct(Integer page, Integer pageSize);

    MyProduct getProductById(String prodid);

}
