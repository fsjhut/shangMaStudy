package com.javasm.sys.handler;

import com.javasm.commons.utils.CurrentLoginUser;
import com.javasm.commons.utils.JsonXMLUtils;
import com.javasm.sys.entity.PromoteProduct;
import com.javasm.sys.entity.PromoteSale;
import com.javasm.sys.service.PromoteSaleService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import com.javasm.commons.base.BaseHandler;
import com.javasm.commons.entity.AxiosResult;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("promoteSale")
public class PromoteSaleHandler extends BaseHandler {

    @Resource
    private PromoteSaleService promoteSaleService;

    @GetMapping("{id}")
    public AxiosResult selectById(@PathVariable("id") String id) {
        Map<String, Object> stringObjectMap = this.promoteSaleService.selectDetailById(id);
        return suc(stringObjectMap);
    }

    @GetMapping("list")
    public AxiosResult selectList(PromoteSale obj) {
        startPage();
        obj.setCreateBy(CurrentLoginUser.getUname());
        List<PromoteSale> list = this.promoteSaleService.selectList(obj);
        return toTableDatas(list);
    }

    @PostMapping
    public AxiosResult add(@RequestBody Map<String,Object> params) {
        PromoteSale promoteSale = JsonXMLUtils.map2obj((Map<String, Object>) params.
                get("PromoteSale"), PromoteSale.class);
        List<PromoteProduct> productList = null;
        try {
            Object promoteProduct = params.get("PromoteProduct");
            if(promoteProduct==null || "\"\"".equals(promoteProduct.toString())){
                productList = null;
            }else{
                productList = JsonXMLUtils.listStr2listObj((ArrayList<Object>) params.
                        get("PromoteProduct"), PromoteProduct.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        boolean add = promoteSaleService.add(promoteSale, productList);
        return result(add);
    }
//    @PostMapping
//    public AxiosResult savePromote(@RequestBody Map<String,Object> params) {
//        PromoteSale promoteSale = JsonXMLUtils.map2obj((Map<String, Object>) params.
//                get("PromoteSale"), PromoteSale.class);
//        List<PromoteProduct> productList = JsonXMLUtils.listStr2listObj((String) params.
//                get("PromoteProduct"), PromoteProduct.class);
//        boolean add = promoteSaleService.add(promoteSale, productList);
//        return result(add);
//    }

    @PutMapping
    public AxiosResult update(@RequestBody Map<String,Object> params) {
        PromoteSale promoteSale = JsonXMLUtils.map2obj((Map<String, Object>) params.
                get("PromoteSale"), PromoteSale.class);
        System.out.println(promoteSale);
        List<PromoteProduct> productList = null;
//        Object promoteProduct = params.get("PromoteProduct");
//        System.out.println(promoteProduct.toString());
        try {
            productList = JsonXMLUtils.listStr2listObj((ArrayList<Object>) params.
                    get("PromoteProduct"), PromoteProduct.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(productList);
        boolean r = this.promoteSaleService.updateById(promoteSale,productList);
        return result(r);
    }

    @DeleteMapping("{id}")
    public AxiosResult delById(@PathVariable("id") String id) {
        boolean r = this.promoteSaleService.delById(id);
        return result(r);
    }
}
