package com.javasm.sys.service.impl;

import com.javasm.sys.entity.Syspermission;
import com.javasm.sys.dao.SyspermissionDao;
import com.javasm.sys.service.SyspermissionService;
import org.springframework.stereotype.Service;
import com.javasm.commons.base.BaseServiceImpl;

@Service("syspermissionService")
public class SyspermissionServiceImpl extends BaseServiceImpl<SyspermissionDao, Syspermission> implements SyspermissionService {

}
