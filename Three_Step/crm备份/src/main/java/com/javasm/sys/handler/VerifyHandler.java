package com.javasm.sys.handler;

import com.javasm.commons.utils.CurrentLoginUser;
import com.javasm.commons.utils.JsonXMLUtils;
import com.javasm.sys.entity.PromoteProduct;
import com.javasm.sys.entity.PromoteSale;
import com.javasm.sys.entity.Verify;
import com.javasm.sys.service.VerifyService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import com.javasm.commons.base.BaseHandler;
import com.javasm.commons.entity.AxiosResult;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("verify")
public class VerifyHandler extends BaseHandler {

    @Resource
    private VerifyService verifyService;

    // 根据tableID进行查询
    @GetMapping("{id}")
    public AxiosResult selectById(@PathVariable("id") String id) {
        Map<String, Object> stringObjectMap = this.verifyService.selectDetailByTableId(id);
        return suc(stringObjectMap);
    }

    @GetMapping("list")
    public AxiosResult selectList(Verify obj) {
        startPage();
        obj.setVerifyPerson(CurrentLoginUser.getUname());
        List<PromoteSale> promoteSales = this.verifyService.selectAllList(obj);
        return toTableDatas(promoteSales);
    }


    @PostMapping("updatesubmit")
    public AxiosResult updateSubmit(@RequestBody Map<String,Object> params) {
        PromoteSale promoteSale = JsonXMLUtils.map2obj((Map<String, Object>) params.
                get("PromoteSale"), PromoteSale.class);
//        System.out.println(promoteSale);
        List<PromoteProduct> productList = null;
        try {
            productList = JsonXMLUtils.listStr2listObj((ArrayList<Object>) params.
                    get("PromoteProduct"), PromoteProduct.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        boolean add = verifyService.updateVerify(promoteSale, productList);
        return result(add);
    }
    @PostMapping("submit")
    public AxiosResult generate(@RequestBody Map<String,Object> params) {
        PromoteSale promoteSale = JsonXMLUtils.map2obj((Map<String, Object>) params.
                get("PromoteSale"), PromoteSale.class);
//        System.out.println(promoteSale);
        List<PromoteProduct> productList = null;
        try {
            Object promoteProduct = params.get("PromoteProduct");
            if(promoteProduct==null || "\"\"".equals(promoteProduct.toString())){
//                return result(false);
                productList = null;
            }else {
                productList = JsonXMLUtils.listStr2listObj((ArrayList<Object>) params.
                        get("PromoteProduct"), PromoteProduct.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        boolean add = verifyService.addVerify(promoteSale, productList);
        return result(add);
    }

    @PostMapping("add")
    public AxiosResult add(@RequestBody Verify obj) {
        boolean r = verifyService.add(obj);
        return result(r);
    }

    @PutMapping
    public AxiosResult update(@RequestBody Verify obj) {
        boolean r = this.verifyService.updateById(obj);
        return result(r);
    }

//    @DeleteMapping("{ids}")
//    public AxiosResult delById(@PathVariable("ids") String ids) {
//        String[] split = ids.split(",");
//        boolean r = this.verifyService.delByIds(Arrays.asList(split));
//        return result(r);
//    }
}
