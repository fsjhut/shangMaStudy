package com.javasm.sys.service.impl;

import com.javasm.sys.entity.GoodsSupplier;
import com.javasm.sys.dao.GoodsSupplierDao;
import com.javasm.sys.service.GoodsSupplierService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import com.javasm.commons.base.BaseServiceImpl;

@Service("goodsSupplierService")
public class GoodsSupplierServiceImpl extends BaseServiceImpl<GoodsSupplierDao, GoodsSupplier> implements GoodsSupplierService {

}
