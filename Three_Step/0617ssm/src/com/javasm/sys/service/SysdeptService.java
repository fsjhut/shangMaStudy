package com.javasm.sys.service;

import com.javasm.sys.entity.Sysdept;

import java.util.List;

import com.javasm.commons.base.BaseService;

public interface SysdeptService extends BaseService<Sysdept> {
    List<Sysdept> createTree(List<Sysdept> list);

    boolean hasChilds(String id);
}
