package com.javasm.sys.service.impl;

import com.javasm.sys.entity.GoodsInfo;
import com.javasm.sys.dao.GoodsInfoDao;
import com.javasm.sys.service.GoodsInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import com.javasm.commons.base.BaseServiceImpl;

@Service("goodsInfoService")
public class GoodsInfoServiceImpl extends BaseServiceImpl<GoodsInfoDao, GoodsInfo> implements GoodsInfoService {
	@Override
    public List<GoodsInfo> selectGoodsByOrderId(String orderId) {


        return dao.selectGoodsByOrderId(orderId);
    }
    @Override
    public List<GoodsInfo> selectExchangeGoods() {

        List<GoodsInfo> goodsInfos = dao.selectExchangeGoods();
        return goodsInfos;
    }



}
