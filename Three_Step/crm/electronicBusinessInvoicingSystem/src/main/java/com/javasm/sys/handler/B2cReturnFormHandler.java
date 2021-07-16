package com.javasm.sys.handler;

import com.javasm.sys.entity.B2cReturnForm;
import com.javasm.sys.service.B2cReturnFormService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import com.javasm.commons.base.BaseHandler;
import com.javasm.commons.entity.AxiosResult;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("b2cReturnForm")
public class B2cReturnFormHandler extends BaseHandler {

    @Resource
    private B2cReturnFormService b2cReturnFormService;

    @GetMapping("{id}")
    public AxiosResult selectById(@PathVariable("id") String id) {
        B2cReturnForm obj = this.b2cReturnFormService.selectById(id);
        return suc(obj);
    }

    @GetMapping("list")
    public AxiosResult selectList(B2cReturnForm obj) {
        startPage();
        List<B2cReturnForm> list = this.b2cReturnFormService.selectList(obj);
        return toTableDatas(list);
    }

    @PostMapping
    public AxiosResult add(@RequestBody B2cReturnForm obj) {
        boolean r = this.b2cReturnFormService.add(obj);
        return result(r);
    }

    @PutMapping
    public AxiosResult update(@RequestBody B2cReturnForm obj) {
        boolean r = this.b2cReturnFormService.updateById(obj);
        return result(r);
    }

    @DeleteMapping("{ids}")
    public AxiosResult delById(@PathVariable("ids") String ids) {
        String[] split = ids.split(",");
        boolean r = this.b2cReturnFormService.delByIds(Arrays.asList(split));
        return result(r);
    }


}
