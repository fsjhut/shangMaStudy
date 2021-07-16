package com.javasm.sys.service.impl;

import com.javasm.commons.base.BaseServiceImpl;
import com.javasm.sys.dao.LogDao;
import com.javasm.sys.entity.Log;
import com.javasm.sys.service.LogService;
import org.springframework.stereotype.Service;

@Service("logService")
public class LogServiceImpl extends BaseServiceImpl<LogDao, Log> implements LogService {

}
