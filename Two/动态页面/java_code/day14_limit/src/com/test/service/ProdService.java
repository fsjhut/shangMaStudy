package com.test.service;

import com.test.entity.MyProduct;

import java.util.List;

/**
 * @author SunHang
 * @className: ProdService
 * @description:
 * @createTime 2021/5/14 16:25
 */
public interface ProdService {
    // 从数据库中查询出指定的页码的数据
    List<MyProduct> getAllProduct(Integer page,Integer pageSize,MyProduct queryProd);
    // 计算出出所有的页码数
    Integer getTotalPage(Integer pageSize ,MyProduct queryProd);
}
