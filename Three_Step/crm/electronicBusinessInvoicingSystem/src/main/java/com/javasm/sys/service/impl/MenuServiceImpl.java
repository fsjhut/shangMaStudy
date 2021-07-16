package com.javasm.sys.service.impl;

import com.alibaba.fastjson.JSON;
import com.javasm.commons.bean.ReturnPermission;
import com.javasm.commons.cache.RedisService;
import com.javasm.commons.utils.CurrentLoginUser;
import com.javasm.sys.entity.CrmSysuser;
import com.javasm.sys.entity.Menu;
import com.javasm.sys.dao.MenuDao;
import com.javasm.sys.service.MenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

import com.javasm.commons.base.BaseServiceImpl;
import org.springframework.transaction.annotation.Transactional;

@Service("menuService")
public class MenuServiceImpl extends BaseServiceImpl<MenuDao, Menu> implements MenuService {
    @Resource
    private RedisService rs;

    @Transactional
    @Override
    public boolean add(Menu obj) {
        List<Menu> maxId = getDao().getMaxId(obj.getParentId());
        Integer newMneuId=0;
        newMneuId = maxId.get(0).getMenuId();
        obj.setMenuId(newMneuId+1);
        return super.add(obj);

    }

    @Override
    public List<Menu> treeMenu(Menu m) {
        CrmSysuser loginUser = CurrentLoginUser.getLoginUser();
        List<Menu> menus = getDao().getpermissionList(loginUser.getUid());

        List<Menu> tree = new ArrayList<>();
//        List<Menu> menus = getDao().selectList(m);
        for (Menu menu : menus) {
            if (menu.getParentId().equals(10)){
                menu.setSubmenu(selectChidren(menus,menu));
                tree.add(menu);
            }
        }
        rs.set("menuTree",JSON.toJSONString(tree));
        return tree;
    }

    @Override
    public List<ReturnPermission> selectAll(ReturnPermission p) {
        List<ReturnPermission> returnPermissions = getDao().selectAll(p);
        return returnPermissions;
    }

    @Override
    public boolean updateState(Integer menuState,Integer rid,Integer qid) {
        int editState = getDao().editState(menuState,rid,qid);
        return editState>0?true:false;
    }

    private static List<Menu> selectChidren(List<Menu> menus,Menu menu){
        List<Menu> childs = new ArrayList<>();
        for (Menu m : menus) {
            if (m.getParentId().equals(menu.getMenuId())){
                childs.add(m);
                m.setSubmenu(selectChidren(menus,m));
            }
        }
        return childs;
    }

}
