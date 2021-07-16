package com.javasm.sys.service.impl;

import com.javasm.sys.entity.CrmSupplyGoods;
import com.javasm.sys.dao.CrmSupplyGoodsDao;
import com.javasm.sys.service.CrmSupplyGoodsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import com.javasm.commons.base.BaseServiceImpl;

@Service("crmSupplyGoodsService")
public class CrmSupplyGoodsServiceImpl extends BaseServiceImpl<CrmSupplyGoodsDao, CrmSupplyGoods> implements CrmSupplyGoodsService {

    @Override
    public List<CrmSupplyGoods> selectByIds(String id) {
        List<CrmSupplyGoods> crmSupplyGoods = dao.selectByIds(id);
        return crmSupplyGoods;
    }
}
