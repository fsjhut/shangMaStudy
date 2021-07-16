package com.javasm.sys.service;

import com.javasm.sys.entity.MaintainManager;

import java.util.List;

import com.javasm.commons.base.BaseService;

public interface MaintainManagerService extends BaseService<MaintainManager> {

    int saves(List<MaintainManager> list);


}
