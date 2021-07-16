package com.javasm.sys.dao;

import com.javasm.sys.entity.CrmSysuser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

import com.javasm.commons.base.BaseDao;

public interface CrmSysuserDao extends BaseDao<CrmSysuser> {
    List<CrmSysuser> selectAll(CrmSysuser u);

    int Sysuserforbidden(String id);

    int sysuserOpen(String id);
}

