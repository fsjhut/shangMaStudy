package com.javasm.sys.handler;


import com.javasm.commons.base.BaseHandler;
import com.javasm.commons.entity.AxiosResult;
import com.javasm.sys.entity.Dept;
import com.javasm.sys.service.DeptService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("dept")
public class DeptHandler extends BaseHandler {

    @Resource
    private DeptService deptService;

    @GetMapping("{id}")
    public AxiosResult selectById(@PathVariable("id") String id) {
        Dept obj = this.deptService.selectById(id);
        return suc(obj);
    }

    @GetMapping("list")
    public AxiosResult selectList(Dept obj) {
        startPage();
        List<Dept> list = this.deptService.selectList(obj);
        return toTableDatas(list);
    }

    @PostMapping
    public AxiosResult add(@RequestBody Dept obj) {
        boolean r = this.deptService.add(obj);
        //System.out.println("obj=="+obj);
        return result(r);
    }

    @PutMapping
    public AxiosResult update(@RequestBody Dept obj) {
        boolean r = this.deptService.updateById(obj);
        return result(r);
    }

    @DeleteMapping("{ids}")
    public AxiosResult delById(@PathVariable("ids") String ids) {
        String[] split = ids.split(",");
        boolean r = this.deptService.delByIds(Arrays.asList(split));
        return result(r);
    }


    //获取每个部门的人数，以及没有人的部门的树状图
    @GetMapping("userDeptno")
    public AxiosResult selectUserDeptno() {
        List<Dept> depts = deptService.selectByUserDeptno();
        List<Dept> treeDept = deptService.createTree(depts);
        System.out.println(treeDept);
        return suc(treeDept);

    }


}
