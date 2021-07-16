package com.javasm.sys.handler;

import com.javasm.sys.entity.GoodsManager;
import com.javasm.sys.service.GoodsManagerService;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import com.javasm.commons.base.BaseHandler;
import com.javasm.commons.entity.AxiosResult;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

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
//    @GetMapping("getType/{type}")
//    public AxiosResult getType(@PathVariable("type") String type) {
//        List list = this.goodsManagerService.selectType(type);
//
//        return super.suc(list);
//    }
//
    @GetMapping("getType/{type}")
    public List<GoodsManager> getType(@PathVariable("type")String string){

        List<GoodsManager> list = goodsManagerService.selectType(string);
        return list;
    }


    @PostMapping("add")
    public AxiosResult add(@RequestBody GoodsManager obj) {
        boolean r = this.goodsManagerService.add(obj);
        return result(r);
    }



    //创建一类二类商品(1是一类商品,2是二类商品)
    @PostMapping("add/{goodsLevel}")
    public AxiosResult add(@RequestBody GoodsManager obj,@PathVariable("goodsLevel") Integer goodsLevel) {

        obj.setGoodsLevel(goodsLevel);
        boolean r = this.goodsManagerService.setGoodsLevel(obj,goodsLevel);
        return result(r);
    }

@GetMapping("list/goodsLevel")
public AxiosResult selectLevel(GoodsManager obj){
startPage();
    obj.setGoodsLevel(2);
    List<GoodsManager> list = goodsManagerService.selectList(obj);
    if(list.size()>0) return toTableDatas(list);
    return null;
}

    //批量添加商品
    @PostMapping ("insertGoods")
    public AxiosResult insertGoods(@RequestBody GoodsManager[] goodsManagers) {
        boolean b = this.goodsManagerService.insertGoods(Arrays.asList(goodsManagers));
        return result(b);
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
    @PostMapping("adds")
    public AxiosResult adds(@RequestBody Map map) {




        return null;
    }


}
