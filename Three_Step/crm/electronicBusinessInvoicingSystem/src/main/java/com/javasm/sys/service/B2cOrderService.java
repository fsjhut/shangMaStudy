package com.javasm.sys.service;

import com.javasm.sys.entity.B2cOrder;

import java.util.List;
import java.util.Map;

import com.javasm.commons.base.BaseService;

public interface B2cOrderService extends BaseService<B2cOrder> {


    Map<String, Object> selectOrderDetailById(String oderId);
    /**
     * excl导入
     * @param list
     * @return
     */
   int insertB2C(List<B2cOrder> list);

}
