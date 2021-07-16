package com.javasm.sys.handler;

import com.javasm.sys.entity.CrmFactoryGoods;
import com.javasm.sys.service.CrmFactoryGoodsService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import com.javasm.commons.base.BaseHandler;
import com.javasm.commons.entity.AxiosResult;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("crmFactoryGoods")
public class CrmFactoryGoodsHandler extends BaseHandler {

    @Resource
    private CrmFactoryGoodsService crmFactoryGoodsService;

    @GetMapping("{id}")
    public AxiosResult selectById(@PathVariable("id") String id) {
        CrmFactoryGoods obj = this.crmFactoryGoodsService.selectById(id);
        return suc(obj);
    }

    @GetMapping("list")
    public AxiosResult selectAll(CrmFactoryGoods obj) {
        List<CrmFactoryGoods> list = this.crmFactoryGoodsService.selectList(obj);
        return suc(list);
    }

    @PostMapping
    public AxiosResult add(@RequestBody CrmFactoryGoods obj) {
        boolean r = this.crmFactoryGoodsService.add(obj);
        return result(r);
    }

    @PutMapping
    public AxiosResult update(@RequestBody CrmFactoryGoods obj) {
        boolean r = this.crmFactoryGoodsService.updateById(obj);
        return result(r);
    }

    @DeleteMapping("{ids}")
    public AxiosResult delById(@PathVariable("ids") String ids) {
        String[] split = ids.split(",");
        boolean r = this.crmFactoryGoodsService.delByIds(Arrays.asList(split));
        return result(r);
    }


}
