package com.javasm.sys.handler;

import com.javasm.commons.annotation.LoggerInfo;
import com.javasm.commons.base.BaseHandler;
import com.javasm.commons.entity.AxiosResult;
import com.javasm.commons.entity.S;
import com.javasm.sys.entity.Dept;
import com.javasm.sys.service.DeptService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("dept")
public class DeptHandler extends BaseHandler {

    @Resource
    private DeptService deptService;


    @GetMapping("{id}")
    public AxiosResult selectById(@PathVariable("id") String id) {
        Integer integer = Integer.valueOf(id);
        Dept obj = this.deptService.selectById(id);
        System.out.println("obj==="+obj);


        if (obj != null) {
            return AxiosResult.suc(S.SUC, obj);
        }
        return error(S.ERROR);
    }


    @GetMapping("list/all")
    public AxiosResult selectList(Dept obj) {
        startPage();
        List<Dept> list = this.deptService.selectList(obj);
        return toTableDatas(list);
    }


    @LoggerInfo(operModul = "系统模块-部门管理", operType = "添加", operDesc = "添加部门信息")
    @PostMapping
    public AxiosResult add(@RequestBody Dept obj) {
        if (obj.getSname().equals("-1")) obj.setSname("无");
        //System.out.println("String="+obj);
        AxiosResult axiosResult = deptService.addDeptInfo(obj);

        return axiosResult;
    }

    @LoggerInfo(operModul = "系统模块-部门管理", operType = "修改", operDesc = "修改部门信息")
    @PostMapping("edit")
    public AxiosResult update(@RequestBody Dept obj) {
        if (obj.getSname().equals("-1")) obj.setSname("无");

        AxiosResult axiosResult = deptService.updateDeptInfo(obj);
        return axiosResult;

    }

    @LoggerInfo(operModul = "系统模块-部门管理", operType = "删除", operDesc = "批量删除部门信息")
    @GetMapping("delete/{ids}")
    public AxiosResult deleteById(@PathVariable("ids") String ids) {

        System.out.println("删除id=="+ids);
        Dept dept = deptService.selectById(ids);
        AxiosResult parentDept = deptService.isParentDept(dept);
        return parentDept;
    }





    //获取每个部门的人数，以及没有人的部门的树状图
    @PostMapping("userDeptno")
    public AxiosResult selectUserDeptno() {
        List<Dept> depts = deptService.selectByUserDeptno();
        List<Dept> treeDept = deptService.createTree(depts);
        //System.out.println(treeDept);
        return suc(treeDept);

    }

    //查询顶级部门
    @PostMapping("totalDept")
    public AxiosResult selectTotalDepto() {
        List<Dept> dept = getDept();
        return suc(dept);
    }

    public List<Dept> getDept() {
        Dept dept = new Dept();
        dept.setSname("无");
        List<Dept> totalDept = deptService.selectList(dept);
        return totalDept;
    }





}
