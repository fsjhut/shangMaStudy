package com.javasm.sys.dao;

import com.javasm.sys.entity.CrmSysrole;

import com.javasm.commons.base.BaseDao;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CrmSysroleDao extends BaseDao<CrmSysrole> {
    //复合查询角色信息
    List<CrmSysrole> selectAll(CrmSysrole r);
    //批量插入
    int insertSysroles(@Param("rid") Integer rid,@Param("createBy") String createBy, @Param("menuids") List<Integer> menus);
    //删除所有角色下权限
    int deleteSysroles(Integer rid);
    //查询当前角色下权限id
    Integer[] selectIds(Integer rid);
}

