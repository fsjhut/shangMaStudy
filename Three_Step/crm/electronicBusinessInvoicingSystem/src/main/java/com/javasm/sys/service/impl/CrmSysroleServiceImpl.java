package com.javasm.sys.service.impl;

import com.javasm.sys.entity.CrmSysrole;
import com.javasm.sys.dao.CrmSysroleDao;
import com.javasm.sys.entity.Menu;
import com.javasm.sys.service.CrmSysroleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import com.javasm.commons.base.BaseServiceImpl;
import org.springframework.transaction.annotation.Transactional;

@Service("crmSysroleService")
public class CrmSysroleServiceImpl extends BaseServiceImpl<CrmSysroleDao, CrmSysrole> implements CrmSysroleService {

    @Transactional
    @Override
    public boolean add(CrmSysrole obj) {
        List<CrmSysrole> crmSysroles = getDao().selectList(new CrmSysrole());
        String code=null;
        for (CrmSysrole crmSysrole : crmSysroles) {
            code = String.valueOf((Integer.parseInt(crmSysrole.getRcode()))+1);
        }
        obj.setRcode(code);
        return super.add(obj);
    }

    @Override
    public List<CrmSysrole> selectAllrole(CrmSysrole r) {
        List<CrmSysrole> crmSysroles = getDao().selectAll(r);
        return crmSysroles;
    }

    @Transactional
    @Override
    public boolean insertAll(Integer rid, String createBy, List<Integer> menus) {
        int i = getDao().deleteSysroles(rid);

        int insertSysroles = getDao().insertSysroles(rid, createBy, menus);

        return insertSysroles>0?true:false;
    }

    @Override
    public Integer[] selectIds(Integer rid) {
        Integer[] integers = getDao().selectIds(rid);

        return integers;
    }
}
