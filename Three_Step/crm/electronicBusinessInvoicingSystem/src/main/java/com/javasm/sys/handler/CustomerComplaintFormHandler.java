package com.javasm.sys.handler;

import cn.hutool.json.JSON;
import com.alibaba.fastjson.JSONArray;
import com.javasm.sys.dao.CustomerComplaintFormDao;
import com.javasm.sys.entity.CustomerComplaintForm;
import com.javasm.sys.service.CustomerComplaintFormService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import com.javasm.commons.base.BaseHandler;
import com.javasm.commons.entity.AxiosResult;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("customerComplaintForm")
public class CustomerComplaintFormHandler extends BaseHandler {

    @Resource
    private CustomerComplaintFormService customerComplaintFormService;
    @Resource
    private CustomerComplaintFormDao dao;



    @GetMapping("verify/{id}")
    public AxiosResult selectVerifyById(@PathVariable("id") String id) {
        Map<String, Object> map = customerComplaintFormService.selectVerifyById(id);

        return suc(map);
    }
    @GetMapping("verify/list")
    public AxiosResult selectVerifyList(CustomerComplaintForm obj) {
        startPage();
        List<CustomerComplaintForm> list = customerComplaintFormService.selectList(obj);

        return toTableDatas(list);
    }

    @GetMapping("{id}")
    public AxiosResult selectById(@PathVariable("id") String id) {

        Map<String, Object> map = this.customerComplaintFormService.selectByCustomerForm(id);
        return suc(map);
    }

    @GetMapping("customer/{id}")
    public AxiosResult selectCustomerId(@PathVariable("id") String id) {

        CustomerComplaintForm complaintForm = this.customerComplaintFormService.selectByCid(id);
        return suc(complaintForm);
    }



    @GetMapping("verify1/list")
    public AxiosResult selectList11(CustomerComplaintForm obj) {
        startPage();
//        List<CustomerComplaintForm> list = this.customerComplaintFormService.selectList(obj);
        Map<String, Object> map = this.customerComplaintFormService.selectVerifyFormList(obj);

        return suc(map);

    }




    @GetMapping("list")
    public AxiosResult selectList(CustomerComplaintForm obj) {
        startPage();
//        List<CustomerComplaintForm> list = this.customerComplaintFormService.selectList(obj);
        List<Map<String, Object>> list = this.customerComplaintFormService.selectComplaintFormList(obj);

        return toTableDatas(list);

    }

    @GetMapping("customer/list")
    public AxiosResult selectCustomerList(CustomerComplaintForm obj) {
        startPage();
        List<CustomerComplaintForm> list = this.dao.selectComplaintFormList(obj);
//        List<Map<String, Object>> list = this.customerComplaintFormService.selectComplaintFormList(obj);

        return toTableDatas(list);

    }

    @PostMapping
    public AxiosResult add(@RequestBody CustomerComplaintForm obj) {


        boolean r = this.customerComplaintFormService.add(obj);
        return result(r);
    }

    @PutMapping
    public AxiosResult update(@RequestBody CustomerComplaintForm obj) {
        boolean r = this.customerComplaintFormService.updateById(obj);
        return result(r);
    }

    @DeleteMapping("{ids}")
    public AxiosResult delById(@PathVariable("ids") String ids) {
        String[] split = ids.split(",");
        boolean r = this.customerComplaintFormService.delByIds(Arrays.asList(split));
        return result(r);
    }


}
