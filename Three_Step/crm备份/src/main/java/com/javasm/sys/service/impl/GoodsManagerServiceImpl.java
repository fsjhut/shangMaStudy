package com.javasm.sys.service.impl;

import com.javasm.commons.cache.RedisService;
import com.javasm.sys.entity.GoodsManager;
import com.javasm.sys.dao.GoodsManagerDao;
import com.javasm.sys.service.GoodsManagerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import com.javasm.commons.base.BaseServiceImpl;

@Service("goodsManagerService")
public class GoodsManagerServiceImpl extends BaseServiceImpl<GoodsManagerDao, GoodsManager> implements GoodsManagerService {


    @Override
    public boolean setGoodsLevel(GoodsManager goodsManager,Integer goodsLevel) {
        goodsManager.setGoodsLevel(goodsLevel);
        int add = dao.add(goodsManager);

        return add==1?true:false;
    }

    @Override
    public List<GoodsManager> selectGoodListNotIncludePriceAdjust(GoodsManager manager) {

        return dao.selectGoodListNotIncludePriceAdjust(manager);
    }

    @Override
    public List<String> selectType(String type) {
        return dao.selectType(type);
    }
}
