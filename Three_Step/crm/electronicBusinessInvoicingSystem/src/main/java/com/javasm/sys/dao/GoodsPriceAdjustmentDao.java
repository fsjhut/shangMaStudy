package com.javasm.sys.dao;

import com.javasm.sys.entity.GoodsManager;
import com.javasm.sys.entity.GoodsPriceAdjustment;

import com.javasm.commons.base.BaseDao;
import org.apache.poi.ss.formula.functions.T;

import java.util.List;

public interface GoodsPriceAdjustmentDao extends BaseDao<GoodsPriceAdjustment> {


    int add(GoodsPriceAdjustment obj);
    int updateById(GoodsPriceAdjustment obj);
    int delById(String id);
    int delByIds(List<String> ids);

}

