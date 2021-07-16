package com.javasm.sys.service.impl;

import com.javasm.commons.utils.CurrentLoginUser;
import com.javasm.sys.entity.PromoteProduct;
import com.javasm.sys.entity.PromoteSale;
import com.javasm.sys.entity.Verify;
import com.javasm.sys.dao.VerifyDao;
import com.javasm.sys.service.PromoteSaleService;
import com.javasm.sys.service.VerifyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.javasm.commons.base.BaseServiceImpl;

@Service("verifyService")
public class VerifyServiceImpl extends BaseServiceImpl<VerifyDao, Verify> implements VerifyService {
    @Resource
    PromoteSaleService promoteService;

    @Override
    public List<PromoteSale> selectAllList(Verify obj) {
        List<PromoteSale> promoteSales = new ArrayList<>();
        // 先查询所有符合条件的审核单
        List<Verify> verifies = dao.selectList(obj);
        for (Verify verify : verifies) {
            Long verifyTableId = verify.getVerifyTableId();
            // 进行查询
            PromoteSale promoteSale = promoteService.selectById(String.valueOf(verifyTableId));
            promoteSales.add(promoteSale);
        }
        return promoteSales;
    }

    @Override
    public boolean addVerify(PromoteSale promoteSale, List<PromoteProduct> products) {
        Verify verify = new Verify();
        Integer verifyTableId = promoteService.submit(promoteSale, products);
        // 获取申请人的名字
        String createBy = promoteSale.getCreateBy();
        // 获取表名
        verify.setVerifyTable("promote_sale");
        verify.setVerifyTableId(verifyTableId.longValue());
        // 获取用户的od
        verify.setVerifyPerson("admin");
        verify.setVerifyStatus(0);

        int add = dao.add(verify);
        return add == 1;
    }

    @Override
    public boolean updateVerify(PromoteSale promoteSale, List<PromoteProduct> products) {
        Verify verify = new Verify();
        promoteSale.setPromoteStatus(1);
        promoteService.updateById(promoteSale, products);
        // 获取申请人的名字
        String createBy = promoteSale.getCreateBy();
        // 获取表名
        verify.setVerifyTable("promote_sale");
        verify.setVerifyTableId(promoteSale.getPromoteId().longValue());
        // 获取用户的od
        verify.setVerifyPerson("admin");
        verify.setVerifyStatus(0);
        verify.setApplicant(createBy);

        int add = dao.add(verify);
        return add == 1;
    }

    // 添加审核，根据审核意见，修改审核中的字段状态
    @Override
    public boolean add(Verify verify) {

        String verifyTable = verify.getVerifyTable();
        Long verifyTableId = verify.getVerifyTableId();
        PromoteSale promoteSale = promoteService.selectById(String.valueOf(verifyTableId));
        // 如果未通过，则设置为审核为未通过
        if (verify.getVerifyStatus() == 2) {
            promoteSale.setPromoteStatus(2);
            promoteService.updateById(promoteSale);
            int add = dao.add(verify);
            return add == 1;
        } else {
            // 如果已通过，则查询是否 存在审核记录，如果有，则代表已经过一轮审核
            // 如果没有记录 则代表本次审核为第一次审核
            List<Verify> verifies = dao.selectDetailByTableId(String.valueOf(verifyTableId));
            if (verifies.size() == 1) {
                promoteSale.setPromoteStatus(3);
                promoteService.updateById(promoteSale);
                int add = dao.add(verify);
                return add == 1;
            } else {
                // 第一次审核通过，
                int add = dao.add(verify);
                // 生成第二次的审核表，需要知道第二次的审核人和相关信息
                // 可以做一个工具类，获取当前用户的上一级用户(领导)
                verify.setVerifyPerson("admin");
                verify.setVerifyStatus(0);
                int add1 = dao.add(verify);
                return add == 1 && add1 == 1;
            }
        }
    }

    @Override
    public Map<String, Object> selectDetailByTableId(String tableId) {
        // 审核单id可重复，即：一个活动订单可以由多个人审核。
        List<Verify> verifies = dao.selectDetailByTableId(tableId);
        Map<String, Object> stringObjectMap = promoteService.selectDetailById(String.valueOf(tableId));
        stringObjectMap.put("Verify", verifies);
        return stringObjectMap;
    }
}
