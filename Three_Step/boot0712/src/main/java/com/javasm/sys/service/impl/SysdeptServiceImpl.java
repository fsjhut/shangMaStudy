package com.javasm.sys.service.impl;

import com.javasm.sys.entity.Sysdept;
import com.javasm.sys.dao.SysdeptDao;
import com.javasm.sys.service.SysdeptService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("sysdeptService")
public class SysdeptServiceImpl implements SysdeptService {

    @Resource
    private SysdeptDao dd;

    @Transactional
    @Override
    public Sysdept selectById(String did) {
        return dd.selectById(did);
    }
}
