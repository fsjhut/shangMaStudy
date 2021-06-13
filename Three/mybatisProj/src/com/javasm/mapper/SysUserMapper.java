package com.javasm.mapper;

import com.javasm.entity.SysPermission;
import com.javasm.entity.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author SunHang
 * @className: SysuserMapper
 * @description:
 * @createTime 2021/6/7 20:19
 */
public interface SysUserMapper extends BaseMapper<SysUser>{


    // 多个对象联合查询(查询结果为单个用户对象)
    // 利用聚合查询
    SysUser selectOnePermissions(int id);
    List<SysUser> selectListPermissions();
}
