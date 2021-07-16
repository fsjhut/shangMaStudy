package com.javasm.sys.handler;

import com.alibaba.fastjson.JSON;
import com.javasm.commons.cache.RedisService;
import com.javasm.commons.utils.DataProcessUtil;
import com.javasm.sys.entity.CrmArea;
import com.javasm.sys.service.CrmAreaService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import com.javasm.commons.base.BaseHandler;
import com.javasm.commons.entity.AxiosResult;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("crmArea")
public class CrmAreaHandler extends BaseHandler {

    @Resource
    private CrmAreaService crmAreaService;
    @Resource
    private RedisService rs;

    @GetMapping("{id}")
    public AxiosResult selectById(@PathVariable("id") String id) {
        CrmArea obj = this.crmAreaService.selectById(id);
        return suc(obj);
    }

    @GetMapping("list")
    public AxiosResult selectList(CrmArea obj) {

        List<CrmArea> list = this.crmAreaService.selectList(obj);
        return toTableDatas(list);
    }

    @GetMapping("all")
    public AxiosResult allArea(CrmArea obj) {
        String allArea = rs.get("allArea");
        if (allArea==null) {
            List<CrmArea> list = this.crmAreaService.selectList(obj);
            Object areas = DataProcessUtil.getAreas(list);
            return suc(areas);
        }
        Object parse = JSON.parse(allArea);
        return suc(parse);
    }

    @PostMapping
    public AxiosResult add(@RequestBody CrmArea obj) {
        boolean r = this.crmAreaService.add(obj);
        return result(r);
    }

    @PutMapping
    public AxiosResult update(@RequestBody CrmArea obj) {
        boolean r = this.crmAreaService.updateById(obj);
        return result(r);
    }

    @DeleteMapping("{ids}")
    public AxiosResult delById(@PathVariable("ids") String ids) {
        String[] split = ids.split(",");
        boolean r = this.crmAreaService.delByIds(Arrays.asList(split));
        return result(r);
    }





}
