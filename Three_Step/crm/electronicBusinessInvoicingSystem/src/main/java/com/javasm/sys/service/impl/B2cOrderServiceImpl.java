package com.javasm.sys.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.javasm.sys.entity.B2cOrder;
import com.javasm.sys.dao.B2cOrderDao;
import com.javasm.sys.entity.GoodsInfo;
import com.javasm.sys.service.B2cOrderService;
import com.javasm.sys.service.GoodsInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.javasm.commons.base.BaseServiceImpl;

@Service("b2cOrderService")
public class B2cOrderServiceImpl extends BaseServiceImpl<B2cOrderDao, B2cOrder> implements B2cOrderService {

    @Resource
    GoodsInfoService goodsInfoService;

    @Override
    public Map<String, Object> selectOrderDetailById(String orderId) {
        // 进行连表查询
        B2cOrder b2cOrder = dao.selectOrderDetailById(orderId);
        List<GoodsInfo> goodsInfos = goodsInfoService.selectGoodsByOrderId(orderId);
        Map<String, Object> stringObjectMap = new HashMap<>();
        stringObjectMap.put("consigneeInfo",JSONArray.toJSON(b2cOrder.getConsigneeInformation()));
        stringObjectMap.put("orderDeatail", JSONArray.toJSON(b2cOrder));
        stringObjectMap.put("productDate",JSONArray.toJSON(goodsInfos));
        return stringObjectMap;
    }

    @Override
    public int insertB2C(List<B2cOrder> list) {
        int i = getDao().insertB2C(list);
        if( i>0) return i;
        return 0;
    }




}
