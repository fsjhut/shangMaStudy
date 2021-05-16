package com.javasm.service.impl;

import com.javasm.dao.AreaDao;
import com.javasm.dao.impl.AreaDaoImpl;
import com.javasm.entity.MyArea;
import com.javasm.service.AreaService;

import java.util.List;

public class AreaServiceImpl implements AreaService {
    @Override
    public List<MyArea> getAreaByParentCode(Integer pcode) {
        AreaDao ad = new AreaDaoImpl();
        return ad.getAreaByParentCode(pcode);
    }
}
