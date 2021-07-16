package com.javasm.sys.service.impl;

import com.javasm.commons.base.BaseServiceImpl;
import com.javasm.commons.utils.CurrentLoginUser;
import com.javasm.commons.utils.DateUtil;
import com.javasm.sys.dao.GoodsPriceAdjustmentDao;
import com.javasm.sys.entity.GoodsPriceAdjustment;
import com.javasm.sys.service.GoodsPriceAdjustmentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service("goodsPriceAdjustmentService")
public class GoodsPriceAdjustmentServiceImpl extends BaseServiceImpl<GoodsPriceAdjustmentDao, GoodsPriceAdjustment> implements GoodsPriceAdjustmentService {



    @Override
    public Integer adds(GoodsPriceAdjustment good) {

        int rows = dao.add(good);
        return good.getPriceAdjustmentId();
    }


    @Transactional
    @Override
    public boolean updateById(GoodsPriceAdjustment obj) {
        obj.setUpdateBy(CurrentLoginUser.getUname());
        obj.setUpdateTime(DateUtil.getYMDHMS());
        int rows = dao.updateById(obj);

        return rows==1;
    }

    @Override
    public boolean delById(String id) {
        int i = dao.delById(id);
        return i == 1;
    }

    @Override
    public boolean delByIds(List<String> ids) {
        int i = dao.delByIds(ids);
        return i>0?true:false;
    }

}
