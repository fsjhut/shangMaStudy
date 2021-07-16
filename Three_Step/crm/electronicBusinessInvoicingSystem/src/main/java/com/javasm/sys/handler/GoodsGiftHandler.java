package com.javasm.sys.handler;

import com.javasm.commons.annotation.LoggerInfo;
import com.javasm.commons.base.BaseHandler;
import com.javasm.commons.entity.AxiosResult;
import com.javasm.sys.entity.GoodsGift;
import com.javasm.sys.service.GoodsGiftService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("goodsGift")
public class GoodsGiftHandler extends BaseHandler {

    @Resource
    private GoodsGiftService goodsGiftService;


    @GetMapping("{id}")
    public AxiosResult selectById(@PathVariable("id") String id) {
        GoodsGift obj = this.goodsGiftService.selectById(id);
        return suc(obj);
    }

    @GetMapping("list")
    public AxiosResult selectList(GoodsGift obj) {
        System.out.println("getGiftReviewstatus==="+obj.getGiftReviewstatus());
        startPage();
        List<GoodsGift> list = this.goodsGiftService.selectList(obj);
        return toTableDatas(list);
    }

    //过滤无效的数据
    @GetMapping("list/invalid")
    public AxiosResult filterInvalidStatus(GoodsGift obj) {
        startPage();
        List<GoodsGift> list = this.goodsGiftService.filterInvalidStatus(obj);
        return toTableDatas(list);
    }

    @PostMapping
    public AxiosResult add(@RequestBody GoodsGift obj) {
        obj.setGiftReviewstatus(0);
        boolean r = this.goodsGiftService.add(obj);
        return result(r);
    }


    //假删除
    @PutMapping
    @LoggerInfo(operModul = "赠品管理-商品转赠品", operType = "删除", operDesc = "删除商品转赠品信息")
    public AxiosResult update(@RequestBody GoodsGift obj) {
        obj.setGiftReviewstatus(3);
        boolean r = this.goodsGiftService.updateById(obj);
        return result(r);
    }



    //审核状态
    @GetMapping("reviewstatus")
    public AxiosResult reviewStatus(GoodsGift obj) {
//        startPage();
        List<GoodsGift> list = this.goodsGiftService.filterReviewStatus(obj);
        return toTableDatas(list);
    }

    //下拉框
    @GetMapping("selectType/{type}")
    public AxiosResult selectType(@PathVariable("type") String type) {
        List<GoodsGift> goodsGifts = goodsGiftService.selectType(type);
        return AxiosResult.suc(goodsGifts);

    }

    //商品转赠品,没使用
    @PutMapping("update")
    public AxiosResult updateGoodsGift(@RequestBody GoodsGift obj) {
        //判断商品库存
        AxiosResult axiosResult = goodsGiftService.judgingPruductInventory(obj);
        return axiosResult;
    }

    //修改，没使用
    @PutMapping("updates/goods")
    public AxiosResult updateGoods(@RequestBody GoodsGift obj) {
        boolean r = this.goodsGiftService.updateById(obj);
        return result(r);
    }

    //没使用
    @DeleteMapping("{ids}")
    public AxiosResult delById(@PathVariable("ids") String ids) {
        String[] split = ids.split(",");
        boolean r = this.goodsGiftService.delByIds(Arrays.asList(split));
        return result(r);
    }





}
