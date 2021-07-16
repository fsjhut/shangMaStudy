package com.javasm.dept.service.impl;

import com.javasm.dept.entity.Sysdept;
import com.javasm.dept.dao.SysdeptDao;
import com.javasm.dept.service.SysdeptService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

@Service("sysdeptService")
public class SysdeptServiceImpl extends ServiceImpl<SysdeptDao, Sysdept> implements SysdeptService {

}
