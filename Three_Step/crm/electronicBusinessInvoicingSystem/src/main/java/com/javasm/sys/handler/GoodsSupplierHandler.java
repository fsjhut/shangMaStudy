package com.javasm.sys.handler;

import com.javasm.sys.entity.GoodsSupplier;
import com.javasm.sys.service.GoodsSupplierService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import com.javasm.commons.base.BaseHandler;
import com.javasm.commons.entity.AxiosResult;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("goodsSupplier")
public class GoodsSupplierHandler extends BaseHandler {

    @Resource
    private GoodsSupplierService goodsSupplierService;

    @GetMapping("{id}")
    public AxiosResult selectById(@PathVariable("id") String id) {
        GoodsSupplier obj = this.goodsSupplierService.selectById(id);
        return suc(obj);
    }

    @GetMapping("list")
    public AxiosResult selectList(GoodsSupplier obj) {
        startPage();
        List<GoodsSupplier> list = this.goodsSupplierService.selectList(obj);
        return toTableDatas(list);
    }

    @PostMapping
    public AxiosResult add(@RequestBody GoodsSupplier obj) {
        boolean r = this.goodsSupplierService.add(obj);
        return result(r);
    }

    @PutMapping
    public AxiosResult update(@RequestBody GoodsSupplier obj) {
        boolean r = this.goodsSupplierService.updateById(obj);
        return result(r);
    }

    @DeleteMapping("{ids}")
    public AxiosResult delById(@PathVariable("ids") String ids) {
        String[] split = ids.split(",");
        boolean r = this.goodsSupplierService.delByIds(Arrays.asList(split));
        return result(r);
    }


}
