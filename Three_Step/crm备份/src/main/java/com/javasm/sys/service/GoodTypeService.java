package com.javasm.sys.service;

import com.javasm.commons.base.BaseService;
import com.javasm.sys.entity.GoodType;

import java.util.List;

/**
 * (GoodType)表服务接口
 *
 * @author makejava
 * @since 2021-06-30 16:21:48
 */
public interface GoodTypeService extends BaseService<GoodType> {
    boolean hasChilds(String id);
    List<GoodType> createTree(List<GoodType> list);
}
