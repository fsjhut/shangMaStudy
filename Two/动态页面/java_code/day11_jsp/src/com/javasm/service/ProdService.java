package com.javasm.service;

import com.javasm.entity.MyProduct;

import java.util.List;

public interface ProdService {

    List<MyProduct> getAllProduct();
    MyProduct getProductById(String prodid);
}
