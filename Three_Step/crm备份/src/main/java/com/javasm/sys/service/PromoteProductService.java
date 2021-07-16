package com.javasm.sys.service;

import com.javasm.sys.entity.PromoteProduct;

import java.util.HashMap;
import java.util.List;

import com.javasm.commons.base.BaseService;

public interface PromoteProductService extends BaseService<PromoteProduct> {

    int batchAddObj(List<PromoteProduct> mapList);
    int delByPromoteId(int pid);
    List<PromoteProduct> selectByPromote(Integer pid);
}
