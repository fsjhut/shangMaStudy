package com.javasm.sys.handler;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.javasm.commons.bean.ReturnPermission;
import com.javasm.commons.cache.RedisService;
import com.javasm.sys.entity.Menu;
import com.javasm.sys.service.MenuService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import com.javasm.commons.base.BaseHandler;
import com.javasm.commons.entity.AxiosResult;

import java.io.Writer;
import java.util.ArrayList;
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
        //将菜单数据更新到redis中
        List<Menu> menus = menuService.treeMenu(new Menu());
        rs.set("menuTree",JSON.toJSONString(menus));
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
//        String menuTree = rs.get("menuTree");
//        if (menuTree!=null){
//            List<Menu> menu1 = JSON.parseArray(menuTree, Menu.class);
//            return toTableDatas(menu1);
//        }
        List<Menu> menus = this.menuService.treeMenu(menu);
        return toTableDatas(menus);
    }
    @GetMapping("permission")
    public AxiosResult queryAll(ReturnPermission p,@RequestParam(defaultValue = "1") Integer pageNum,@RequestParam(defaultValue = "10") Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);

        List<ReturnPermission> returnPermissions = this.menuService.selectAll(p);

        return toTableDatas(returnPermissions);
    }
    @GetMapping("allpermissions")
    public AxiosResult querypermissions(ReturnPermission p){

        List<ReturnPermission> returnPermissions = this.menuService.selectAll(p);

        return suc(returnPermissions);
    }
    @PutMapping("changeState")
    public AxiosResult editState(Integer menuState,Integer rid,Integer qid){
        boolean updateState = this.menuService.updateState(menuState,rid,qid);
        return result(updateState);
    }

    @PostMapping("out")
    public AxiosResult outpermission(){
        String menuTree = rs.get("menuTree");
        List<Menu> menus = null;
        if (menuTree==null){
            menus = this.menuService.selectList(new Menu());
        }else{
            menus = JSON.parseArray(menuTree, Menu.class);
        }
        ArrayList<Object> list = CollUtil.newArrayList();
        for (Menu menu : menus) {
            list.add(menu);
        }
        String path = "d:/权限.xlsx";
        ExcelWriter writer = ExcelUtil.getWriter(path);
        writer.addHeaderAlias("menuId","菜单id");
        writer.addHeaderAlias("menuName","菜单名称");
        writer.addHeaderAlias("parentId","上级菜单id");
        writer.addHeaderAlias("menuUrl","菜单url");
        writer.addHeaderAlias("menuHandle","菜单可操作权限");
        writer.addHeaderAlias("menuDesc","菜单描述");
        writer.addHeaderAlias("submenu","下级菜单");
        writer.addHeaderAlias("createTime","创建时间");
        writer.addHeaderAlias("updateTime","更新时间");
        writer.addHeaderAlias("createBy","创建人");
        writer.addHeaderAlias("updateBy","更新人");
        writer.merge(10,"权限表详情");
        writer.write(list,true);
        writer.close();
        return suc(path);
    }


}
















