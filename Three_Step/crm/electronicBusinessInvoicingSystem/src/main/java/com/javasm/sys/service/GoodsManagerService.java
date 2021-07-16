package com.javasm.sys.service;


import com.javasm.sys.entity.GoodsManager;


import com.javasm.commons.base.BaseService;



import java.util.List;


public interface GoodsManagerService extends BaseService<GoodsManager> {


    //创建一类二类商品
    boolean setGoodsLevel(GoodsManager goodsManager,Integer goodsLevel);


    //批量增加商品
    boolean insertGoods(List<GoodsManager> goodsManagers);


    //  老王：查找未修改价格的商品
    List<GoodsManager> selectGoodListNotIncludePriceAdjust(GoodsManager manager);
    //  老王：查找指定类型list
//    List selectType(String type);
    List<GoodsManager> selectType(String type);


}
