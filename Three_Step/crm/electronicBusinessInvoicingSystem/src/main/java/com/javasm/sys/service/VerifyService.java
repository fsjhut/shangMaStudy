package com.javasm.sys.service;

import com.javasm.sys.entity.PromoteProduct;
import com.javasm.sys.entity.PromoteSale;
import com.javasm.sys.entity.Verify;

import java.util.List;
import java.util.Map;

import com.javasm.commons.base.BaseService;

public interface VerifyService extends BaseService<Verify> {

    Map<String, Object> selectDetailByTableId(String tableId);

    List<PromoteSale> selectAllList(PromoteSale obj);

    boolean addVerify(PromoteSale promoteSale, List<PromoteProduct> products);

    boolean updateVerify(PromoteSale promoteSale, List<PromoteProduct> products);
    //    Map<String,Object> selectDetailById(String id);
    @Override
    boolean add(Verify verify);
//    Verify selectStatusByTableId(String tableId);
}
