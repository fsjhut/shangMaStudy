package com.javasm.sys.service;

import com.javasm.sys.entity.CrmSupplyGoods;

import java.util.List;

import com.javasm.commons.base.BaseService;

public interface CrmSupplyGoodsService extends BaseService<CrmSupplyGoods> {
    List<CrmSupplyGoods> selectByIds(String id);
}
