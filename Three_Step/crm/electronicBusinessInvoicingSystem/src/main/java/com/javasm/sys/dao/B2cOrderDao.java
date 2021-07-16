package com.javasm.sys.dao;

import com.javasm.sys.entity.B2cOrder;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

import com.javasm.commons.base.BaseDao;

public interface B2cOrderDao extends BaseDao<B2cOrder> {

    B2cOrder selectOrderDetailById(String oderId);

    /**
     * excl导入
     * @param list
     * @return
     */
   int insertB2C(List<B2cOrder> list);

}
