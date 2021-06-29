package com.javasm.sys.handler;

import com.javasm.commons.entity.S;
import com.javasm.sys.entity.Sysdept;
import com.javasm.sys.service.SysdeptService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import com.javasm.commons.base.BaseHandler;
import com.javasm.commons.entity.AxiosResult;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("sysdept")
public class SysdeptHandler extends BaseHandler {

    @Resource
    private SysdeptService sysdeptService;

    @GetMapping("{id}")
    public AxiosResult selectById(@PathVariable("id") String id) {
        Sysdept obj = this.sysdeptService.selectById(id);
        return suc(obj);
    }

    //查询出部门列表,把查询结果组装成树形结构
    @GetMapping("list")
    public AxiosResult selectList(Sysdept obj) {
        List<Sysdept> list = this.sysdeptService.selectList(obj);
        List<Sysdept> tree = this.sysdeptService.createTree(list);
        return suc(tree);
    }

    @PostMapping
    public AxiosResult add(@RequestBody Sysdept obj) {
        boolean r = this.sysdeptService.add(obj);
        return result(r);
    }

    @PutMapping
    public AxiosResult update(@RequestBody Sysdept obj) {
        boolean r = this.sysdeptService.updateById(obj);
        return result(r);
    }

    @DeleteMapping("id/{id}")
    public AxiosResult delById(@PathVariable("id") String id) {
        //判断能够删除
        boolean hasChilds = sysdeptService.hasChilds(id);
        if(hasChilds)
            return error(S.HAS_CHILDS);

        //执行删除
        List<String> ids = new ArrayList<>();
        ids.add(id);
        boolean r = this.sysdeptService.delByIds(ids);
        return result(r);
    }

    @DeleteMapping("{ids}")
    public AxiosResult delByIds(@PathVariable("ids") String ids) {
        String[] split = ids.split(",");
        boolean r = this.sysdeptService.delByIds(Arrays.asList(split));
        return result(r);
    }


}
