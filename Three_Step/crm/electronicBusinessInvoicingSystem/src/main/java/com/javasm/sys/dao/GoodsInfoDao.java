package com.javasm.sys.dao;

import com.javasm.sys.entity.GoodsInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

import com.javasm.commons.base.BaseDao;

public interface GoodsInfoDao extends BaseDao<GoodsInfo> {
    List<GoodsInfo> selectGoodsByOrderId(String orderId);
    //通过串码关联  商品表和退换货审核表 去拿到商品信息和退换信息 整合到一张表

    List<GoodsInfo> selectExchangeGoods();

}

