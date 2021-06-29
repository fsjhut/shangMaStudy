package com.javasm.sys.dao;

import com.javasm.commons.base.BaseDao;
import com.javasm.sys.entity.Sysuser;

import java.util.List;

public interface SysuserDao extends BaseDao<Sysuser> {

    List<Sysuser> selectUserAndDept(Sysuser obj);
}
