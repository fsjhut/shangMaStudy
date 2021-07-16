package com.javasm.sys.service;

import com.javasm.sys.entity.CrmSysuser;

import com.javasm.commons.base.BaseService;

import java.util.List;

public interface CrmSysuserService extends BaseService<CrmSysuser> {
    //登录
    boolean login(CrmSysuser u);

    //分页查询全部
    List<CrmSysuser> queryAll(CrmSysuser u);
    //禁用用户
    boolean editState(String id);
    //启用用户
    boolean openState(String id);
}
