package com.javasm.service;

import com.javasm.entity.SysUser;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author SunHang
 * @className: sqlService
 * @description:
 * @createTime 2021/6/11 19:16
 */
public interface SqlService {

    // 添加单个对象
    int addUser(SysUser t) throws SQLException;

    // 根据id删除单个对象
    int delUser(int id) throws SQLException;

    // 更新对象
    int updateUser(SysUser t) throws SQLException;

    // 根据id查询对象
    SysUser selectUserById(int id) throws SQLException;

    // 查询所有的对象
    List<SysUser> selectUserList() throws SQLException;
}
