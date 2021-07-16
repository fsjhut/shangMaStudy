package com.javasm.sys.service.impl;

import com.javasm.sys.entity.CrmArea;
import com.javasm.sys.dao.CrmAreaDao;
import com.javasm.sys.service.CrmAreaService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import com.javasm.commons.base.BaseServiceImpl;

@Service("crmAreaService")
public class CrmAreaServiceImpl extends BaseServiceImpl<CrmAreaDao, CrmArea> implements CrmAreaService {

}
