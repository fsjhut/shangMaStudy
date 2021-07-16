package com.javasm.sys.service;

import com.javasm.sys.entity.Ver;

import java.util.List;
import java.util.Map;

import com.javasm.commons.base.BaseService;
import org.apache.poi.ss.formula.functions.T;

public interface VerService extends BaseService<Ver> {

    boolean adds(Map map) throws Exception;
    boolean add(Map map);

    boolean auditMultistage(Map map ) throws Exception;

}
