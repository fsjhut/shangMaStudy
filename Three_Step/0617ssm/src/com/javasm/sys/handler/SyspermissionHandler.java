package com.javasm.sys.handler;

import com.javasm.sys.entity.Syspermission;
import com.javasm.sys.service.SyspermissionService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import com.javasm.commons.base.BaseHandler;
import com.javasm.commons.entity.AxiosResult;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("syspermission")
public class SyspermissionHandler extends BaseHandler {

    @Resource
    private SyspermissionService syspermissionService;

    @GetMapping("{id}")
    public AxiosResult selectById(@PathVariable("id") String id) {
        Syspermission obj = this.syspermissionService.selectById(id);
        return suc(obj);
    }

    @GetMapping("list")
    public AxiosResult selectList(Syspermission obj) {
        startPage();
        List<Syspermission> list = this.syspermissionService.selectList(obj);
        return toTableDatas(list);
    }

    @PostMapping
    public AxiosResult add(@RequestBody Syspermission obj) {
        boolean r = this.syspermissionService.add(obj);
        return result(r);
    }

    @PutMapping
    public AxiosResult update(@RequestBody Syspermission obj) {
        boolean r = this.syspermissionService.updateById(obj);
        return result(r);
    }

    @DeleteMapping("{ids}")
    public AxiosResult delById(@PathVariable("ids") String ids) {
        String[] split = ids.split(",");
        boolean r = this.syspermissionService.delByIds(Arrays.asList(split));
        return result(r);
    }


}
