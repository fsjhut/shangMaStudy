package com.javasm.sys.service.impl;

import com.javasm.sys.entity.B2cReturnForm;
import com.javasm.sys.dao.B2cReturnFormDao;
import com.javasm.sys.service.B2cReturnFormService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import com.javasm.commons.base.BaseServiceImpl;

@Service("b2cReturnFormService")
public class B2cReturnFormServiceImpl extends BaseServiceImpl<B2cReturnFormDao, B2cReturnForm> implements B2cReturnFormService {

}
