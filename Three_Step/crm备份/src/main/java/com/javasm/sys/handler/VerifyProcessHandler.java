package com.javasm.sys.handler;

import com.javasm.commons.base.BaseHandler;
import com.javasm.sys.service.PromoteSaleService;
import com.javasm.sys.service.VerifyService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @className: VerfiyProcess
 * @description:   
 * @author SunHang
 * @createTime 2021/7/1 11:36
 */
@RestController
@RequestMapping("verifyprocess")
public class VerifyProcessHandler extends BaseHandler {
    @Resource
    private VerifyService verifyService;
    @Resource
    private PromoteSaleService promoteService;

    // 点击提交，则保存数据库，然后生成一个审核记录

    // 第一个审核结束，则自动生成第二个审核记录

}
