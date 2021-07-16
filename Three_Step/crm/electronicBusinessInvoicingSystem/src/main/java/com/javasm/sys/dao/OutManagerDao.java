package com.javasm.sys.dao;

import com.javasm.sys.entity.GoodsInfo;
import com.javasm.sys.entity.OutManager;
import org.apache.ibatis.annotations.Param;

import java.util.List;

import com.javasm.commons.base.BaseDao;

public interface OutManagerDao extends BaseDao<OutManager> {
    List<OutManager> selectType(String type);


    //通过出库单号  拿到 出库单上的要退换货的商品信息
    List<GoodsInfo>selectGoods(Integer outOrderNum);
}

