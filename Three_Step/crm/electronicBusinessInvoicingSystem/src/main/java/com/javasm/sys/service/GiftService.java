package com.javasm.sys.service;

import com.javasm.sys.entity.Gift;

import com.javasm.commons.base.BaseService;

import java.util.List;

public interface GiftService extends BaseService<Gift> {
    /**
     * 查询所有赠品品牌
     * @param giftBrand
     * @return
     */
    List<Gift> selectBrand(String giftBrand);
    /**
     * 查询所有的颜色
     * @param color
     * @return
     */
    List<Gift>selectColor(String color);
    /**
     * 查询所有类型
     * @param giftType
     * @return
     */
    List<Gift>selectType(String giftType);
}
