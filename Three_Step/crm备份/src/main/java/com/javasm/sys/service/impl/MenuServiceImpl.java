package com.javasm.sys.service.impl;

import com.alibaba.fastjson.JSON;
import com.javasm.commons.cache.RedisService;
import com.javasm.sys.entity.Menu;
import com.javasm.sys.dao.MenuDao;
import com.javasm.sys.service.MenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

import com.javasm.commons.base.BaseServiceImpl;

@Service("menuService")
public class MenuServiceImpl extends BaseServiceImpl<MenuDao, Menu> implements MenuService {
    @Resource
    private RedisService rs;

    @Override
    public List<Menu> treeMenu(Menu m) {

        List<Menu> tree = new ArrayList<>();
        List<Menu> menus = getDao().selectList(m);
        for (Menu menu : menus) {
            if (menu.getParentId().equals(10)){
                menu.setSubmenu(selectChidren(menus,menu));
                tree.add(menu);
            }
        }
        rs.set("menuTree",JSON.toJSONString(tree));
        return tree;
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
