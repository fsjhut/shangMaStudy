package com.javasm.sys.service.impl;

import com.javasm.commons.entity.S;
import com.javasm.commons.exception.MvcException;
import com.javasm.commons.utils.CurrentLoginUser;
import com.javasm.commons.utils.DateUtil;
import com.javasm.sys.entity.PromoteProduct;
import com.javasm.sys.entity.PromoteSale;
import com.javasm.sys.dao.PromoteSaleDao;
import com.javasm.sys.service.PromoteProductService;
import com.javasm.sys.service.PromoteSaleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.javasm.commons.base.BaseServiceImpl;
import org.springframework.transaction.annotation.Transactional;


@Service("promoteSaleService")
public class PromoteSaleServiceImpl extends BaseServiceImpl<PromoteSaleDao, PromoteSale> implements PromoteSaleService {

    @Resource
    private PromoteProductService productService;

    @Override
    public Map<String,Object> selectDetailById(String id) {
//        return dao.selectById(id);
        Map<String,Object> map = new HashMap<>();
        PromoteSale promoteSale = dao.selectById(id);
        List<PromoteProduct> productList = productService.selectByPromote(Integer.parseInt(id));
        map.put("PromoteSale",promoteSale);
        map.put("PromoteProduct",productList);
        return map;
    }

//    @Override
//    public List<PromoteSale> selectSimpleList(PromoteSale promoteSale) {
//        return dao.selectList(promoteSale);
//    }

    // 接受前端传递的数据后，获取自增id，再将其插入到另一个表中。
    // 需要将id传给前端，
    @Override
    @Transactional
    public boolean add(PromoteSale promoteSale, List<PromoteProduct> products) {
        try {
            promoteSale.setPromoteStatus(0);
            int rows = dao.add(promoteSale);
            Integer promoteId = promoteSale.getPromoteId();
            if(products==null){
                return rows==1;
            }
            products.forEach(product -> product.setPromoteId(promoteId));
            int i = productService.batchAddObj(products);
            if (rows != 1 || i != products.size()) {
                throw new MvcException(S.GENERATE_ERROR);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
    @Transactional
    @Override
    public Integer submit(PromoteSale promoteSale, List<PromoteProduct> products) {
        Integer promoteId = null;
        try {
            promoteSale.setPromoteStatus(1);
            int rows = dao.add(promoteSale);
            promoteId = promoteSale.getPromoteId();
            if(products==null){
                return promoteId;
            }
            Integer finalPromoteId = promoteId;
            products.forEach(product -> product.setPromoteId(finalPromoteId));
            int i = productService.batchAddObj(products);
            if (rows != 1 || i != products.size()) {
                throw new MvcException(S.GENERATE_ERROR);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            return -1;
        }
        return promoteId;
    }

    // 接受前端传递的数据后，获取自增id，再将其插入到另一个表中。
    @Transactional
    @Override
    public boolean updateById(PromoteSale promoteSale, List<PromoteProduct> products) {
        try {
            int rows = dao.updateById(promoteSale);
            Integer promoteId = promoteSale.getPromoteId();
            // 删除活动商品表中，所有参加该活动的商品
            productService.delByPromoteId(promoteId);
            // 给从前端获取到的活动商品赋值(活动id)
            products.forEach(product -> product.setPromoteId(promoteId));
            // 批量插入活动商品
            int i = productService.batchAddObj(products);
            if (rows != 1 || i != products.size()) {
                throw new MvcException(S.GENERATE_ERROR);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
    @Transactional
    @Override
    public boolean delById(String id){
        try {
            int rows = dao.delById(id);
            // 删除活动商品表中，所有参加该活动的商品
            int i = productService.delByPromoteId(Integer.parseInt(id));
            if (rows != 1 || i < 0) {
                throw new MvcException(S.GENERATE_ERROR);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
}
