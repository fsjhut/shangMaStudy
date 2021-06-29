package com.javasm.dao;

import com.javasm.entity.Schoolplan;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;


public interface SchoolplanDao extends BaseDao<Schoolplan> {
    int addObj(HashMap<String,Object> map);
    int batchAddObjs(List<HashMap<String,Object>> mapList);
}
