package com.javasm.mapper;

import com.javasm.entity.SysRole;
import com.javasm.entity.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author SunHang
 * @className: SysRoleMapper
 * @description:
 * @createTime 2021/6/8 20:42
 */
public interface SysRoleMapper extends BaseMapper<SysRole>{
    // 给角色授予多个权限
    int setPermisisons(@Param("rid") Integer rid,@Param("perids") Integer[] perids);
    // 移出所有的权限
    int removePermissionByRoleId(Integer rid);

    List<SysRole> selectListRolePermissions();
    List<SysRole> selectListRoleUsers();


}
