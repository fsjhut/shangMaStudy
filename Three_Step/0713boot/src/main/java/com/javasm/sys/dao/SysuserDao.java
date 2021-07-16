package com.javasm.sys.dao;

import com.javasm.sys.entity.Sysuser;

import java.util.List;

public interface SysuserDao{
    List<Sysuser> selectList(Sysuser u);
    int updateByPhone(Sysuser u);
}

