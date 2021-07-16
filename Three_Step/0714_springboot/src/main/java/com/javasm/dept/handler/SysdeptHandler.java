package com.javasm.dept.handler;

import com.javasm.dept.entity.Sysdept;
import com.javasm.dept.service.SysdeptService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import com.javasm.commons.base.BaseHandler;
import com.javasm.commons.entity.AxiosResult;

import java.util.Arrays;
import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

@RestController
@RequestMapping("sysdept")
public class SysdeptHandler extends BaseHandler {

    @Resource
    private SysdeptService sysdeptService;

    @GetMapping("{id}")
    public AxiosResult selectById(@PathVariable("id") String id) {
        Sysdept obj = this.sysdeptService.getById(id);
        return suc(obj);
    }

    @GetMapping("list")
    public AxiosResult selectList(Sysdept obj) {
        startPage();
        List<Sysdept> list = this.sysdeptService.list(new QueryWrapper<>(obj));
        return toTableDatas(list);
    }

    @PostMapping
    public AxiosResult add(@RequestBody Sysdept obj) {
        boolean r = this.sysdeptService.save(obj);
        return result(r);
    }

    @PutMapping
    public AxiosResult update(@RequestBody Sysdept obj) {
        boolean r = this.sysdeptService.updateById(obj);
        return result(r);
    }

    @DeleteMapping("{ids}")
    public AxiosResult delById(@PathVariable("ids") String ids) {
        String[] split = ids.split(",");
        boolean r = this.sysdeptService.removeByIds(Arrays.asList(split));
        return result(r);
    }
}
