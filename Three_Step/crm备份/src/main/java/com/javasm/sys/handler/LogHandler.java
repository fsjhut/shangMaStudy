package com.javasm.sys.handler;

import com.javasm.commons.base.BaseHandler;
import com.javasm.commons.entity.AxiosResult;
import com.javasm.sys.entity.Log;
import com.javasm.sys.service.LogService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("log")
public class LogHandler extends BaseHandler {

    @Resource
    private LogService logService;



    @GetMapping("{id}")
    public AxiosResult selectById(@PathVariable("id") String id) {
        Log obj = this.logService.selectById(id);
        return suc(obj);
    }

    @GetMapping("list")
    public AxiosResult selectList(Log obj) {
        startPage();
        List<Log> list = this.logService.selectList(obj);
        return toTableDatas(list);
    }

    @PostMapping
    public AxiosResult add(@RequestBody Log obj) {
        boolean r = this.logService.add(obj);
        return result(r);
    }

    @PutMapping
    public AxiosResult update(@RequestBody Log obj) {
        boolean r = this.logService.updateById(obj);
        return result(r);
    }

    @DeleteMapping("{ids}")
    public AxiosResult delById(@PathVariable("ids") String ids) {
        String[] split = ids.split(",");
        boolean r = this.logService.delByIds(Arrays.asList(split));
        return result(r);
    }




}
