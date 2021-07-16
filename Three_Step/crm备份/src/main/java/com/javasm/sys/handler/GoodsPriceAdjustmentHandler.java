package com.javasm.sys.handler;

import com.javasm.commons.entity.AxiosResult;
import com.javasm.commons.utils.CurrentLoginUser;
import com.javasm.commons.utils.ServletUtil;
import com.javasm.sys.entity.GoodsManager;
import com.javasm.sys.entity.GoodsPriceAdjustment;
import com.javasm.sys.service.GoodsPriceAdjustmentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import com.javasm.commons.base.BaseHandler;


import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("goodsPriceAdjustment")
public class GoodsPriceAdjustmentHandler extends BaseHandler {

    @Resource
    private GoodsPriceAdjustmentService service;

    @GetMapping("{id}")
    public AxiosResult selectById(@PathVariable("id") String id) {
        GoodsPriceAdjustment obj = service.selectById(id);
        return suc(obj);
    }

    @GetMapping("list")
    public AxiosResult selectList(GoodsPriceAdjustment obj) {
        startPage();
        List<GoodsPriceAdjustment> list = this.service.selectList(obj);
        return toTableDatas(list);
    }


    @PostMapping
    public AxiosResult add(@RequestBody GoodsPriceAdjustment obj) {
        obj.setCreateBy(CurrentLoginUser.getUname());
        boolean r = this.service.add(obj);
        return result(r);
    }

    @PutMapping
    public AxiosResult updateById(@RequestBody GoodsPriceAdjustment obj) {
        boolean r = this.service.updateById(obj);
        return result(r);
    }

    @DeleteMapping("{ids}")
    public AxiosResult delByIds(@PathVariable("ids") String ids) {
        String[] split = ids.split(",");
        boolean r = this.service.delByIds(Arrays.asList(split));
        return result(r);
    }


}
