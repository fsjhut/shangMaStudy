package com.javasm.dao;

import com.javasm.entity.MyProduct;


import java.util.List;

public interface ProdDao {

    List<MyProduct> getAllProduct(Integer page,Integer pageSize,MyProduct queryProd);

    MyProduct getProductById(String prodid);

    Integer getAllProductNum(MyProduct queryProd);


    Integer inserProd(MyProduct insertProd);

    Integer editProd(MyProduct editProd);


}
