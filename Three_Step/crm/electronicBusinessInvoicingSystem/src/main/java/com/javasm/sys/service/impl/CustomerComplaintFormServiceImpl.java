package com.javasm.sys.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.javasm.sys.entity.CustomerComplaintForm;
import com.javasm.sys.dao.CustomerComplaintFormDao;
import com.javasm.sys.service.B2cGodownService;
import com.javasm.sys.service.CustomerComplaintFormService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.javasm.commons.base.BaseServiceImpl;

@Service("customerComplaintFormService")
public class CustomerComplaintFormServiceImpl extends BaseServiceImpl<CustomerComplaintFormDao, CustomerComplaintForm> implements CustomerComplaintFormService {

    @Resource
    B2cGodownService b2cGodownService;
    @Override
    public Map<String, Object> selectByCustomerForm(String oderId) {
        CustomerComplaintForm customerComplaintForm = dao.selectByCid(oderId);
        Integer orderNumber = customerComplaintForm.getOrderNumber();
        Map<String, Object> map = b2cGodownService.selectOrderDetailById(orderNumber.toString());
        map.put("customerComplaintData",customerComplaintForm);
        return map;
    }

    @Override
    public Integer adds(CustomerComplaintForm obj) {
        int rows = dao.add(obj);
        Integer cid = obj.getCid();
        return cid;
    }

    @Override
    public CustomerComplaintForm selectByCid(String cid) {

        CustomerComplaintForm complaintForm = dao.selectByCid(cid);
        return complaintForm;
    }


    @Override
    public List<Map<String, Object>> selectComplaintFormList(CustomerComplaintForm obj) {
        List<CustomerComplaintForm> list = dao.selectComplaintFormList(obj);
        List<Map<String,Object>> returnList=new ArrayList<>();
        Map<String, Object> map=null;
        for (CustomerComplaintForm complaintForm : list) {
            Integer orderNumber = complaintForm.getOrderNumber();
            if (orderNumber!=null) {
                map= b2cGodownService.selectOrderDetailById(orderNumber.toString());
            }
            map.put("customerComplaintData",complaintForm);
            returnList.add(map);
        }
        return returnList;
    }

    @Override
    public Map<String, Object> selectVerifyById(String id) {
        CustomerComplaintForm complaintForm = dao.selectVerifyById(id);
        //CustomerComplaintForm complaintForm1 = dao.selectByCid(id);
       // Map<String, Object> stringObjectMap = new HashMap<>();
        //stringObjectMap.put("ver",JSONArray.toJSON(complaintForm.getVer()));
        Map<String, Object> map=new HashMap<>();
        map.put("complaintForm",complaintForm);
        return map;
    }

    @Override
    public Map<String, Object> selectVerifyFormList(CustomerComplaintForm obj) {
        List<CustomerComplaintForm> complaintForms = dao.selectVerifyFromList(obj);
        Map<String, Object> map=new HashMap<>();
        map.put("complaintForm",complaintForms);

        return map;
    }


}
