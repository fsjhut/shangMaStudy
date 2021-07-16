package com.javasm.sys.service;

import com.javasm.sys.entity.CustomerComplaintForm;

import java.util.List;
import java.util.Map;

import com.javasm.commons.base.BaseService;
import com.javasm.sys.entity.GoodsPriceAdjustment;

public interface CustomerComplaintFormService extends BaseService<CustomerComplaintForm> {


    Map<String,Object> selectByCustomerForm(String oderId);

    Integer adds(CustomerComplaintForm obj);

    CustomerComplaintForm selectByCid(String cid);

    List<Map<String,Object>> selectComplaintFormList(CustomerComplaintForm obj);

    Map<String, Object> selectVerifyById(String id);

    Map<String, Object> selectVerifyFormList(CustomerComplaintForm obj);
}
