package com.javasm.sys.service.impl;

import com.javasm.sys.entity.GoodsManager;
import com.javasm.sys.dao.GoodsManagerDao;
import com.javasm.sys.service.GoodsManagerService;
import org.springframework.stereotype.Service;



import com.javasm.commons.base.BaseServiceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service("goodsManagerService")
public class GoodsManagerServiceImpl extends BaseServiceImpl<GoodsManagerDao, GoodsManager> implements GoodsManagerService {


    @Override
    public boolean setGoodsLevel(GoodsManager goodsManager,Integer goodsLevel) {
        goodsManager.setGoodsLevel(goodsLevel);
        int add = dao.add(goodsManager);

        return add==1?true:false;
    }


    @Override
    public boolean insertGoods(List<GoodsManager> goodsManagers) {
        int i = dao.insertGoods(goodsManagers);

        return i==1?true:false;
    }


    @Override
    public List<GoodsManager> selectGoodListNotIncludePriceAdjust(GoodsManager manager) {

        return dao.selectGoodListNotIncludePriceAdjust(manager);
    }

    public List<GoodsManager> selectType(String type) {

        List<GoodsManager> GoodsManagerS = dao.selectType(type);
        return GoodsManagerS;
    }

//    @Override
//    public List<Object> selectType(String type) {
//        List<String> list = dao.selectType(type);
//        ArrayList<Object> list1 = new ArrayList<>();
//        list.stream().forEach((o)->{
//            Object put = new HashMap<>();
//            ((HashMap) put).put("value",o);
//            ((HashMap) put).put("lable",o);
//            list1.add(put);
//        });
//        return list1;
//    }


}
