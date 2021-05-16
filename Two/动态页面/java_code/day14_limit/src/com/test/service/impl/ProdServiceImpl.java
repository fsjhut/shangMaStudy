package com.test.service.impl;

import com.test.dao.ProdDao;
import com.test.dao.impl.ProdDaoImpl;
import com.test.entity.MyProduct;
import com.test.service.ProdService;

import java.util.List;

/**
 * @className: ProdServiceImpl
 * @description:   
 * @author SunHang
 * @createTime 2021/5/14 16:25
 */
public class ProdServiceImpl implements ProdService {
//    private Integer allProductNum;
    @Override
    public List<MyProduct> getAllProduct(Integer page, Integer pageSize, MyProduct queryProd) {
        ProdDao prodDao = new ProdDaoImpl();
        return prodDao.getAllProduct(page, pageSize, queryProd);
    }

    @Override
    public Integer getTotalPage(Integer pageSize, MyProduct queryProd) {
        // 查询 所有 的数据记录
        ProdDao prodDao = new ProdDaoImpl();
        Integer allProductNum = prodDao.getAllProductNum(queryProd);
        Integer totalPage;
        totalPage = allProductNum%pageSize>0?(allProductNum/pageSize)+1:allProductNum/pageSize;
        return totalPage;
    }
}
