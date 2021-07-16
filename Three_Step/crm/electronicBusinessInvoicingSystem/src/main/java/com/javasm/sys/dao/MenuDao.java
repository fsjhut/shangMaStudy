package com.javasm.sys.dao;

import com.javasm.commons.bean.ReturnPermission;
import com.javasm.sys.entity.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

import com.javasm.commons.base.BaseDao;

public interface MenuDao extends BaseDao<Menu> {
    List<ReturnPermission> selectAll(ReturnPermission p);

    List<Menu> getMaxId(Integer parentId);

    int editState(@Param("menuState") Integer menuState,@Param("rid") Integer rid,@Param("qid") Integer qid);

    List<Menu> getpermissionList(Integer uid);
}

