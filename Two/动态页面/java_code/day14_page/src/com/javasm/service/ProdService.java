package com.javasm.service;

import com.javasm.entity.MyProduct;

import java.util.List;

public interface ProdService {

    List<MyProduct> getAllProduct(Integer page,Integer pageSize,MyProduct queryProd);
    MyProduct getProductById(String prodid);

    Integer getTotalPage(Integer pageSize ,MyProduct queryProd);

    Integer inserProd(MyProduct insertProd);

    Integer editProd(MyProduct editProd);

}
