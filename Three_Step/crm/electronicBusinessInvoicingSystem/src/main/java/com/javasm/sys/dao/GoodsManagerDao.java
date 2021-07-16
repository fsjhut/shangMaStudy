package com.javasm.sys.dao;

import com.javasm.sys.entity.GoodsManager;


import com.javasm.commons.base.BaseDao;

import java.util.List;

public interface GoodsManagerDao extends BaseDao<GoodsManager> {



    //创建一类二类商品
    boolean setGoodsLevel(GoodsManager goodsManager,Integer goodsLevel);
    //批量增加商品
    int insertGoods(List<GoodsManager> goodsManagers);

    //  查找未修改价格的商品
    public List<GoodsManager> selectGoodListNotIncludePriceAdjust(GoodsManager manager);

    public List<GoodsManager> selectType(String type);

}

