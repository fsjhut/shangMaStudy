package com.javasm.sys.service.impl;

import com.javasm.sys.entity.BrandManager;
import com.javasm.sys.dao.BrandManagerDao;
import com.javasm.sys.service.BrandManagerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import com.javasm.commons.base.BaseServiceImpl;

@Service("brandManagerService")
public class BrandManagerServiceImpl extends BaseServiceImpl<BrandManagerDao, BrandManager> implements BrandManagerService {

}
