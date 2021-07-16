package com.javasm.sys.handler;

import com.javasm.commons.utils.JsonXMLUtils;
import com.javasm.sys.entity.B2cGodown;
import com.javasm.sys.entity.B2cOrder;
import com.javasm.sys.entity.PromoteProduct;
import com.javasm.sys.entity.PromoteSale;
import com.javasm.sys.service.B2cGodownService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import com.javasm.commons.base.BaseHandler;
import com.javasm.commons.entity.AxiosResult;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("b2cGodown")
public class B2cGodownHandler extends BaseHandler {

    @Resource
    private B2cGodownService b2cGodownService;

//    @GetMapping("{id}")
//    public AxiosResult selectById(@PathVariable("id") String id) {
//        B2cGodown obj = this.b2cGodownService.selectById(id);
//        return suc(obj);
//    }
    @GetMapping("{orderId}")
    public AxiosResult selectOrderDetailById(@PathVariable("orderId") String oderId) {
        Map<String, Object> stringObjectMap = this.b2cGodownService.selectOrderDetailById(oderId);
        return suc(stringObjectMap);
    }

    @GetMapping("outputword/{orderId}")
    public AxiosResult outputWord(@PathVariable("orderId") String orderId){

        if(b2cGodownService.outputWord(orderId)){
            return suc();
        }else{
            return error();
        }
//        String[] split = orderId.split(",");
//        List<String> orderIds = Arrays.asList(split);
//        boolean isFlag = true;
//        for (String id : orderIds) {
//            boolean b = b2cGodownService.outputWord(id);
//            if(!b){
//                isFlag = false;
//            }
//        }
//        if(isFlag){
//            return suc();
//        }else{
//            return error();
//        }
    }
    @GetMapping("outputzip/{orderIds}")
    public AxiosResult outputZip(@PathVariable("orderIds") String orderIds){
        String[] split = orderIds.split(",");
        List<String> orderIdsStr = Arrays.asList(split);
        boolean isFlag = b2cGodownService.outputRar(orderIdsStr);
        if(isFlag){
            return suc();
        }else{
            return error();
        }
    }

    @GetMapping("list")
    public AxiosResult selectList(B2cGodown obj) {
        startPage();
        List<B2cGodown> list = this.b2cGodownService.selectList(obj);
        return toTableDatas(list);
    }

    @PostMapping
    public AxiosResult add(@RequestBody B2cGodown obj) {
        boolean r = this.b2cGodownService.add(obj);
        return result(r);
    }

    @PutMapping
    public AxiosResult update(@RequestBody B2cGodown obj) {
        boolean r = this.b2cGodownService.updateById(obj);
        return result(r);
    }

    @DeleteMapping("{ids}")
    public AxiosResult delById(@PathVariable("ids") String ids) {
        String[] split = ids.split(",");
        boolean r = this.b2cGodownService.delByIds(Arrays.asList(split));
        return result(r);
    }
}
