package com.javasm.service.impl;

import com.javasm.dao.UserDao;
import com.javasm.dao.impl.UserDaoImpl;
import com.javasm.entity.MyUser;
import com.javasm.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    @Override
    public int insertUser(MyUser insertUser) {
        /*
        * 业务逻辑
        *
        * 1.得到的数据 与最终操作的数据不同(格式  数据内容不同)
        * 2.组织和调用不同的dao  最小数据操作粒度
        * */

        UserDao ud = new UserDaoImpl();
        //业务逻辑
        insertUser.setUphone("(+86)"+insertUser.getUphone());
        return ud.insertUser(insertUser);
    }

    @Override
    public MyUser login(MyUser loginUser) {
        UserDao ud = new UserDaoImpl();
        return ud.login(loginUser);
    }

    @Override
    public List<MyUser> getAllUser() {
        UserDao ud = new UserDaoImpl();
        return ud.getAllUser();
    }
}
