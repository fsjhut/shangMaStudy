package com.javasm.sys.dao;

import com.javasm.commons.base.BaseDao;
import com.javasm.sys.entity.B2cGodown;

public interface B2cGodownDao extends BaseDao<B2cGodown> {
    B2cGodown selectByOrderId(String oderId);
}
