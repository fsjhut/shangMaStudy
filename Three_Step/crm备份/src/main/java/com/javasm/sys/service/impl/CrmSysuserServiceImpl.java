package com.javasm.sys.service.impl;

import com.alibaba.fastjson.JSON;
import com.javasm.commons.cache.Keys;
import com.javasm.commons.cache.RedisService;
import com.javasm.sys.entity.CrmSysuser;
import com.javasm.sys.dao.CrmSysuserDao;
import com.javasm.sys.service.CrmSysuserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import com.javasm.commons.base.BaseServiceImpl;

@Service("crmSysuserService")
public class CrmSysuserServiceImpl extends BaseServiceImpl<CrmSysuserDao, CrmSysuser> implements CrmSysuserService {
    @Resource
    private RedisService rs;

    @Override
    public boolean login(CrmSysuser u) {
        List<CrmSysuser> sysusers = getDao().selectList(new CrmSysuser());
        for (CrmSysuser sysuser : sysusers) {
            if (sysuser.getUname().equals(u.getUname())&&sysuser.getUpassword().equals(u.getUpassword())){

                rs.hset(Keys.USERS_HASH,u.getUname(),JSON.toJSONString(sysuser));
                return true;
            }
        }
        return false;
    }
}
