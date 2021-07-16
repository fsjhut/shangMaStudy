package com.javasm.sys.service.impl;

import com.javasm.commons.utils.DataProcessUtil;
import com.javasm.sys.entity.MaintainManager;
import com.javasm.sys.dao.MaintainManagerDao;
import com.javasm.sys.service.MaintainManagerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import com.javasm.commons.base.BaseServiceImpl;
import org.springframework.transaction.annotation.Transactional;

@Service("maintainManagerService")
public class MaintainManagerServiceImpl extends BaseServiceImpl<MaintainManagerDao, MaintainManager> implements MaintainManagerService {

    @Resource
    private MaintainManagerDao dao;
    @Transactional
    @Override
    public int saves(List<MaintainManager> list) {

        List<List<MaintainManager>> lists = DataProcessUtil.subList(list, 30);

        Integer count = 0;
        for (List<MaintainManager> item : lists) {
            int saves = dao.saves(item);
            count += saves;
        }
        return count;
    }
}
