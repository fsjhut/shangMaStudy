package com.javasm.sys.handler;

import com.javasm.sys.entity.SysdictsType;
import com.javasm.sys.service.SysdictsTypeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import com.javasm.commons.base.BaseHandler;
import com.javasm.commons.entity.AxiosResult;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("sysdictsType")
public class SysdictsTypeHandler extends BaseHandler {
    @Resource
    private SysdictsTypeService sysdictsTypeService;

    @GetMapping("{id}")
    public AxiosResult selectById(@PathVariable("id") String id) {
        SysdictsType obj = this.sysdictsTypeService.selectById(id);
        return suc(obj);
    }

    @GetMapping("list")
    public AxiosResult selectList(SysdictsType obj) {
        startPage();
        List<SysdictsType> list = this.sysdictsTypeService.selectList(obj);
        return toTableDatas(list);
    }

    @PostMapping
    public AxiosResult add(@RequestBody SysdictsType obj) {
        boolean r = this.sysdictsTypeService.add(obj);
        return result(r);
    }

    @PutMapping
    public AxiosResult update(@RequestBody SysdictsType obj) {
        boolean r = this.sysdictsTypeService.updateById(obj);
        return result(r);
    }

    @DeleteMapping("{ids}")
    public AxiosResult delById(@PathVariable("ids") String ids) {
        String[] split = ids.split(",");
        boolean r = this.sysdictsTypeService.delByIds(Arrays.asList(split));
        return result(r);
    }


}
