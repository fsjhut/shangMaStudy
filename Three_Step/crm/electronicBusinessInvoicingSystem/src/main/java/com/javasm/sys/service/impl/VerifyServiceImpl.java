package com.javasm.sys.service.impl;

import com.javasm.commons.entity.S;
import com.javasm.commons.exception.MvcException;
import com.javasm.commons.utils.CurrentLoginUser;
import com.javasm.commons.utils.DateUtil;
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
import org.springframework.transaction.annotation.Transactional;

@Service("verifyService")
public class VerifyServiceImpl extends BaseServiceImpl<VerifyDao, Verify> implements VerifyService {
    @Resource
    PromoteSaleService promoteService;


    @Override
    public List<PromoteSale> selectAllList(PromoteSale obj) {
        // obj是查询的条件，将所有 有效数据与根据条件查询的数据进行差集运算，可以得到需要的数据
        List<PromoteSale> promoteSales1 = promoteService.selectList(obj);
        List<PromoteSale> promoteSales = new ArrayList<>();
        List<PromoteSale> promoteSales3 = new ArrayList<>();
        Verify verify1 = new Verify();

        // 获取当前登录人，根据当前登录人和数据表名去数据库中进行查询
        // 只可以查询到活动单状态为已经完成/已拒绝，需要自己审核的未审核单
        // 不可以查询到自己已经审核，但是下一级未审核的活动数据
        verify1.setVerifyPerson(CurrentLoginUser.getUname());

//        verify1.setVerifyTable();
        // 查询与自己有关的所有数据
        List<Verify> verifies = dao.selectList(verify1);

        for (Verify verify : verifies) {
            // 根据审核单中tableid获取活动申请
            Long verifyTableId = verify.getVerifyTableId();
            PromoteSale promoteSale = promoteService.selectById(String.valueOf(verifyTableId));
            // 如果自己的审核状态是已审核，则查询该审核单对应的活动申请单的状态，
            // 若活动申请单的状态为 待审核，则不显示该数据
            // 若活动申请单的状态为 已审核或者拒绝，则显示
            if(verify.getVerifyStatus().equals(1)||verify.getVerifyStatus().equals(2)){
                if(promoteSale.getPromoteStatus().equals(1)){
                    continue;
                }
            }
            promoteSales.add(promoteSale);
        }
        promoteSales1.retainAll(promoteSales);
        // 查询出来的两个集合的交集,根据两个集合中的id进行判断是否是一个数据
//        for (PromoteSale promoteSale : promoteSales1) {
//            for (PromoteSale sale : promoteSales) {
//                if (promoteSale.getPromoteId().equals(sale.getPromoteId())){
//                    promoteSales3.add(sale);
//                    break;
//                }
//            }
//        }
        return promoteSales1;
    }
    @Transactional
    @Override
    public boolean addVerify(PromoteSale promoteSale, List<PromoteProduct> products) {
        Verify verify = new Verify();
        Integer verifyTableId = promoteService.submit(promoteSale, products);
        // 获取申请人的名字
//        String createBy = promoteSale.getCreateBy();
        String createBy = CurrentLoginUser.getUname();
        // 获取表名
        verify.setVerifyId(100);
        verify.setVerifyTable("promote_sale");
        verify.setVerifyTableId(verifyTableId.longValue());
        verify.setApplicant(createBy);
        verify.setVerifyPerson("manager");
        //
        verify.setVerifyStatus(0);

        int add = dao.add(verify);
        if(add!=1){
            throw new MvcException(S.ERROR);
        }
        return true;
    }
    @Transactional
    @Override
    public boolean updateVerify(PromoteSale promoteSale, List<PromoteProduct> products) {
        Verify verify = new Verify();
        // 改变活动单的审核状态为正在审核
        promoteSale.setPromoteStatus(1);
        promoteService.updateById(promoteSale, products);
        // 获取申请人的名字
        String createBy = promoteSale.getCreateBy();
        // 获取表名
        verify.setVerifyTable("promote_sale");
        //设定审核单的id
        verify.setVerifyId(100);
//        verify.setApplicant(promoteSale.getCreateBy());
        verify.setVerifyTableId(promoteSale.getPromoteId().longValue());
        // 获取审核用户的id，正常是获取当前登录人(申请人)的上一级
        // 这里指定上一级是manager
        verify.setVerifyPerson("manager");
        verify.setVerifyStatus(0);
        verify.setApplicant(createBy);

        int add = dao.add(verify);
        if(add!=1){
            throw new MvcException(S.ERROR);
        }
        return true;
    }

    // 添加审核，根据审核意见，修改审核中的字段状态
    @Transactional
    @Override
    public boolean add(Verify verify) {
        String verifyTable = verify.getVerifyTable();
        Long verifyTableId = verify.getVerifyTableId();
        PromoteSale promoteSale = promoteService.selectById(String.valueOf(verifyTableId));
        // 如果未通过，则设置为审核为未通过
        verify.setVerifyTime(DateUtil.getYMDHMS());
        verify.setVerifyPerson(CurrentLoginUser.getUname());

        System.out.println(verify);
        if (verify.getVerifyStatus() == 2) {
            verify.setVerifyId(100);
            // 通过tableID和审核状态确定唯一的审核表
            int add = dao.updateById(verify);
            promoteSale.setPromoteStatus(2);
            boolean b = promoteService.updateById(promoteSale);
            if(!(add == 1 && b)){
                throw new MvcException(S.ERROR);
            }
            return true;
        } else {
            // 如果已通过，则查询是第几次审核
            // 通过审核表中的按时间排序的倒数第二条记录 的审核状态来判断
            Verify verify2 = dao.selectStatusByTableId(String.valueOf(verifyTableId));
            // 判断是否是第一次审核 如果上条记录 不存在，或者上条记录为拒绝，则代表为第第一审核
            if (verify2==null || verify2.getVerifyStatus() == 2) {
                verify.setVerifyId(100);
                // 通过tableID和审核状态确定唯一的审核表
                int add = dao.updateById(verify);
                //当前用户为第一次审核，则生成一条新的审核记录，供第二个审核人使用
                // 生成第二次的审核表，需要知道第二次的审核人和相关信息
                // 可以做一个工具类，获取当前用户的上一级用户(领导)
                Verify verify1 = new Verify();
                verify1.setVerifyTable(verifyTable);
                verify1.setApplicant(promoteSale.getCreateBy());
                verify1.setVerifyTableId(verifyTableId);
                verify1.setVerifyPerson("root");
                verify1.setVerifyStatus(0);
                int add1 = dao.add(verify1);
                if(!(add == 1 && add1 == 1)){
                    throw new MvcException(S.ERROR);
                }
                return true;
            } else {
                verify.setVerifyId(200);
                // 通过tableID和审核状态确定唯一的审核表
                int add = dao.updateById(verify);
                // 第二次审核，更新活动表中的审核状态
                promoteSale.setPromoteStatus(3);
                boolean b = promoteService.updateById(promoteSale);
                if(!(add == 1 && b)){
                    throw new MvcException(S.ERROR);
                }
                return true;
            }
        }
    }

    @Override
    public Map<String, Object> selectDetailByTableId(String tableId) {
        // 审核单中的table id可重复，即：一个活动订单可以由多个人审核。
        List<Verify> verifies = dao.selectDetailByTableId(tableId);
        Map<String, Object> stringObjectMap = promoteService.selectDetailById(String.valueOf(tableId));
        stringObjectMap.put("Verify", verifies);
        return stringObjectMap;
    }
}
