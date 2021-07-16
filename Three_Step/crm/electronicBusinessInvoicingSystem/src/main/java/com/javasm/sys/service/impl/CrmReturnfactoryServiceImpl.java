package com.javasm.sys.service.impl;

import com.javasm.commons.bean.ReturnCrmReturnFactory;
import com.javasm.commons.utils.CurrentLoginUser;
import com.javasm.sys.entity.CrmFactoryGoods;
import com.javasm.sys.entity.CrmReturnfactory;
import com.javasm.sys.dao.CrmReturnfactoryDao;
import com.javasm.sys.entity.GoodsManager;
import com.javasm.sys.service.CrmFactoryGoodsService;
import com.javasm.sys.service.CrmReturnfactoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Random;

import com.javasm.commons.base.BaseServiceImpl;
import org.springframework.transaction.annotation.Transactional;

@Service("crmReturnfactoryService")
public class CrmReturnfactoryServiceImpl extends BaseServiceImpl<CrmReturnfactoryDao, CrmReturnfactory> implements CrmReturnfactoryService {

    @Resource
    private CrmFactoryGoodsService cs;

    @Override
    public Integer adds(CrmReturnfactory good) {
        int add = getDao().add(good);
        return good.getFid();
    }

    @Override
    public List<ReturnCrmReturnFactory > queryAll() {
        List<ReturnCrmReturnFactory > goodsManagers = getDao().queryAllGoods();
        return goodsManagers;
    }
    @Transactional
    @Override
    public boolean add(CrmReturnfactory obj) {
        //生成入库详细信息
        Integer code = (int)(Math.random()*99999+1);
        String recode = "FC"+code;
        obj.setRefactoryCode(recode);
        obj.setRefactoryFlag(0);
//        obj.setRefactoryState(0);
        obj.setCreateBy(CurrentLoginUser.getUname());
        int add = getDao().add(obj);
        Integer fid = obj.getFid();

        CrmFactoryGoods cg = new CrmFactoryGoods();
        cg.setGoodsCode(obj.getReturnsId());
        cg.setFid(fid);
        boolean b = cs.updateById(cg);
        return b;
    }
}
