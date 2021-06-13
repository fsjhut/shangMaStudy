package com.javasm.mapper;

import com.javasm.entity.SysPermission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @className: SysPermissionMapper
 * @description:   
 * @author SunHang
 * @createTime 2021/6/9 19:34
 */
public interface SysPermissionMapper extends BaseMapper<SysPermission>{
//    List<SysPermission> selectAllPerByUid(int uid);
    // 查询角色关联的所有权限列表
    List<SysPermission> selectPermissionByRoleId(Integer rid);
    // 查询角色下的权限列表的叶子节点
    List<SysPermission> selectLastNodePermissionByRoleId(Integer rid);
    // 查询当前权限的同级上一个权限
    SysPermission selectUpPermission(@Param("pid") Integer pid, @Param("perSort") Integer perSort);

}
