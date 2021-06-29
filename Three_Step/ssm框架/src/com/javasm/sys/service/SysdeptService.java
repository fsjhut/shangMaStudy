package com.javasm.sys.service;

import java.util.List;

import com.javasm.commons.base.BaseService;
import com.javasm.sys.entity.Sysdept;

public interface SysdeptService extends BaseService<Sysdept> {
    List<Sysdept> createTree(List<Sysdept> list);

    boolean hasChilds(String id);
}
