package com.javasm.sys.dao;

import com.javasm.sys.entity.MaintainManager;
import org.apache.ibatis.annotations.Param;

import java.util.List;

import com.javasm.commons.base.BaseDao;

public interface MaintainManagerDao extends BaseDao<MaintainManager> {

    int saves(List<MaintainManager> list);


}

