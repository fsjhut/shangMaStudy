package com.javasm.goods.service;

import com.javasm.goods.entity.Goods;

import java.util.List;

/**
 * @author SunHang
 * @className: GoodsService
 * @description:
 * @createTime 2021/6/16 19:11
 */
public interface GoodsService {
    int addGoods(Goods t);
    // 批量添加对象
    int batchAddGoods(Goods[] ts);
    // 根据id删除单个对象
    int delGoods(int id);
    // 根据id批量删除
    // 更新对象
    int updateGoods(Goods t);
    // 根据id查询对象
    Goods selectGoodsById(int id);
    // 查询所有的对象
    List<Goods> selectGoodsList();
}
