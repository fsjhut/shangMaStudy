package com.javasm.sys.service.impl;

import com.javasm.sys.entity.CrmFactoryGoods;
import com.javasm.sys.dao.CrmFactoryGoodsDao;
import com.javasm.sys.service.CrmFactoryGoodsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import com.javasm.commons.base.BaseServiceImpl;

@Service("crmFactoryGoodsService")
public class CrmFactoryGoodsServiceImpl extends BaseServiceImpl<CrmFactoryGoodsDao, CrmFactoryGoods> implements CrmFactoryGoodsService {

}
