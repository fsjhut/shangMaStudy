package com.javasm.sys.service.impl;

import com.javasm.sys.entity.OutGoods;
import com.javasm.sys.dao.OutGoodsDao;
import com.javasm.sys.service.OutGoodsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import com.javasm.commons.base.BaseServiceImpl;

@Service("outGoodsService")
public class OutGoodsServiceImpl extends BaseServiceImpl<OutGoodsDao, OutGoods> implements OutGoodsService {

}
