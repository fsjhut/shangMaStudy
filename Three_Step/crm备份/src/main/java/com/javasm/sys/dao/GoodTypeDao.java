package com.javasm.sys.dao;

import com.javasm.commons.base.BaseDao;
import com.javasm.sys.entity.GoodType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (GoodType)表数据库访问层
 *
 * @author makejava
 * @since 2021-06-30 16:21:45
 */
public interface GoodTypeDao extends BaseDao<GoodType> {
    List<GoodType> selectChilds(@Param("goodType") GoodType obj, @Param("pid") Integer pid);

    List<Integer> getAllHasChildsDid();
}

