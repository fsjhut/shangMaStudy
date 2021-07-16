package com.javasm.sys.dao;


import com.javasm.commons.base.BaseDao;
import com.javasm.sys.entity.Dept;

import java.util.List;

public interface DeptDao extends BaseDao<Dept> {

    //查询每一个部门中有多少人数，以及没有人数的部门
    List<Dept> selectByUserDeptno();

}

