package com.javasm.sys.service;

import com.javasm.commons.base.BaseService;
import com.javasm.sys.entity.GoodsPriceAdjustment;

import java.util.List;


public interface GoodsPriceAdjustmentService extends BaseService<GoodsPriceAdjustment> {

    boolean add(GoodsPriceAdjustment good);
    Integer adds(GoodsPriceAdjustment good);
    @Override
    boolean updateById(GoodsPriceAdjustment obj);
    boolean delById(String id);
    boolean delByIds(List<String> ids);
}
