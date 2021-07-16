package com.javasm.sys.service;

import com.javasm.sys.entity.Sysuser;

public interface SysuserService {

    Sysuser selectByUphone(String uphone);

    void updateUserByPhone(Sysuser u);

    void sendValicode(String uphone);
}
