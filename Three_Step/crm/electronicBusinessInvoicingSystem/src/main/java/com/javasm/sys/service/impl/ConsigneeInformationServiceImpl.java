package com.javasm.sys.service.impl;

import com.javasm.sys.entity.ConsigneeInformation;
import com.javasm.sys.dao.ConsigneeInformationDao;
import com.javasm.sys.service.ConsigneeInformationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import com.javasm.commons.base.BaseServiceImpl;

@Service("consigneeInformationService")
public class ConsigneeInformationServiceImpl extends BaseServiceImpl<ConsigneeInformationDao, ConsigneeInformation> implements ConsigneeInformationService {

}
