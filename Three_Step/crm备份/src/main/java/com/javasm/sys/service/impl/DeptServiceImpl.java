package com.javasm.sys.service.impl;

import com.javasm.commons.base.BaseServiceImpl;
import com.javasm.sys.dao.DeptDao;
import com.javasm.sys.entity.Dept;
import com.javasm.sys.service.DeptService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service("DeptService")
public class DeptServiceImpl extends BaseServiceImpl<DeptDao, Dept> implements DeptService {

    @Resource
    private DeptDao dao;

    @Override
    public List<Dept> selectByUserDeptno() {
        List<Dept> depts = dao.selectByUserDeptno();
        return depts;
    }

    @Override
    public List<Dept> createTree(List<Dept> dName) {
        Set<String> parentName = new HashSet<>();//存放父级别名称
        List<String> ids = new ArrayList<>(); //存放所有部门名称

        for (Dept dept : dName) {
            String dname = dept.getDname();
            ids.add(dname);
            parentName.add(dept.getSname());
        }

        //获取顶级父名称
        parentName.removeAll(ids);

        List<Dept> t = tree(dName,parentName);

        return t;
    }

    private List<Dept> tree(List<Dept> dName, Set<String> parentName) {
        List<Dept> result = new ArrayList<>();
        for (Dept dept : dName) {
            String sname = dept.getSname();
            if (parentName.contains(sname)) {
                List<Dept> c = chils(dName, dept.getDname());
                if (c.size() > 0) {
                    dept.setDeptList(c);
                }

                result.add(dept);
            }


        }
        return result;
    }

    private List<Dept> chils(List<Dept> dName, String sname) {
        List<Dept> childs = new ArrayList<>();
        for (Dept dept : dName) {
            if (dept.getSname().equals(sname)) {
                List<Dept> c = chils(dName, dept.getDname());
                if (c.size() > 0) {
                    dept.setDeptList(c);
                }

                childs.add(dept);

            }

        }
        return childs;
    }
}
