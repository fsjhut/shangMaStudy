package com.javasm.sys.handler;

import com.javasm.commons.cache.RedisService;
import com.javasm.sys.entity.Gift;
import com.javasm.sys.entity.GiftGoods;
import com.javasm.sys.entity.GoodsManager;
import com.javasm.sys.service.GiftGoodsService;
import com.javasm.sys.service.GiftService;
import com.javasm.sys.service.GoodsManagerService;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import com.javasm.commons.base.BaseHandler;
import com.javasm.commons.entity.AxiosResult;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("gift")
public class GiftHandler extends BaseHandler {
    @Resource
    private RedisService redisService;
    @Resource
    private GiftService giftService;
    @Resource
    private GiftGoodsService giftGoodsService;
    @Resource
    private GoodsManagerService goodsManagerService;

    @GetMapping("{id}")
    public AxiosResult selectById(@PathVariable("id") String id) {
        Gift obj = this.giftService.selectById(id);
        return suc(obj);
    }

    @GetMapping("list")
    public AxiosResult selectList(Gift obj) {
        startPage();
        List<Gift> list = this.giftService.selectList(obj);
        return toTableDatas(list);
    }

    @PostMapping
    //直接添加赠品
    public AxiosResult add(@RequestBody Gift obj) {
        boolean r = this.giftService.add(obj);
        return result(r);
    }
    @PostMapping("add/giftReviewstatus")
    //添加赠品草稿
    public AxiosResult addGiftReviewstatus(@RequestBody Gift gift) {
        gift.setGiftReviewstatus(3);
        boolean r = this.giftService.add(gift);
        return result(r);
    }

    @PostMapping("add/goodsLevel")
    //通过二类商品转赠品
    public  Gift addByGoods(@RequestBody GoodsManager goodsManager,@Param("giftInventory") Integer giftInventory) {
        goodsManager.setGoodsLevel(2);

        List<GoodsManager> goodsManagers = goodsManagerService.selectList(goodsManager);
        System.out.println(goodsManagers);
        Gift gift = new Gift();
        gift.setGiftInventory(giftInventory);
        if(goodsManagers.size()>0){
            for (GoodsManager manager : goodsManagers) {
                gift.setGiftName(manager.getGoodsName());
                gift.setGiftType(manager.getGoodsType());
                gift.setGiftModel(manager.getGoodsModel());
                gift.setGiftPrice(manager.getMallRmb());
                gift.setGiftCost(manager.getProcurementRmb());
                gift.setGiftColor(manager.getGoodsColor());
                gift.setGiftBrand(manager.getGoodsBrand());
                giftService.add(gift);
                return gift ;
            }
        }
//        giftService.add(gift);
       return null ;
    }
    @PutMapping
    public AxiosResult update(@RequestBody Gift obj) {
        boolean r = this.giftService.updateById(obj);
        return result(r);
    }

    @DeleteMapping("{ids}")
    public AxiosResult delById(@PathVariable("ids") String ids) {
        String[] split = ids.split(",");
        boolean r = this.giftService.delByIds(Arrays.asList(split));
        return result(r);
    }


}
