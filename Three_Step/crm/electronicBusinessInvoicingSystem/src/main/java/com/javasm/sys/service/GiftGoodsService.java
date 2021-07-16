package com.javasm.sys.service;

import com.javasm.commons.base.BaseService;
import com.javasm.sys.entity.GiftGoods;

import java.util.List;

public interface GiftGoodsService extends BaseService<GiftGoods> {
    /**
     * 查询所有赠品品牌
     * @param obj
     * @return
     */
    List<GiftGoods> selectBrand(String obj);
    /**
     * 查询所有的颜色
     * @param obj
     * @return
     */

    List<GiftGoods>selectColor(String obj);

    /**
     * 查询所有类型
     * @param obj
     * @return
     */
    List<GiftGoods>selectType(String obj);

    /**
     * 查询所有审核状态
     * @param obj
     * @return
     */
    List<GiftGoods>selectReviewstatus(Integer obj);

    Integer adds(GiftGoods good);
    /**
     * 进行审核展示，只展示未审核的
     * @param giftGoods
     * @return
     */
    List<GiftGoods>select(GiftGoods giftGoods);

    /**
     * 未审核状态的赠品颜色
     * @param giftGoods
     * @return
     */
    List<GiftGoods>selectclors(GiftGoods giftGoods);
    /**
     * 查询所有赠品品牌
     * @param obj
     * @return
     */
    List<GiftGoods> selectBrand1(String obj);
    /**
     * 查询所有类型
     * @param obj
     * @return
     */
    List<GiftGoods>selectType1(String obj);

}
