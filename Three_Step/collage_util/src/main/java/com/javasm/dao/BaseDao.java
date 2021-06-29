package com.javasm.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author SunHang
 * @className: BaseDao
 * @description:
 * @createTime 2021/6/8 20:32
 */
public interface BaseDao<T> {
    // 添加单个对象
    int addObj(T t);
    // 批量添加对象
    int batchAddObjs(T[] ts);
    // 根据id删除单个对象
    int delObj(int id);
    // 根据id批量删除
    int batchDelObjs(@Param("ids") List<Integer> ids);
    // 更新对象
    int updateObj(T t);
    // 根据id查询对象
    T selectById(int id);
    // 查询所有的对象
    List<T> selectList();
    // 根据条件进行查询
    List<T> selectListByParams(Map<String, String> params);
    // 多个对象联合查询(查询结果为单个对象)
    T selectOneObjAndObj(int id);
    // 多个对象联合查询(查询结果为List<T>)
    List<T> selectListObjAndObj();
}
