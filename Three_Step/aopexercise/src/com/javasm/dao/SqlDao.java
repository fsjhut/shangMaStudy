package com.javasm.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author SunHang
 * @className: SqlDao
 * @description:
 * @createTime 2021/6/11 19:17
 */
public interface SqlDao<T> {
    // 添加单个对象
    int addObj(T t) throws SQLException;

    // 根据id删除单个对象
    int delObj(int id) throws SQLException;

    // 更新对象
    int updateObj(T t) throws SQLException;

    // 根据id查询对象
    T selectById(int id) throws SQLException;

    // 查询所有的对象
    List<T> selectList() throws SQLException;

}
