package com.javasm.sys.service.impl;

import com.javasm.sys.entity.Sysrole;
import com.javasm.sys.dao.SysroleDao;
import com.javasm.sys.service.SysroleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import com.javasm.commons.base.BaseServiceImpl;

@Service("sysroleService")
public class SysroleServiceImpl extends BaseServiceImpl<SysroleDao, Sysrole> implements SysroleService {

}
