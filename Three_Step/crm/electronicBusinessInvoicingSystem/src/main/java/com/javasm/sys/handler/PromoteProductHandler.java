package com.javasm.sys.handler;

import com.javasm.sys.entity.PromoteProduct;
import com.javasm.sys.service.PromoteProductService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import com.javasm.commons.base.BaseHandler;
import com.javasm.commons.entity.AxiosResult;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("promoteProduct")
public class PromoteProductHandler extends BaseHandler {

    @Resource
    private PromoteProductService promoteProductService;

    @GetMapping("{id}")
    public AxiosResult selectById(@PathVariable("id") String id) {
        PromoteProduct obj = this.promoteProductService.selectById(id);
        return suc(obj);
    }

    @GetMapping("list")
    public AxiosResult selectList(PromoteProduct obj) {
        startPage();
        List<PromoteProduct> list = this.promoteProductService.selectList(obj);
        return toTableDatas(list);
    }

    @PostMapping
    public AxiosResult add(@RequestBody PromoteProduct obj) {
        boolean r = this.promoteProductService.add(obj);
        return result(r);
    }

    @PutMapping
    public AxiosResult update(@RequestBody PromoteProduct obj) {
        boolean r = this.promoteProductService.updateById(obj);
        return result(r);
    }

    @DeleteMapping("{ids}")
    public AxiosResult delById(@PathVariable("ids") String ids) {
        String[] split = ids.split(",");
        boolean r = this.promoteProductService.delByIds(Arrays.asList(split));
        return result(r);
    }
}
