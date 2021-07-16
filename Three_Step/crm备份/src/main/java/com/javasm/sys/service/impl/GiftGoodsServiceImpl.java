package com.javasm.sys.service.impl;

import com.javasm.sys.entity.GiftGoods;
import com.javasm.sys.dao.GiftGoodsDao;
import com.javasm.sys.service.GiftGoodsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import com.javasm.commons.base.BaseServiceImpl;

@Service("giftGoodsService")
public class GiftGoodsServiceImpl extends BaseServiceImpl<GiftGoodsDao, GiftGoods> implements GiftGoodsService {

}
