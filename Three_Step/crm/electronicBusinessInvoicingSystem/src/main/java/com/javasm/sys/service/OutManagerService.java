package com.javasm.sys.service;

import com.javasm.sys.entity.GoodsInfo;
import com.javasm.sys.entity.OutManager;

import java.util.List;

import com.javasm.commons.base.BaseService;

public interface OutManagerService extends BaseService<OutManager> {

    List<OutManager> selectType(String type);


    List<GoodsInfo>selectGoods(Integer outOrderNum);
}
