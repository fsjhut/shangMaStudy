package com.javasm.sys.dao;

import com.javasm.sys.entity.PromoteProduct;
import org.apache.ibatis.annotations.Param;

import java.util.List;

import com.javasm.commons.base.BaseDao;

public interface PromoteProductDao extends BaseDao<PromoteProduct> {

    int batchAddObj(List<PromoteProduct> mapList);

    int delByPromoteId(int pid);
    List<PromoteProduct> selectByPromote(Integer pid);
}
