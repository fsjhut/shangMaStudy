package com.javasm.sys.service.impl;

import com.javasm.sys.entity.SysdictsList;
import com.javasm.sys.dao.SysdictsListDao;
import com.javasm.sys.service.SysdictsListService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import com.javasm.commons.base.BaseServiceImpl;

@Service("sysdictsListService")
public class SysdictsListServiceImpl extends BaseServiceImpl<SysdictsListDao, SysdictsList> implements SysdictsListService {

}
