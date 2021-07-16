package com.javasm.sys.handler;

import com.javasm.commons.annotation.LoggerInfo;
import com.javasm.commons.base.BaseHandler;
import com.javasm.commons.cache.RedisService;
import com.javasm.commons.entity.AxiosResult;
import com.javasm.sys.entity.Gift;
import com.javasm.sys.entity.GoodsManager;
import com.javasm.sys.service.GiftGoodsService;
import com.javasm.sys.service.GiftService;
import com.javasm.sys.service.GoodsManagerService;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
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
        System.out.println(list.size());
        return toTableDatas(list);
    }
    @LoggerInfo(operModul = "商品与赠品管理-赠品管理-赠品管理", operType = "添加", operDesc = "直接添加为赠品")
    @PostMapping("add/addGift")
    //直接添加赠品
    public AxiosResult add(@RequestBody Gift obj) {
obj.setGiftReviewstatus(0);
        boolean r = this.giftService.add(obj);
        return result(r);
    }
    //添加赠品草稿
    @LoggerInfo(operModul = "商品与赠品管理-赠品管理-赠品管理", operType = "添加", operDesc = "添加赠品草稿")
    @PostMapping("add/giftReviewstatus")
    public AxiosResult addGiftReviewstatus(@RequestBody Gift gift) {
        gift.setGiftReviewstatus(3);
        boolean r = this.giftService.add(gift);
        return result(r);
    }

    @LoggerInfo(operModul = "商品与赠品管理-赠品管理-赠品管理", operType = "添加", operDesc = "通过二类商品转赠品")
    @PostMapping("add/goodsLevel")
    //通过二类商品转赠品
    public  Gift addByGoods(@RequestBody GoodsManager goodsManager,@Param("giftInventory") Integer giftInventory) {
        startPage();
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
    @LoggerInfo(operModul = "商品与赠品管理-赠品管理-赠品管理", operType = "修改", operDesc = "修改赠品")
    @PutMapping("update")
    public AxiosResult update(@RequestBody Gift obj) {
        obj.setGiftReviewstatus(0);
        boolean r = this.giftService.updateById(obj);
        return result(r);
    }
    @LoggerInfo(operModul = "商品与赠品管理-赠品管理-赠品管理", operType = "删除", operDesc = "删除赠品")
    @PutMapping ("update1")
    public AxiosResult update1(@RequestBody Gift obj) {
        obj.setGiftReviewstatus(3);
        boolean r = this.giftService.updateById(obj);
        return result(r);

    }
    @GetMapping("giftBrand")
    public  List<Gift> selectBrand(@Param("giftBrand") String giftBrand){
        List<Gift> list = giftService.selectBrand(giftBrand);
        if(list.size()>0) return list;
        return null;
    }
    @GetMapping("giftColor")
    public  List<Gift> selectColor(@Param("giftColor") String giftColor){
        List<Gift> list = giftService.selectColor(giftColor);
        if(list.size()>0) return list;
        return null;
    }
    @GetMapping("giftType")
    public List<Gift>selectType(@Param("giftType") String giftType){
//        Gift gift = new Gift();
//        gift.setGiftType(giftType);
        List<Gift>list=giftService.selectType(giftType);
        System.out.println(list);
        if(list.size()>0)return list;
        return null;
    }



}
