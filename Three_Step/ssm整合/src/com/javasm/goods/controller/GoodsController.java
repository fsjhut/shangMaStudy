package com.javasm.goods.controller;

import com.javasm.goods.entity.Goods;
import com.javasm.goods.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @className: GoodsController
 * @description:   
 * @author SunHang
 * @createTime 2021/6/16 19:24
 */
@Controller
@RequestMapping("/goods")

public class GoodsController {

    @Autowired
    private GoodsService goodsService;
    @RequestMapping("/selectAll")
    public String selectAll(Model model){
        System.out.println("表现层查询所有的商品：");
        // 如果可以在这里成功调用业务层的方法，则代表整合成功
        List<Goods> goods = goodsService.selectGoodsList();
        model.addAttribute("list",goods);
        System.out.println("------控制层的输出：-------------");
        System.out.println(goods);
        return "list";
    }
}
