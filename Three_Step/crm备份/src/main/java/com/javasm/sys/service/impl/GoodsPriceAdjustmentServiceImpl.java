package com.javasm.sys.service.impl;

import com.javasm.sys.entity.GoodsManager;
import com.javasm.sys.entity.GoodsPriceAdjustment;
import com.javasm.sys.dao.GoodsPriceAdjustmentDao;
import com.javasm.sys.service.GoodsPriceAdjustmentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import com.javasm.commons.base.BaseServiceImpl;

@Service("goodsPriceAdjustmentService")
public class GoodsPriceAdjustmentServiceImpl extends BaseServiceImpl<GoodsPriceAdjustmentDao, GoodsPriceAdjustment> implements GoodsPriceAdjustmentService {

}
