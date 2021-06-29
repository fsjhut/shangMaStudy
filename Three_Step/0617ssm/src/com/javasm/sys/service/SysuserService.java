package com.javasm.sys.service;

import com.javasm.sys.entity.Sysuser;

import java.util.List;

import com.javasm.commons.base.BaseService;

public interface SysuserService extends BaseService<Sysuser> {
    Sysuser selectByUname(String uname);

    boolean comparePwd(String upwd, String upwd1);

    List<Sysuser> selectUserAndDeptList(Sysuser obj);
}
