package com.javasm.sys.handler;

import com.javasm.base.BaseHandler;
import com.javasm.commons.entity.AxiosResult;
import com.javasm.sys.entity.SysdictsList;
import com.javasm.sys.service.SysdictsListService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("sysdictsList")
public class SysdictsListHandler extends BaseHandler {
    @Resource
    private SysdictsListService sysdictsListService;

    //tomcat启动时,把所有字典数据加入redis.

    //根据传入的user_sex获取到所有的性别列表数据
    @GetMapping("type/{dkey}")
    public AxiosResult getDictsByDkey(@PathVariable("dkey")String dkey){
        List<SysdictsList> sysdictsLists =  sysdictsListService.selectListByDkey(dkey);

        return suc(sysdictsLists);
    }

    @GetMapping("{id}")
    public AxiosResult selectById(@PathVariable("id") String id) {
        SysdictsList obj = this.sysdictsListService.selectById(id);
        return suc(obj);
    }

    @GetMapping("list")
    public AxiosResult selectList(SysdictsList obj) {
        startPage();
        List<SysdictsList> list = this.sysdictsListService.selectList(obj);
        return toTableDatas(list);
    }

    @PostMapping
    public AxiosResult add(@RequestBody SysdictsList obj) {
        boolean r = this.sysdictsListService.add(obj);
        return result(r);
    }

    @PutMapping
    public AxiosResult update(@RequestBody SysdictsList obj) {
        boolean r = this.sysdictsListService.updateById(obj);
        return result(r);
    }

    @DeleteMapping("{ids}")
    public AxiosResult delById(@PathVariable("ids") String ids) {
        String[] split = ids.split(",");
        boolean r = this.sysdictsListService.delByIds(Arrays.asList(split));
        return result(r);
    }
}
