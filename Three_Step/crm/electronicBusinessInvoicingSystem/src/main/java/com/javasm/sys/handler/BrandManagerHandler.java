package com.javasm.sys.handler;

import com.javasm.sys.entity.BrandManager;
import com.javasm.sys.service.BrandManagerService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import com.javasm.commons.base.BaseHandler;
import com.javasm.commons.entity.AxiosResult;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("brandManager")
public class BrandManagerHandler extends BaseHandler {

    @Resource
    private BrandManagerService brandManagerService;

    @GetMapping("{id}")
    public AxiosResult selectById(@PathVariable("id") String id) {
        BrandManager obj = this.brandManagerService.selectById(id);
        return suc(obj);
    }

    @GetMapping("list")
    public AxiosResult selectList(BrandManager obj) {
        startPage();
        List<BrandManager> list = this.brandManagerService.selectList(obj);
        return toTableDatas(list);
    }

    @PostMapping("add")
    public AxiosResult add(@RequestBody BrandManager obj) {
        boolean r = this.brandManagerService.add(obj);
        return result(r);
    }

    @PutMapping
    public AxiosResult update(@RequestBody BrandManager obj) {
        boolean r = this.brandManagerService.updateById(obj);
        return result(r);
    }
    @PutMapping("update1")
    public AxiosResult update1(@RequestBody BrandManager obj) {
        obj.setBrandDeleteStatus(0);
        boolean r = this.brandManagerService.updateById(obj);

        return result(r);
    }
    @DeleteMapping("{ids}")
    public AxiosResult delById(@PathVariable("ids") String ids) {
        String[] split = ids.split(",");
        boolean r = this.brandManagerService.delByIds(Arrays.asList(split));
        return result(r);
    }


}
