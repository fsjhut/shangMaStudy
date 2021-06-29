package com.javasm.sys.service.impl;

import com.javasm.sys.entity.Sysuser;
import com.javasm.sys.dao.SysuserDao;
import com.javasm.sys.service.SysuserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import com.javasm.commons.base.BaseServiceImpl;

@Service("sysuserService")
public class SysuserServiceImpl extends BaseServiceImpl<SysuserDao, Sysuser> implements SysuserService {
    @Override
    public List<Sysuser> selectUserAndDeptList(Sysuser obj) {
        return dao.selectUserAndDept(obj);
    }

    @Override
    public Sysuser selectByUname(String uname) {
        Sysuser u = new Sysuser();
        u.setUname(uname);
        List<Sysuser> sysusers = super.selectList(u);
        if(sysusers.size()==1) {
            return sysusers.get(0);
        }

        return null;
    }

    @Override
    public boolean comparePwd(String upwd, String upwd1) {
        if(upwd==null || upwd1==null) {
            return false;
        }
        return upwd.equals(upwd1);
    }
}
