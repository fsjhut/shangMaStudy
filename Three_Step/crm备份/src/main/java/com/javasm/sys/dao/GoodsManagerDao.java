package com.javasm.sys.dao;

import com.javasm.sys.entity.GoodsManager;
import org.apache.ibatis.annotations.Param;

import java.util.List;

import com.javasm.commons.base.BaseDao;

public interface GoodsManagerDao extends BaseDao<GoodsManager> {

    //  查找未修改价格的商品
    public List<GoodsManager> selectGoodListNotIncludePriceAdjust(GoodsManager manager);

    public List<String> selectType(String type);
}

