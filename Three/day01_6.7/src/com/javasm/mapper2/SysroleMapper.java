package com.javasm.mapper2;

import com.javasm.entity.Sysrole;
import com.javasm.entity.Sysuser;

import java.util.List;

/**
 * @author SunHang
 * @className: SysroleMapper
 * @description:
 * @createTime 2021/6/8 12:43
 */
public interface SysroleMapper {
    Sysrole selectRoleByKey(Integer id);
    Sysuser selectUserAndRoleByKey(Integer id);
    List<Sysuser> selectUsersAndRole();
}
