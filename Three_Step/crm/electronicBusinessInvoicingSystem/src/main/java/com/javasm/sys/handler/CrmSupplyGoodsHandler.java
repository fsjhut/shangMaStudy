package com.javasm.sys.handler;

import com.javasm.sys.entity.CrmSupplyGoods;
import com.javasm.sys.service.CrmSupplyGoodsService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import com.javasm.commons.base.BaseHandler;
import com.javasm.commons.entity.AxiosResult;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("crmSupplyGoods")
public class CrmSupplyGoodsHandler extends BaseHandler {

    @Resource
    private CrmSupplyGoodsService crmSupplyGoodsService;

    @GetMapping("{id}")
    public AxiosResult selectById(@PathVariable("id") String id) {
        List<CrmSupplyGoods> obj = this.crmSupplyGoodsService.selectByIds(id);
        return suc(obj);
    }

    @GetMapping("list")
    public AxiosResult selectList(CrmSupplyGoods obj) {
        startPage();
        List<CrmSupplyGoods> list = this.crmSupplyGoodsService.selectList(obj);
        return toTableDatas(list);
    }

    @PostMapping
    public AxiosResult add(@RequestBody CrmSupplyGoods obj) {
        boolean r = this.crmSupplyGoodsService.add(obj);
        return result(r);
    }

    @PutMapping
    public AxiosResult update(@RequestBody CrmSupplyGoods obj) {
        boolean r = this.crmSupplyGoodsService.updateById(obj);
        return result(r);
    }

    @DeleteMapping("{ids}")
    public AxiosResult delById(@PathVariable("ids") String ids) {
        String[] split = ids.split(",");
        boolean r = this.crmSupplyGoodsService.delByIds(Arrays.asList(split));
        return result(r);
    }


}
