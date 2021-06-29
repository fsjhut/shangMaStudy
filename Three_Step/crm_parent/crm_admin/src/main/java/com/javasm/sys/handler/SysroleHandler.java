package com.javasm.sys.handler;

import com.javasm.base.BaseHandler;
import com.javasm.commons.entity.AxiosResult;
import com.javasm.sys.entity.Sysrole;
import com.javasm.sys.service.SysroleService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("sysrole")
public class SysroleHandler extends BaseHandler {

    @Resource
    private SysroleService sysroleService;

    @GetMapping("{id}")
    public AxiosResult selectById(@PathVariable("id") String id) {
        Sysrole obj = this.sysroleService.selectById(id);
        return suc(obj);
    }

    @GetMapping("list")
    public AxiosResult selectList(Sysrole obj) {
        startPage();
        List<Sysrole> list = this.sysroleService.selectList(obj);
        return toTableDatas(list);
    }

    @PostMapping
    public AxiosResult add(@RequestBody Sysrole obj) {
        boolean r = this.sysroleService.add(obj);
        return result(r);
    }

    @PutMapping
    public AxiosResult update(@RequestBody Sysrole obj) {
        boolean r = this.sysroleService.updateById(obj);
        return result(r);
    }

    @DeleteMapping("{ids}")
    public AxiosResult delById(@PathVariable("ids") String ids) {
        String[] split = ids.split(",");
        boolean r = this.sysroleService.delByIds(Arrays.asList(split));
        return result(r);
    }
}
