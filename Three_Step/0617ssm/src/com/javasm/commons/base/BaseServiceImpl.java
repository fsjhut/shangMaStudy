package com.javasm.commons.base;

import com.javasm.commons.utils.CurrentLoginUser;
import com.javasm.commons.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

public class BaseServiceImpl<D extends BaseDao<T>,T extends BaseEntity> implements BaseService<T> {
    @Autowired
    protected D dao;

    @Override
    public T selectById(String id) {
        System.out.println(dao.getClass());
        return dao.selectById(id);
    }

    @Override
    public List<T> selectList(T obj) {
        return dao.selectList(obj);
    }

    @Override
    public boolean add(T obj) {
        obj.setCreateBy(CurrentLoginUser.getUname());
        obj.setCreateTime(DateUtil.getYMDHMS());
        obj.setUpdateTime(DateUtil.getYMDHMS());
        int rows = dao.add(obj);
        return rows==1?true:false;
    }

    @Override
    public boolean updateById(T obj) {
        obj.setUpdateBy(CurrentLoginUser.getUname());
        obj.setUpdateTime(DateUtil.getYMDHMS());
        int rows = dao.updateById(obj);
        return rows==1?true:false;
    }

    @Override
    public boolean delById(String id) {
        int i = dao.delById(id);
        return i==1?true:false;
    }

    @Override
    public boolean delByIds(List<String> ids) {
        int i = dao.delByIds(ids);
        return i>0?true:false;
    }


    public D getDao() {
        return dao;
    }

    public void setDao(D dao) {
        this.dao = dao;
    }
}
