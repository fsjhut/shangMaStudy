package com.javasm.sys.service;

import com.javasm.commons.base.BaseService;
import com.javasm.sys.entity.Sysuser;

import java.util.List;

public interface SysuserService extends BaseService<Sysuser> {

    Sysuser selectByUname(String uname);

    boolean comparePwd(String upwd, String upwd1);

    String sendValicode(String uphone, String s);

    Boolean compareValiecode(String uphone, String code);

    Sysuser selectUserByPhone(String uphone);

    Sysuser registUser(String uphone);

    List<Sysuser> selectUserAndDeptList(Sysuser obj);
}
