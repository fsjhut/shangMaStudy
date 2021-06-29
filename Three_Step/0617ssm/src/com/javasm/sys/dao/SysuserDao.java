package com.javasm.sys.dao;

import com.javasm.sys.entity.Sysuser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

import com.javasm.commons.base.BaseDao;

public interface SysuserDao extends BaseDao<Sysuser> {

    List<Sysuser> selectUserAndDept(Sysuser obj);
}

