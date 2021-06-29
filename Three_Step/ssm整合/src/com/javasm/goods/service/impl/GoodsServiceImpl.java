package com.javasm.goods.service.impl;

import com.github.pagehelper.PageHelper;
import com.javasm.goods.dao.GoodsDao;
import com.javasm.goods.entity.Goods;
import com.javasm.goods.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @className: GoodsServiceImpl
 * @description:   
 * @author SunHang
 * @createTime 2021/6/16 19:22
 */
@Service("goodsService")
public class GoodsServiceImpl implements GoodsService {

    @Resource
    private GoodsDao goodsDao;
    @Override
    public int addGoods(Goods t) {
        System.out.println("业务层：保存商品信息");
//        PageHelper.startPage()
        return 0;
    }

    @Override
    public int batchAddGoods(Goods[] ts) {
        return 0;
    }

    @Override
    public int delGoods(int id) {
        return 0;
    }

    @Override
    public int updateGoods(Goods t) {
        return 0;
    }

    @Override
    public Goods selectGoodsById(int id) {
        return null;
    }

    @Override
    public List<Goods> selectGoodsList() {
        System.out.println("业务层，查询所有的商品：");
        return goodsDao.selectList();
    }
}
