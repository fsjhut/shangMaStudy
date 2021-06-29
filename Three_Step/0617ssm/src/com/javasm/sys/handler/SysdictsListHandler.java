package com.javasm.sys.handler;

import com.javasm.sys.entity.SysdictsList;
import com.javasm.sys.service.SysdictsListService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import com.javasm.commons.base.BaseHandler;
import com.javasm.commons.entity.AxiosResult;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("sysdictsList")
public class SysdictsListHandler extends BaseHandler {
    @Resource
    private SysdictsListService sysdictsListService;

    @GetMapping("type/{dkey}")
    public AxiosResult getDictsByDkey(@PathVariable("dkey")String dkey){
        SysdictsList l = new SysdictsList();
        l.setDkey(dkey);
        List<SysdictsList> sysdictsLists = sysdictsListService.selectList(l);//按照lsort排序
        return suc(sysdictsLists);
    }

    @GetMapping("{id}")
    public AxiosResult selectById(@PathVariable("id") String id) {
        SysdictsList obj = this.sysdictsListService.selectById(id);
        return suc(obj);
    }

    @GetMapping("list")
    public AxiosResult selectList(SysdictsList obj) {
        startPage();
        List<SysdictsList> list = this.sysdictsListService.selectList(obj);
        return toTableDatas(list);
    }

    @PostMapping
    public AxiosResult add(@RequestBody SysdictsList obj) {
        boolean r = this.sysdictsListService.add(obj);
        return result(r);
    }

    @PutMapping
    public AxiosResult update(@RequestBody SysdictsList obj) {
        boolean r = this.sysdictsListService.updateById(obj);
        return result(r);
    }

    @DeleteMapping("{ids}")
    public AxiosResult delById(@PathVariable("ids") String ids) {
        String[] split = ids.split(",");
        boolean r = this.sysdictsListService.delByIds(Arrays.asList(split));
        return result(r);
    }
}
