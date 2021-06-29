package com.javasm.commons.base;

import java.util.List;

/**
 * @author SunHang
 * @className: BaseService
 * @description:
 * @createTime 2021/6/17 20:50
 */
public interface BaseService<T> {
    T selectById(String id);
    List<T> selectList(T obj);

    boolean add(T obj);
    boolean updateById(T obj);
    boolean delById(String id);
    boolean delByIds(List<String> ids);
}
