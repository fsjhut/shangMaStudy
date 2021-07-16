package com.javasm.sys.dao;


import com.javasm.sys.entity.Sysdept;

import java.util.List;

public interface SysdeptDao {
    Sysdept selectById(String deptid);

    List<Sysdept> selectList();
}

