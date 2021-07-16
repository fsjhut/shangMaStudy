package com.javasm.sys.service.impl;

import com.javasm.commons.base.BaseServiceImpl;
import com.javasm.commons.entity.AxiosResult;
import com.javasm.commons.entity.S;
import com.javasm.commons.utils.CurrentLoginUser;
import com.javasm.sys.dao.GoodsGiftDao;
import com.javasm.sys.dao.GoodsManagerDao;
import com.javasm.sys.entity.GoodsGift;
import com.javasm.sys.entity.GoodsManager;
import com.javasm.sys.service.GoodsGiftService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service("goodsGiftService")
public class GoodsGiftServiceImpl extends BaseServiceImpl<GoodsGiftDao, GoodsGift> implements GoodsGiftService {

    @Resource
    private GoodsManagerDao goodsManagerDao;

    @Override
    public List<GoodsGift> selectList(GoodsGift obj) {
        System.out.println("getGiftReviewstatus===>>>>>" + obj.getGiftReviewstatus());
        return super.selectList(obj);
    }


    @Override
    public List<GoodsGift> filterReviewStatus(GoodsGift obj) {
        List<GoodsGift> goodsGifts = getDao().selectList(obj);
        Set<GoodsGift> set = new HashSet();
        List<GoodsGift> goodsGiftsList = new ArrayList<>();
        for (GoodsGift goodsGift : goodsGifts) {
            Integer giftReviewstatus = goodsGift.getGiftReviewstatus();
            if (giftReviewstatus == 0) {
                GoodsGift good = new GoodsGift();
                good.setGiftReviewstatus(0);
                good.setDescInfo("未审核");
                set.add(good);

            }
            //0：未审核，1：通过，2：未通过

            if (giftReviewstatus == 1) {
                GoodsGift good = new GoodsGift();
                good.setGiftReviewstatus(1);
                good.setDescInfo("通过");
                set.add(good);
            }

            if (giftReviewstatus == 2) {
                GoodsGift good = new GoodsGift();
                good.setGiftReviewstatus(2);
                good.setDescInfo("未通过");
                set.add(good);
                //goodsGiftsList.add(goodsGift);
            }
        }
        goodsGiftsList.addAll(set);
        return goodsGiftsList;
    }

    @Override
    public List<GoodsGift> selectType(String param) {
        List<GoodsGift> goodsGifts = getDao().selectType(param);
        return goodsGifts;
    }

    @Override
    public AxiosResult judgingPruductInventory(GoodsGift obj) {
        //添加创建人
        obj.setCreateBy(CurrentLoginUser.getUname());
        //判断库存是否大于转赠品的数量

        //为true可以转赠
        boolean judgement = false;
        //商品转赠品，
        //1.判断商品转赠品的库存是否大于赠品数量，大于曾转赠成功，否则库存不足
        GoodsManager goodsManager = goodsManagerDao.selectById(String.valueOf(obj.getGoodsId()));
        //商品库存数量
        Integer inventoryNumber = goodsManager.getInventoryNumber();

        //商品转赠品数量
        Integer giftNumber = obj.getGiftNumber();
        if (inventoryNumber > giftNumber) {
            judgement = true;
        }

        if (judgement) {
            //不存在执行add方法
            int add = getDao().add(obj);
            if (add > 0) {
                return AxiosResult.suc();
            }
            return AxiosResult.error();

        }
        return AxiosResult.error(S.INVENTORY_STORTAGE);

    }

    @Override
    public List<GoodsGift> filterInvalidStatus(GoodsGift obj) {
        List<GoodsGift> goodsGifts = getDao().filterInvalidStatus(obj);

        return goodsGifts;
    }

    @Override
    public int adds(GoodsGift obj) {
        obj.setGiftReviewstatus(0);
        //执行添加方法
        getDao().add(obj);
        //获取自增id
        Integer goodsId = obj.getGoodsId();
        System.out.println("goodsId===>" + goodsId);
        return goodsId;

    }


}
