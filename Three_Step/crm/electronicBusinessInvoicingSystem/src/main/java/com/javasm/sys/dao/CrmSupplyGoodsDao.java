package com.javasm.sys.dao;

import com.javasm.sys.entity.CrmSupplyGoods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

import com.javasm.commons.base.BaseDao;

public interface CrmSupplyGoodsDao extends BaseDao<CrmSupplyGoods> {
    List<CrmSupplyGoods> selectByIds(String id);
}

