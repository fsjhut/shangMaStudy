package com.javasm.sys.handler;

import com.javasm.sys.entity.OutGoods;
import com.javasm.sys.service.OutGoodsService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import com.javasm.commons.base.BaseHandler;
import com.javasm.commons.entity.AxiosResult;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("outGoods")
public class OutGoodsHandler extends BaseHandler {

    @Resource
    private OutGoodsService outGoodsService;

    @GetMapping("{id}")
    public AxiosResult selectById(@PathVariable("id") String id) {
        OutGoods obj = this.outGoodsService.selectById(id);
        return suc(obj);
    }

    @GetMapping("list")
    public AxiosResult selectList(OutGoods obj) {
        startPage();
        List<OutGoods> list = this.outGoodsService.selectList(obj);
        return toTableDatas(list);
    }

    @PostMapping
    public AxiosResult add(@RequestBody OutGoods obj) {
        boolean r = this.outGoodsService.add(obj);
        return result(r);
    }

    @PutMapping
    public AxiosResult update(@RequestBody OutGoods obj) {
        boolean r = this.outGoodsService.updateById(obj);
        return result(r);
    }

    @DeleteMapping("{ids}")
    public AxiosResult delById(@PathVariable("ids") String ids) {
        String[] split = ids.split(",");
        boolean r = this.outGoodsService.delByIds(Arrays.asList(split));
        return result(r);
    }


}
