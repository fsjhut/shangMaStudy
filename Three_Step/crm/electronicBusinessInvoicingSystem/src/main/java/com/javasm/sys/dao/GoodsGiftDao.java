package com.javasm.sys.dao;

import com.javasm.commons.base.BaseDao;
import com.javasm.sys.entity.GoodsGift;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsGiftDao extends BaseDao<GoodsGift> {


    List<GoodsGift> selectType(@Param("param") String param);

    List<GoodsGift> filterInvalidStatus(GoodsGift obj);


}


