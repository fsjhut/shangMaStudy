package com.javasm.commons.base;


import java.util.List;

public interface BaseDao<T> {
    T selectById(String id);
    List<T> selectList(T obj);

    int add(T obj);
    int updateById(T obj);
    int delById(String id);
    int delByIds(List<String> ids);
}
