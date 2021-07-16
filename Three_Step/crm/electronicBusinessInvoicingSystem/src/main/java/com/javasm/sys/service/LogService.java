package com.javasm.sys.service;

import com.javasm.commons.base.BaseService;
import com.javasm.sys.entity.Log;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LogService extends BaseService<Log> {

    List<Log> filterRepeatModule(List<Log> list);

    List<Log> selectByKeyWords(@Param("keyWord") String keyWord);


    List<Log> selectManyTerm(Log log);

    List<Log> filterOperatorcontent(List<Log> list);

    List<Log> filterDeptNames(List<Log> list);
}
