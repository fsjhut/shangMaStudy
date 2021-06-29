package com.javasm.sys.dao;

import com.javasm.sys.entity.Sysdept;
import org.apache.ibatis.annotations.Param;

import java.util.List;

import com.javasm.commons.base.BaseDao;

public interface SysdeptDao extends BaseDao<Sysdept> {

    List<Sysdept> selectChilds(@Param("dept") Sysdept obj, @Param("parentid") Integer parentid);

    List<Integer> getAllHasChildsDid();
}
