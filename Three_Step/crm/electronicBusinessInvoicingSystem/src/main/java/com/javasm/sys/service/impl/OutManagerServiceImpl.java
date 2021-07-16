package com.javasm.sys.service.impl;

import com.javasm.sys.entity.GoodsInfo;
import com.javasm.sys.entity.OutManager;
import com.javasm.sys.dao.OutManagerDao;
import com.javasm.sys.service.OutManagerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import com.javasm.commons.base.BaseServiceImpl;

@Service("outManagerService")
public class OutManagerServiceImpl extends BaseServiceImpl<OutManagerDao, OutManager> implements OutManagerService {

    @Override
    public List<OutManager> selectType(String type) {
        List<OutManager> list = dao.selectType(type);
        return list;
    }

    @Override
    public List<GoodsInfo> selectGoods(Integer outOrderNum) {
        List<GoodsInfo> goodsInfos = dao.selectGoods(outOrderNum);
        return goodsInfos;
    }
}
