package com.javasm.sys.service;

import com.javasm.sys.entity.CrmSysuser;

import com.javasm.commons.base.BaseService;

public interface CrmSysuserService extends BaseService<CrmSysuser> {
    //登录
    boolean login(CrmSysuser u);


}
