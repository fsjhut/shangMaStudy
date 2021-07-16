package com.javasm.sys.service.impl;

import com.javasm.sys.entity.Gift;
import com.javasm.sys.dao.GiftDao;
import com.javasm.sys.service.GiftService;
import org.springframework.stereotype.Service;

import com.javasm.commons.base.BaseServiceImpl;

@Service("giftService")
public class GiftServiceImpl extends BaseServiceImpl<GiftDao, Gift> implements GiftService {

}
