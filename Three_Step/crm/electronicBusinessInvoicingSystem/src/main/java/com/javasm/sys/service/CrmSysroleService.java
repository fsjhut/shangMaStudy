package com.javasm.sys.service;

import com.javasm.sys.entity.CrmSysrole;

import java.util.List;

import com.javasm.commons.base.BaseService;
import com.javasm.sys.entity.Menu;

public interface CrmSysroleService extends BaseService<CrmSysrole> {
    List<CrmSysrole> selectAllrole(CrmSysrole r);

    //设置权限
    boolean insertAll(Integer rid,String createBy, List<Integer> menus);

    Integer[] selectIds(Integer rid);
}
