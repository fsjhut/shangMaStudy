package com.javasm.service;

import com.javasm.entity.MyProduct;

import java.util.List;

public interface ProdService {

    List<MyProduct> getAllProduct(Integer page,Integer pageSize);
    MyProduct getProductById(String prodid);
}
