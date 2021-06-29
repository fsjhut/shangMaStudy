package com.javasm.dao;

import com.javasm.entity.Special;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;


public interface SpecialDao extends BaseDao<Special> {
    int batchAddObjs(List<HashMap<String,Object>> mapList);
}
