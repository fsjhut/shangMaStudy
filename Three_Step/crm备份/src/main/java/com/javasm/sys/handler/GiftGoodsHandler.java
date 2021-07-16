package com.javasm.sys.handler;

import com.javasm.sys.entity.GiftGoods;
import com.javasm.sys.service.GiftGoodsService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import com.javasm.commons.base.BaseHandler;
import com.javasm.commons.entity.AxiosResult;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("giftGoods")
public class GiftGoodsHandler extends BaseHandler {

    @Resource
    private GiftGoodsService giftGoodsService;

    @GetMapping("{id}")
    public AxiosResult selectById(@PathVariable("id") String id) {
        GiftGoods obj = this.giftGoodsService.selectById(id);
        return suc(obj);
    }

    @GetMapping("list")
    public AxiosResult selectList(GiftGoods obj) {
        startPage();
        List<GiftGoods> list = this.giftGoodsService.selectList(obj);
        return toTableDatas(list);
    }

    @PostMapping
    public AxiosResult add(@RequestBody GiftGoods obj) {
        boolean r = this.giftGoodsService.add(obj);
        return result(r);
    }

    @PutMapping
    public AxiosResult update(@RequestBody GiftGoods obj) {
        boolean r = this.giftGoodsService.updateById(obj);
        return result(r);
    }

    @DeleteMapping("{ids}")
    public AxiosResult delById(@PathVariable("ids") String ids) {
        String[] split = ids.split(",");
        boolean r = this.giftGoodsService.delByIds(Arrays.asList(split));
        return result(r);
    }


}
