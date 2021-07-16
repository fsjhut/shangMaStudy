package com.javasm.sys.service.impl;

import com.javasm.commons.base.BaseServiceImpl;
import com.javasm.sys.entity.CrmSupplier;
import com.javasm.sys.dao.CrmSupplierDao;
import com.javasm.sys.service.CrmSupplierService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (CrmSupplier)表服务实现类
 *
 * @author makejava
 * @since 2021-07-01 19:04:39
 */
@Service("crmSupplierService")
public class CrmSupplierServiceImpl extends BaseServiceImpl<CrmSupplierDao,CrmSupplier> implements CrmSupplierService {

}
