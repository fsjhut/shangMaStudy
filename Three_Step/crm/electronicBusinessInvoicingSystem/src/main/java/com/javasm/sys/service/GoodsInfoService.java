package com.javasm.sys.service;

import com.javasm.sys.entity.GoodsInfo;

import java.util.List;

import com.javasm.commons.base.BaseService;

public interface GoodsInfoService extends BaseService<GoodsInfo> {
 List<GoodsInfo> selectGoodsByOrderId(String orderId);

    List<GoodsInfo> selectExchangeGoods();
}
