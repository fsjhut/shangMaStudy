package com.javasm.sys.dao;

import com.javasm.sys.entity.Verify;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

import com.javasm.commons.base.BaseDao;

public interface VerifyDao extends BaseDao<Verify> {
    List<Verify> selectDetailByTableId(String tableId);
    Verify selectStatusByTableId(String tableId);
}
