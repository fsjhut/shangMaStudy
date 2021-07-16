package com.javasm.sys.service.impl;

import com.javasm.sys.entity.Gift;
import com.javasm.sys.dao.GiftDao;
import com.javasm.sys.service.GiftService;
import org.springframework.stereotype.Service;

import com.javasm.commons.base.BaseServiceImpl;

import java.util.List;

@Service("giftService")
public class GiftServiceImpl extends BaseServiceImpl<GiftDao, Gift> implements GiftService {

    @Override
    public List<Gift> selectBrand(String giftBrand) {
        List<Gift> list = getDao().selectBrand(giftBrand);
        if(list.size()>0) return list;
        return null;
    }

    @Override
    public List<Gift> selectColor(String color) {
        List<Gift> strings = getDao().selectColor(color);
        if(strings.size()>0)return strings;
        return null;
    }

    @Override
    public List<Gift> selectType(String giftType) {
        List<Gift> list = getDao().selectType(giftType);
        System.out.println("赠品类型"+list);
        if(list.size()>0)return list;
        return null;
    }
}
