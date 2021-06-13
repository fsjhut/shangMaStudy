package com.javasm.mapper;

import com.javasm.entity.SysDept;

import java.util.List;

/**
 * @author SunHang
 * @className: SysDeptMapper
 * @description:
 * @createTime 2021/6/9 19:50
 */
public interface SysDeptMapper extends BaseMapper<SysDept> {
    List<SysDept> selectListDeptUsers();
}
