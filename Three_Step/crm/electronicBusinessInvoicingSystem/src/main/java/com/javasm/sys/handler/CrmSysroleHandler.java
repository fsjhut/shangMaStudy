package com.javasm.sys.handler;

import com.javasm.commons.entity.S;
import com.javasm.commons.utils.CurrentLoginUser;
import com.javasm.sys.entity.CrmSysrole;
import com.javasm.sys.entity.CrmSysuser;
import com.javasm.sys.entity.Menu;
import com.javasm.sys.service.CrmSysroleService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import com.javasm.commons.base.BaseHandler;
import com.javasm.commons.entity.AxiosResult;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("crmSysrole")
public class CrmSysroleHandler extends BaseHandler {

    @Resource
    private CrmSysroleService crmSysroleService;

    @GetMapping("{id}")
    public AxiosResult selectById(@PathVariable("id") String id) {
        CrmSysrole obj = this.crmSysroleService.selectById(id);
        return suc(obj);
    }

    @GetMapping("list")
    public AxiosResult selectAll(CrmSysrole obj) {
//        startPage();
        List<CrmSysrole> list = this.crmSysroleService.selectList(obj);
        return toTableDatas(list);
    }

    @PostMapping
    public AxiosResult add(@RequestBody CrmSysrole obj) {

        boolean r = this.crmSysroleService.add(obj);
        return result(r);
    }

    @PutMapping
    public AxiosResult update(@RequestBody CrmSysrole obj) {
        boolean r = this.crmSysroleService.updateById(obj);
        return result(r);
    }

    @DeleteMapping("{ids}")
    public AxiosResult delById(@PathVariable("ids") String ids) {
        String[] split = ids.split(",");
        boolean r = this.crmSysroleService.delByIds(Arrays.asList(split));
        return result(r);
    }
    @GetMapping("all")
    public AxiosResult queryAll(CrmSysrole r){
        startPage();
        List<CrmSysrole> crmSysroles = this.crmSysroleService.selectAllrole(r);

        return toTableDatas(crmSysroles);
    }
    @PutMapping("insertpers")
    public AxiosResult insertAll(Integer rid,@RequestBody Integer[] menuids){
        CrmSysuser loginUser = CurrentLoginUser.getLoginUser();
        List<Integer> list = Arrays.asList(menuids);
        boolean insertAll = this.crmSysroleService.insertAll(rid, loginUser.getUname(),list);

        return result(insertAll);
    }
    @GetMapping("selectIds")
    public AxiosResult selectIds(Integer rid){
        Integer[] integers = this.crmSysroleService.selectIds(rid);
        AxiosResult x = new AxiosResult();
        x.setCode(S.SUC.getCode());
        x.setMsg(suc().getMsg());
        x.setData(integers);
        return x;
    }


}
