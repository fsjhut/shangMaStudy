package com.javasm.sys.service.impl;


import com.javasm.commons.base.BaseServiceImpl;
import com.javasm.commons.entity.AxiosResult;
import com.javasm.commons.entity.S;
import com.javasm.sys.dao.CrmSysuserDao;
import com.javasm.sys.dao.DeptDao;
import com.javasm.sys.entity.CrmSysuser;
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
    private CrmSysuserDao sysuserDao;


    @Override
    public List<Dept> selectByUserDeptno() {
        List<Dept> depts = getDao().selectByUserDeptno();
        return depts;
    }


    @Override
    public AxiosResult isParentDept(Dept dept) {
        //获取该查询的部门对象
        List<Dept> depts1 = getDao().selectList(dept);
        Dept dept1 = depts1.get(0);
        //获取该部门的部门名称
        String dname = dept1.getDname();
        //获取该部门的部门编号
        Integer deptno1 = dept1.getDeptno();

        //获取所有部门
        List<Dept> depts = getDao().selectList(null);
        for (Dept d : depts) {
            String sname = d.getSname();
            //判断该部门是否有下级部门
            if (dname.equals(sname)) {
                return AxiosResult.error(S.SON_ERROR);
            }
        }

        //获取所有员工对象，判断该部门下是否存在员工，如果存在，则无法删除。
        List<CrmSysuser> crmSysusers = sysuserDao.selectList(null);
        for (CrmSysuser crmSysuser : crmSysusers) {
            //遍历所有员工，得到每一个员工的部门编号，与要删除的部门编号进行equals
            Integer deptno = crmSysuser.getDeptno();

            if (deptno.equals(deptno1)) {
                return AxiosResult.error(S.ELEYOO_ERROR);
            }
        }

        //都满足以上条件才能删除
        int i = getDao().delById(Integer.toString(dept.getId()));
        if (i > 0) {
            return AxiosResult.suc(S.SUC);
        }

        return AxiosResult.error(S.ERROR);
    }

    @Override
    public AxiosResult updateDeptInfo(Dept obj) {

        int add = getDao().updateById(obj);
        if (add > 0) {
            return AxiosResult.suc(S.MODIFY_SUC);
        }

        return AxiosResult.error(S.MODIFY_ERROR2);

//        //获取修改的部门名称
//        Dept dnames = new Dept();
//        dnames.setDname(obj.getDname());
//
//        List<Dept> dList = dao.selectList(dnames);
//        //Dept dept = dList.get(0);
//
//        if (dList.size() == 1) {
//            return AxiosResult.error(S.MODIFY_ERROR2);
//        }
//
//
//        int add = dao.updateById(obj);


        //判断修改的部门是否是同一个部门

        //不修改部门名称，修改其他
//        if (dept!=null && obj.getId().equals(dept.getId())) {
//
//
//
//
//        }

        //修改部门名称
//        if (dList.size()>0) {
//            int add = dao.updateById(obj);
//            if (add > 0) {
//                return AxiosResult.suc(S.MODIFY_SUC);
//            }
//            return AxiosResult.suc(S.MODIFY_ERROR);
//        }


    }

    @Override
    public AxiosResult addDeptInfo(Dept obj) {
        //获取添加的部门名称
        Dept dnames = new Dept();
        dnames.setDname(obj.getDname());

        //获取添加的部门编号
        Dept deptNo = new Dept();
        deptNo.setDeptno(obj.getDeptno());

        List<Dept> dnamesList = getDao().selectList(dnames);
        List<Dept> deptNoList = getDao().selectList(deptNo);

        if (dnamesList.size() > 0 || deptNoList.size() > 0) {
            return AxiosResult.error(S.DEPTNO_DNAME_EXISTS);
        }

        int add = getDao().add(obj);
        if (add > 0) {
            return AxiosResult.suc(S.ADD_SUC);
        }
        return AxiosResult.error();


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

        List<Dept> t = tree(dName, parentName);

        return t;
    }

    //1启用，0未启用
    private List<Dept> tree(List<Dept> dName, Set<String> parentName) {
        List<Dept> result = new ArrayList<>();
        for (Dept dept : dName) {
            String sname = dept.getSname();
            if (parentName.contains(sname)) {
                List<Dept> c = chils(dName, dept.getDname());
                if (c.size() > 0) {
                    dept.setDeptList(c);
                }

                if (dept.getIsEnabled().equals("1")){
                    result.add(dept);
                }
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

                if (dept.getIsEnabled().equals("1")){
                    childs.add(dept);
                }


            }

        }
        return childs;
    }


}
