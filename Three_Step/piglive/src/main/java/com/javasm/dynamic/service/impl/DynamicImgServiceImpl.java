package com.javasm.dynamic.service.impl;

import com.javasm.dynamic.entity.DynamicImg;
import com.javasm.dynamic.dao.DynamicImgDao;
import com.javasm.dynamic.service.DynamicImgService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

@Service("dynamicImgService")
public class DynamicImgServiceImpl extends ServiceImpl<DynamicImgDao, DynamicImg> implements DynamicImgService {

}
