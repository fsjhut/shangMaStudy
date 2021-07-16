package com.javasm.sys.handler;

import com.javasm.commons.base.BaseHandler;
import com.javasm.commons.entity.AxiosResult;
import com.javasm.sys.entity.GiftGoods;
import com.javasm.sys.service.GiftGoodsService;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("giftGoods")
public class GiftGoodsHandler extends BaseHandler {

    @Resource
    private GiftGoodsService giftGoodsService;

    @GetMapping("{id}")
    public AxiosResult selectById(@PathVariable("id") String id) {
        GiftGoods obj = giftGoodsService.selectById(id);
        return suc(obj);
    }

    @GetMapping("list")
    public AxiosResult selectList(GiftGoods obj) {
        startPage();
        List<GiftGoods> list = this.giftGoodsService.selectList(obj);
        System.out.println(list);
        return toTableDatas(list);
    }
    @GetMapping("list1")
    public AxiosResult selectList1(GiftGoods obj) {
        startPage();
        obj.setGiftReviewstatus(0);
        List<GiftGoods> list = this.giftGoodsService.selectList(obj);
        System.out.println(list);
        return toTableDatas(list);
    }

    @PostMapping
    public AxiosResult add(@RequestBody GiftGoods obj) {
        boolean r = this.giftGoodsService.add(obj);
        return result(r);
    }
    @PostMapping("giftReviewstatus")
    public AxiosResult addReviewstatus(@RequestBody GiftGoods obj) {
        obj.setGiftReviewstatus(3);
        boolean r = this.giftGoodsService.updateById(obj);
        return result(r);
    }
//修改后进行提交审核，状态未审核状态
    @PutMapping
    public AxiosResult update(@RequestBody GiftGoods obj) {
        obj.setGiftReviewstatus(1);
        boolean r = this.giftGoodsService.updateById(obj);
        return result(r);
    }

    @DeleteMapping("delete/{ids}")
    public AxiosResult delById(@PathVariable("ids") String ids) {
        String[] split = ids.split(",");
        boolean r = this.giftGoodsService.delByIds(Arrays.asList(split));
        return result(r);
    }

    @GetMapping("giftBrand")
    public  List<GiftGoods> selectBrand(@Param("giftBrand") String giftBrand){
        List<GiftGoods> list = giftGoodsService.selectBrand(giftBrand);
       return list;

    }
    @GetMapping("giftColor")
    public  List<GiftGoods> selectColor(@Param("giftColor") String giftColor){
        List<GiftGoods> list = giftGoodsService.selectColor(giftColor);
        return list;

    }
    @GetMapping("giftType")
    public List<GiftGoods>selectType(@Param("giftType") String giftType){
        List<GiftGoods>list=giftGoodsService.selectType(giftType);
        System.out.println(list);
        return list;

    }
    @GetMapping("giftReviewstatus")
    public List<GiftGoods>selectReviewstatus(@Param("giftReviewstatus")Integer giftReviewstatus){
        List<GiftGoods> list = giftGoodsService.selectReviewstatus(giftReviewstatus);
        List<GiftGoods> list2 = new ArrayList<>();
        for (GiftGoods giftGoods : list) {

            if (giftGoods.getGiftReviewstatus() == 0) {
                giftGoods.setDesc("已审核");
                list2.add(giftGoods);
            }
            if (giftGoods.getGiftReviewstatus() == 1) {
                giftGoods.setDesc("未审核");
                list2.add(giftGoods);
            }
            if (giftGoods.getGiftReviewstatus() == 2) {
                giftGoods.setDesc("审核未通过");
                list2.add(giftGoods);
            }
        }
        return list2;

    }
@GetMapping("colors")
public List<GiftGoods> selectclors(GiftGoods giftGoods) {
    giftGoods.setGiftReviewstatus(0);
    List<GiftGoods> selectclors = giftGoodsService.selectclors(giftGoods);
    if(selectclors.size()>0)  return selectclors;
    return null;
}
   @GetMapping("brand")
    public List<GiftGoods> selectBrand1(String obj) {
        List<GiftGoods> giftGoods = giftGoodsService.selectBrand1(obj);
        return giftGoods;
    }

  @GetMapping("type")

    public List<GiftGoods> selectType1(String obj) {
        List<GiftGoods> giftGoods = giftGoodsService.selectType1(obj);
        return giftGoods;
    }

}
