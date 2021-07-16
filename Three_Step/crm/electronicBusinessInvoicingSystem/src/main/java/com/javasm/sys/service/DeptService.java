package com.javasm.sys.service;

import com.javasm.commons.base.BaseService;
import com.javasm.commons.entity.AxiosResult;
import com.javasm.sys.entity.Dept;

import java.util.List;

public interface DeptService extends BaseService<Dept> {
    //查询每一个部门中有多少人数，以及没有人数的部门
    List<Dept> selectByUserDeptno();

    List<Dept> createTree(List<Dept> depts);

    AxiosResult isParentDept(Dept dept);

    AxiosResult updateDeptInfo(Dept obj);

    AxiosResult addDeptInfo(Dept obj);
}
