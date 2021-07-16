package com.javasm.sys.dao;

import com.javasm.commons.base.BaseDao;
import com.javasm.sys.entity.Log;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LogDao extends BaseDao<Log> {

    List<Log> selectByKeyWords(@Param("keyWord") String keyWord);

    List<Log> selectManyTerm(Log log);

}

