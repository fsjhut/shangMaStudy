package com.javasm.sys.service;

import com.javasm.sys.entity.GoodsManager;


import com.javasm.commons.base.BaseService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsManagerService extends BaseService<GoodsManager> {


    boolean setGoodsLevel(GoodsManager goodsManager, @Param("goodsLevel") Integer goodsLevel);

    //  老王：查找未修改价格的商品
    public List<GoodsManager> selectGoodListNotIncludePriceAdjust(GoodsManager manager);
    //  老王：查找指定类型list
    public List<String> selectType(String type);
}
