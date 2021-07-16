package com.javasm.sys.handler;

import com.javasm.sys.entity.GoodsManager;
import com.javasm.sys.service.GoodsManagerService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import com.javasm.commons.base.BaseHandler;
import com.javasm.commons.entity.AxiosResult;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("goodsManager")
public class GoodsManagerHandler extends BaseHandler {

    @Resource
    private GoodsManagerService goodsManagerService;

    @GetMapping("{id}")
    public AxiosResult selectById(@PathVariable("id") String id) {
        GoodsManager obj = this.goodsManagerService.selectById(id);
        return suc(obj);
    }

    @GetMapping("list")
    public AxiosResult selectList(GoodsManager obj) {
        startPage();
        List<GoodsManager> list = this.goodsManagerService.selectList(obj);
        return toTableDatas(list);
    }

    //  老王添加
    @GetMapping("goodListNoIncludePriceAdjust")
    public AxiosResult selectGoodsNoPriceAdjuse(GoodsManager obj) {
        startPage();
        List<GoodsManager> list = this.goodsManagerService.selectGoodListNotIncludePriceAdjust(obj);
        return toTableDatas(list);
    }
    @GetMapping("getType/{type}")
    public AxiosResult getType(@PathVariable("type") String type) {
        List<String> strings = this.goodsManagerService.selectType(type);
        return toTableDatas(strings);
    }

    @PostMapping("add")
    public AxiosResult add(@RequestBody GoodsManager obj) {
        boolean r = this.goodsManagerService.add(obj);
        return result(r);
    }
    //创建一类二类商品
    @PostMapping("add/{goodsLevel}")
    public AxiosResult add(@RequestBody GoodsManager obj,@PathVariable("goodsLevel") Integer goodsLevel) {

        obj.setGoodsLevel(goodsLevel);
        boolean r = this.goodsManagerService.setGoodsLevel(obj,goodsLevel);
        return result(r);
    }






    @PutMapping
    public AxiosResult update(@RequestBody GoodsManager obj) {
        boolean r = this.goodsManagerService.updateById(obj);
        return result(r);
    }

    @DeleteMapping("{ids}")
    public AxiosResult delById(@PathVariable("ids") String ids) {
        String[] split = ids.split(",");
        boolean r = this.goodsManagerService.delByIds(Arrays.asList(split));
        return result(r);
    }


}
