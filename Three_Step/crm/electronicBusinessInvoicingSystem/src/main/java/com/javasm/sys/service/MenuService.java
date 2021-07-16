package com.javasm.sys.service;

import com.javasm.commons.bean.ReturnPermission;
import com.javasm.sys.entity.Menu;

import java.util.List;

import com.javasm.commons.base.BaseService;

public interface MenuService extends BaseService<Menu> {

    //递归查询所有子节点
    List<Menu> treeMenu(Menu m);

    List<ReturnPermission> selectAll(ReturnPermission p);

    boolean updateState(Integer menuState,Integer rid,Integer qid);
}
