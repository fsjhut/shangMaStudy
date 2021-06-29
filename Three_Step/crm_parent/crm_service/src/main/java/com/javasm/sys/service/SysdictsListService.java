package com.javasm.sys.service;

import com.javasm.base.BaseService;
import com.javasm.sys.entity.SysdictsList;

import java.util.List;

public interface SysdictsListService extends BaseService<SysdictsList> {

    List<SysdictsList> selectListByDkey(String dkey);
}
