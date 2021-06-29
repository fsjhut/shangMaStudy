package com.javasm.commons.base;

import java.util.List;

/**
 * @className: BaseDap
 * @description:   
 * @author SunHang
 * @createTime 2021/6/17 20:47
 */
public interface BaseDao<T> {
    T selectById(String id);
    List<T> selectList(T obj);

    int add(T obj);
    int updateById(T obj);
    int delById(String id);
    int delByIds(List<String> ids);
}
