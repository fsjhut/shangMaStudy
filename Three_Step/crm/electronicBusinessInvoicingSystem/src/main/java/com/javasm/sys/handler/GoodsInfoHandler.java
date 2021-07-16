package com.javasm.sys.handler;

import com.javasm.sys.entity.GoodsInfo;
import com.javasm.sys.service.GoodsInfoService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import com.javasm.commons.base.BaseHandler;
import com.javasm.commons.entity.AxiosResult;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("goodsInfo")
public class GoodsInfoHandler extends BaseHandler {

    @Resource
    private GoodsInfoService goodsInfoService;

    @GetMapping("{id}")
    public AxiosResult selectById(@PathVariable("id") String id) {
        GoodsInfo obj = this.goodsInfoService.selectById(id);
        return suc(obj);
    }

    @GetMapping("list")
    public AxiosResult selectList(GoodsInfo obj) {
        startPage();
        List<GoodsInfo> list = this.goodsInfoService.selectList(obj);
        return toTableDatas(list);
    }
    @GetMapping("selectExchangeGoods")
    public AxiosResult selectExchangeGoods() {
//        startPage();
        List<GoodsInfo> list = this.goodsInfoService.selectExchangeGoods();
        return toTableDatas(list);
    }

    @PostMapping
    public AxiosResult add(@RequestBody GoodsInfo obj) {
        boolean r = this.goodsInfoService.add(obj);
        return result(r);
    }

    @PutMapping
    public AxiosResult update(@RequestBody GoodsInfo obj) {
        boolean r = this.goodsInfoService.updateById(obj);
        return result(r);
    }

    @DeleteMapping("{ids}")
    public AxiosResult delById(@PathVariable("ids") String ids) {
        String[] split = ids.split(",");
        boolean r = this.goodsInfoService.delByIds(Arrays.asList(split));
        return result(r);
    }


}
