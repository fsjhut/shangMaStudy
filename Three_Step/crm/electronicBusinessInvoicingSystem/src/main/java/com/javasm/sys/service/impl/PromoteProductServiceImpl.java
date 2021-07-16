package com.javasm.sys.service.impl;

import com.javasm.sys.entity.PromoteProduct;
import com.javasm.sys.dao.PromoteProductDao;
import com.javasm.sys.service.PromoteProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import com.javasm.commons.base.BaseServiceImpl;

@Service("promoteProductService")
public class PromoteProductServiceImpl extends BaseServiceImpl<PromoteProductDao, PromoteProduct> implements PromoteProductService {

    @Override
    public int batchAddObj(List<PromoteProduct> mapList) {
        return dao.batchAddObj(mapList);
    }

    @Override
    public int delByPromoteId(int pid) {
        return dao.delByPromoteId(pid);
    }

    @Override
    public List<PromoteProduct> selectByPromote(Integer pid) {
        return dao.selectByPromote(pid);
    }
}
