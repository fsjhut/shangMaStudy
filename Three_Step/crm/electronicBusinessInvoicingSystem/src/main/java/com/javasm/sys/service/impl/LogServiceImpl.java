package com.javasm.sys.service.impl;


import com.javasm.commons.base.BaseServiceImpl;
import com.javasm.sys.dao.CrmSysuserDao;
import com.javasm.sys.dao.DeptDao;
import com.javasm.sys.dao.LogDao;
import com.javasm.sys.entity.CrmSysuser;
import com.javasm.sys.entity.Dept;
import com.javasm.sys.entity.Log;
import com.javasm.sys.service.LogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service("logService")
public class LogServiceImpl extends BaseServiceImpl<LogDao, Log> implements LogService {



    @Resource
    private CrmSysuserDao crmSysuserDao;

    @Resource
    private DeptDao deptDao;

    @Override
    public List<Log> filterRepeatModule(List<Log> list) {
        Set set = new HashSet();
        List<Log> listModules = new ArrayList<>();

        for (Log log : list) {
            String accessmodule = log.getAccessmodule();
            set.add(accessmodule);
        }
        System.out.println("set=>" + set);

        for (Object o : set) {
            Log log = new Log();
            log.setAccessmodule((String) o);
            listModules.add(log);
        }
//        Set<Log> set = new HashSet<>();
//        for (Log log : list) {
//            set.add(log);
//        }
//
//        System.out.println("set==>"+set);
//        List<Log> listModules = new ArrayList<>();
//        listModules.addAll(set);
//        System.out.println("listModules==>"+listModules);


        return listModules;
    }


    @Override
    public List<Log> selectByKeyWords(String keyWord) {
        List<Log> logs = getDao().selectByKeyWords(keyWord);
        return logs;
    }

    @Override
    public List<Log> selectManyTerm(Log log) {
        List<Log> logs = getDao().selectManyTerm(log);
        return logs;
    }

//    @Override
//    public List<Log> selectManyTerm2(Log log) {
//
////        if (log.getId() == null) {
////            log.setId();
////        }
////        if (log.getId() == null) {
////            log.setId();
////        }
////        if (log.getId() == null && log.getAccesstype()==null && log.get) {
////            List<Log> logs = dao.selectManyTerm(log);
////            return logs;
////        }
//
//        List<Log> logsList = new ArrayList<>();
//
////        //都为null就查所有
////        if (log == null) {
////            List<Log> logs = dao.selectManyTerm(log);
////            return logs;
////        }
//
//
//        if (log.getAccessuser() == null && log.getRealUserName() != null) {
//            //登录名为null，并且用户真实名不为null,查用户的真实名
//            CrmSysuser sysuser = new CrmSysuser();
//            sysuser.setRealname(log.getRealUserName());
//            //查询用户的真实名称下有哪些登录名
//            List<CrmSysuser> crmSysusers = crmSysuserDao.selectList(sysuser);
//            for (CrmSysuser crmSysuser : crmSysusers) {
//                //把得到的每一个登录名封装到Log对象中的accesssuer属性上
//                String uname = crmSysuser.getUname();
//                log.setAccessuser(uname);
//                //查询到的每一个结果
//                List<Log> logs = dao.selectManyTerm(log);
//                if (logs.size() > 0) logsList.add(logs.get(0));
//                return logsList;
//            }
//
//
//        }
//
//        //用户真实名为null，登录名不为null，或者登录名，真实名都为null
//        if ((log.getRealUserName() == null && log.getAccessuser() != null) ||
//                log.getRealUserName() == null && log.getRealUserName() == null) {
//
//            //直接查询
//            List<Log> logs = dao.selectManyTerm(log);
//            return logs;
//
//        }
//
//
//        return null;
//
//
//    }

    @Override
    public List<Log> filterOperatorcontent(List<Log> list) {
        Set set = new HashSet();
        List<Log> listModules = new ArrayList<>();

        for (Log log : list) {
            String operatingcontents = log.getOperatingcontents();
            set.add(operatingcontents);
        }

        for (Object o : set) {
            Log log = new Log();
            log.setOperatingcontents((String) o);
            listModules.add(log);
        }
        //System.out.println("list==》"+listModules);
        return listModules;
    }

    @Override
    public List<Log> filterDeptNames(List<Log> list) {
        Set set = new HashSet();
        List<Log> listModules = new ArrayList<>();
        List<Log> deptList = new ArrayList<>();

        for (Log log : list) {
            String accessuser = log.getAccessuser();
            set.add(accessuser);
        }

        for (Object o : set) {
            Log log = new Log();
            log.setAccessuser((String) o);
            listModules.add(log);
        }

        for (Log listModule : listModules) {
            CrmSysuser user = new CrmSysuser();
            user.setUname(listModule.getAccessuser());
            List<CrmSysuser> crmSysusers = crmSysuserDao.selectList(user);
            for (CrmSysuser crmSysuser : crmSysusers) {
                Integer deptno = crmSysuser.getDeptno();
                Dept dept = new Dept();
                dept.setDeptno(deptno);
                List<Dept> depts = deptDao.selectList(dept);
                for (Dept dept1 : depts) {
                    //拿到部门名称
                    String dname = dept1.getDname();
                    Log log = new Log();
                    log.setDeptName(dname);
                    deptList.add(log);

                }

            }
        }

        return deptList;
    }
}
