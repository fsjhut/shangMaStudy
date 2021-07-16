package com.javasm.sys.service;

import com.javasm.commons.base.BaseService;
import com.javasm.commons.entity.AxiosResult;
import com.javasm.sys.entity.GoodsGift;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsGiftService extends BaseService<GoodsGift> {


    List<GoodsGift> filterReviewStatus(GoodsGift obj);

    List<GoodsGift> selectType(@Param("param") String param);

    AxiosResult judgingPruductInventory(GoodsGift obj);


    List<GoodsGift> filterInvalidStatus(GoodsGift obj);

    int adds(GoodsGift obj);


}
