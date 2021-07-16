package com.javasm.sys.dao;

import com.javasm.sys.entity.CustomerComplaintForm;
import com.javasm.sys.entity.GoodsInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

import com.javasm.commons.base.BaseDao;

public interface CustomerComplaintFormDao extends BaseDao<CustomerComplaintForm> {

    CustomerComplaintForm selectByCid(String cid);
    List<CustomerComplaintForm> selectComplaintFormList(CustomerComplaintForm obj);

    CustomerComplaintForm selectVerifyById(String cid);
    List<CustomerComplaintForm> selectVerifyFromList(CustomerComplaintForm obj);

}

