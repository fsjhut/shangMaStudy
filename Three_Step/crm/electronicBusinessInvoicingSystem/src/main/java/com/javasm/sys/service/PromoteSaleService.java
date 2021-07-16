package com.javasm.sys.service;

import com.javasm.sys.entity.PromoteProduct;
import com.javasm.sys.entity.PromoteSale;

import java.util.List;
import java.util.Map;

import com.javasm.commons.base.BaseService;

public interface PromoteSaleService extends BaseService<PromoteSale> {

    Map<String,Object> selectDetailById(String id);
//    Map<String,Object> selectSimpleList(PromoteSale promoteSale);
    boolean add(PromoteSale promoteSale, List<PromoteProduct> products);
    Integer submit(PromoteSale promoteSale, List<PromoteProduct> products);
    boolean updateById(PromoteSale promoteSale, List<PromoteProduct> products);
}
