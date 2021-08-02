package com.javasm.dynamic.service.impl;

import com.javasm.commons.entity.S;
import com.javasm.commons.exception.MvcException;
import com.javasm.dynamic.dao.DynamicImgDao;
import com.javasm.dynamic.dao.UserCommentDao;
import com.javasm.dynamic.entity.Dynamic;
import com.javasm.dynamic.dao.DynamicDao;
import com.javasm.dynamic.entity.DynamicImg;
import com.javasm.dynamic.service.DynamicService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;

@Service("dynamicService")
public class DynamicServiceImpl extends ServiceImpl<DynamicDao, Dynamic> implements DynamicService {
    @Resource
    private DynamicDao dao;
    @Resource
    private DynamicImgDao imgDao;
    @Override
    public List<Dynamic> selectListDetail(Dynamic obj) {
        List<Dynamic> dynamics = dao.selectListDetail(obj);
        return dynamics;
    }

    @Override
    @Transactional
    public boolean insertDynamic(Dynamic obj) {
        int insert = dao.insert(obj);
        List<String> imgList = obj.getImgList();
        ArrayList<DynamicImg> dynamicImgs = new ArrayList<>();
        Integer insertNum = 0;
        imgList.forEach((str)->{
            DynamicImg dynamicImg = new DynamicImg();
            dynamicImg.setDynamicId(obj.getDynamicId());
            dynamicImg.setUid(obj.getUid());
            dynamicImg.setImgSrc(str);
            dynamicImgs.add(dynamicImg);
        });
        for (DynamicImg dynamicImg : dynamicImgs) {
            int insert1 = imgDao.insert(dynamicImg);
            insertNum += insert1;
        }
        if(insert!=1||insertNum!=dynamicImgs.size()){
            throw new MvcException(S.ERROR);
        }
        return true;
    }
}
