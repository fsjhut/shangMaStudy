package com.javasm.sys.service.impl;

import com.javasm.sys.dao.GiftGoodsDao;
import com.javasm.sys.entity.GiftGoods;
import com.javasm.sys.service.GiftGoodsService;
import org.springframework.stereotype.Service;

import java.util.List;

import com.javasm.commons.base.BaseServiceImpl;

@Service("giftGoodsService")
public class GiftGoodsServiceImpl extends BaseServiceImpl<GiftGoodsDao, GiftGoods> implements GiftGoodsService {

    @Override
    public List<GiftGoods> selectBrand(String obj) {

        List<GiftGoods> giftGoods = getDao().selectBrand(obj);
        if(giftGoods.size()>0) return giftGoods;
        return null;
    }

    @Override
    public List<GiftGoods> selectColor(String obj) {
        List<GiftGoods> giftGoods = getDao().selectColor(obj);
        if(giftGoods.size()>0) return giftGoods;
        return null;
    }

    @Override
    public List<GiftGoods> selectType(String obj) {
        List<GiftGoods> giftGoods = getDao().selectType(obj);
        if(giftGoods.size()>0) return giftGoods;
        return null;
    }

    @Override
    public List<GiftGoods> selectReviewstatus(Integer obj) {
        List<GiftGoods> giftGoods = getDao().selectReviewstatus(obj);
        if(giftGoods.size()>0) return giftGoods;
        return null;
    }

    @Override
    public Integer adds(GiftGoods good) {
        int rows = dao.add(good);
        return good.getGiftId();
    }

    @Override
    public List<GiftGoods> select(GiftGoods giftGoods) {
        giftGoods.setGiftReviewstatus(0);
        List<GiftGoods> giftGoods1 = getDao().selectList(giftGoods);

        return giftGoods1;
    }

    @Override
    public List<GiftGoods> selectclors(GiftGoods giftGoods) {
//        giftGoods.setGiftReviewstatus(0);
        List<GiftGoods> selectclors = getDao().selectclors(giftGoods);
      if(selectclors.size()>0)  return selectclors;
      return null;
    }

    @Override
    public List<GiftGoods> selectBrand1(String obj) {
        List<GiftGoods> giftGoods = getDao().selectBrand1(obj);
        return giftGoods;
    }

    @Override
    public List<GiftGoods> selectType1(String obj) {
        List<GiftGoods> giftGoods = getDao().selectType1(obj);
        return giftGoods;
    }
}
