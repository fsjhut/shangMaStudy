package com.javasm.sys.dao;

import com.javasm.commons.bean.ReturnCrmReturnFactory;
import com.javasm.sys.entity.CrmReturnfactory;
import com.javasm.sys.entity.GoodsManager;
import org.apache.ibatis.annotations.Param;

import java.util.List;

import com.javasm.commons.base.BaseDao;

public interface CrmReturnfactoryDao extends BaseDao<CrmReturnfactory> {

    //查询所有已出库的问题商品
    List<ReturnCrmReturnFactory> queryAllGoods();
}

