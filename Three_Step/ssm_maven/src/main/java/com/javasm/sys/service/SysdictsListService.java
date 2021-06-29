package com.javasm.sys.service;

import java.util.List;

import com.javasm.commons.base.BaseService;
import com.javasm.sys.entity.SysdictsList;

public interface SysdictsListService extends BaseService<SysdictsList> {

    List<SysdictsList> selectListByDkey(String dkey);
}
