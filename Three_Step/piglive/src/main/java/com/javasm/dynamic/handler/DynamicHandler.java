package com.javasm.dynamic.handler;

import com.javasm.dynamic.entity.Dynamic;
import com.javasm.dynamic.service.DynamicService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import com.javasm.commons.base.BaseHandler;
import com.javasm.commons.entity.AxiosResult;

import java.util.Arrays;
import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

@RestController
@RequestMapping("dynamic")
public class DynamicHandler extends BaseHandler {

    @Resource
    private DynamicService dynamicService;

    @GetMapping("{id}")
    public AxiosResult selectById(@PathVariable("id") String id) {
        Dynamic obj = this.dynamicService.getById(id);
        return suc(obj);
    }

//    @GetMapping("list")
//    public AxiosResult selectList(Dynamic obj) {
//        startPage();
//        List<Dynamic> list = this.dynamicService.list(new QueryWrapper<>(obj));
//        return toTableDatas(list);
//    }
    @GetMapping("list")
    public AxiosResult selectList(Dynamic obj) {
//        startPage();
        List<Dynamic> list = this.dynamicService.selectListDetail(obj);
        return suc(list);
    }

    @PostMapping
    public AxiosResult add(@RequestBody Dynamic obj) {
        boolean r = this.dynamicService.insertDynamic(obj);
        return result(r);
    }

    @PutMapping
    public AxiosResult update(@RequestBody Dynamic obj) {
        boolean r = this.dynamicService.updateById(obj);
        return result(r);
    }

    @DeleteMapping("{ids}")
    public AxiosResult delById(@PathVariable("ids") String ids) {
        String[] split = ids.split(",");
        boolean r = this.dynamicService.removeByIds(Arrays.asList(split));
        return result(r);
    }
}
