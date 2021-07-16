
package com.javasm.sys.handler;

import com.javasm.commons.utils.CurrentLoginUser;
import com.javasm.commons.utils.JJWTUtil;
import com.javasm.sys.entity.CrmSysuser;
import com.javasm.sys.entity.Sysuser;
import com.javasm.sys.service.CrmSysuserService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import com.javasm.commons.base.BaseHandler;
import com.javasm.commons.entity.AxiosResult;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("sysuser")
public class CrmSysuserHandler extends BaseHandler {

    @Resource
    private CrmSysuserService crmSysuserService;

    @GetMapping("{id}")
    public AxiosResult selectById(@PathVariable("id") String id) {
        CrmSysuser obj = this.crmSysuserService.selectById(id);
        return suc(obj);
    }

    @GetMapping("list")
    public AxiosResult selectAll(CrmSysuser obj) {
        List<CrmSysuser> list = this.crmSysuserService.selectList(obj);
        return suc(list);
    }

    @PostMapping
    public AxiosResult add(@RequestBody CrmSysuser obj) {
        boolean r = this.crmSysuserService.add(obj);
        return result(r);
    }

    @PutMapping
    public AxiosResult update(@RequestBody CrmSysuser obj) {
        boolean r = this.crmSysuserService.updateById(obj);
        return result(r);
    }

    @DeleteMapping("del/{id}")
    public AxiosResult deleteById(@PathVariable("id") String id) {
        boolean delById = this.crmSysuserService.delById(id);
        return result(delById);
    }

    @DeleteMapping("{ids}")
    public AxiosResult delById(@PathVariable("ids") String ids) {
        String[] split = ids.split(",");
        boolean r = this.crmSysuserService.delByIds(Arrays.asList(split));
        return result(r);
    }

    @PostMapping("login")
    public ResponseEntity startLogin(@RequestBody CrmSysuser u) {
        boolean login = crmSysuserService.login(u);
        if (!login) {
            return new ResponseEntity(AxiosResult.loginout(), HttpStatus.OK);
        }
        String token = JJWTUtil.generate(u.getUname());
        System.out.println(token);
        HttpHeaders headers = new HttpHeaders();
        headers.add("token", token);
        return new ResponseEntity(AxiosResult.loginok(), headers, HttpStatus.OK);
    }

    @GetMapping("all")
    public AxiosResult queryAll(CrmSysuser u) {
        startPage();
        List<CrmSysuser> list = this.crmSysuserService.queryAll(u);
        return toTableDatas(list);
    }

    @GetMapping("forbidden/{id}")
    public AxiosResult editstate(@PathVariable("id") String id) {
        boolean editState = this.crmSysuserService.editState(id);
        return result(editState);
    }

    @GetMapping("open/{id}")
    public AxiosResult openstate(@PathVariable("id") String id) {
        boolean openState = this.crmSysuserService.openState(id);
        return result(openState);
    }

    @GetMapping("loginUser")
    public AxiosResult getloginUser() {
        CrmSysuser loginUser = CurrentLoginUser.getLoginUser();
        if (loginUser == null) {
            return error();
        } else {
            return suc(loginUser.getUjob());
        }
    }
}











