package com.javasm.sys.service;

import java.util.List;
import java.util.Map;

import com.javasm.commons.base.BaseService;
import com.javasm.sys.entity.B2cGodown;

public interface B2cGodownService extends BaseService<B2cGodown> {

    Map<String,Object> selectOrderDetailById(String oderId);

    boolean outputWord(String id);

    boolean outputRar(List<String> orderIdsStr);
}
