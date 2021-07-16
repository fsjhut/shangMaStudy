package com.javasm.sys.service;

import com.javasm.commons.bean.ReturnCrmReturnFactory;
import com.javasm.sys.entity.CrmReturnfactory;

import java.util.List;

import com.javasm.commons.base.BaseService;
import com.javasm.sys.entity.GoodsManager;

public interface CrmReturnfactoryService extends BaseService<CrmReturnfactory> {
    Integer adds(CrmReturnfactory good);

    List<ReturnCrmReturnFactory > queryAll();
}
