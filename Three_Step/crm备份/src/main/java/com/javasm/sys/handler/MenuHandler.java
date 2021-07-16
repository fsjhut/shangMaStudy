package com.javasm.sys.handler;

import com.alibaba.fastjson.JSON;
import com.javasm.commons.cache.RedisService;
import com.javasm.sys.entity.Menu;
import com.javasm.sys.service.MenuService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import com.javasm.commons.base.BaseHandler;
import com.javasm.commons.entity.AxiosResult;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("menu")
public class MenuHandler extends BaseHandler {
    @Resource
    private RedisService rs;

    @Resource
    private MenuService menuService;

    @GetMapping("{id}")
    public AxiosResult selectById(@PathVariable("id") String id) {
        Menu obj = this.menuService.selectById(id);
        return suc(obj);
    }

    @GetMapping("list")
    public AxiosResult selectAll(Menu obj) {
        startPage();
        List<Menu> list = this.menuService.selectList(obj);
        return toTableDatas(list);
    }

    @PostMapping
    public AxiosResult add(@RequestBody Menu obj) {
        boolean r = this.menuService.add(obj);
        return result(r);
    }

    @PutMapping
    public AxiosResult update(@RequestBody Menu obj) {
        boolean r = this.menuService.updateById(obj);
        return result(r);
    }

    @DeleteMapping("{ids}")
    public AxiosResult delById(@PathVariable("ids") String ids) {
        String[] split = ids.split(",");
        boolean r = this.menuService.delByIds(Arrays.asList(split));
        return result(r);
    }
    @GetMapping("tree")
    public AxiosResult queryTree(Menu menu){
        String menuTree = rs.get("menuTree");
        if (menuTree!=null){
            List<Menu> menu1 = JSON.parseArray(menuTree, Menu.class);
            return toTableDatas(menu1);
        }
        List<Menu> menus = this.menuService.treeMenu(menu);
        return toTableDatas(menus);
    }


}
















