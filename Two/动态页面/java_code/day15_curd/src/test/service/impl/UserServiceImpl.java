package test.service.impl;


import test.dao.UserDao;
import test.dao.impl.UserDaoImpl;
import test.entity.MyUser;
import test.service.UserService;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {

    @Override
    public Integer insertUser(MyUser insertUser) {
        /*
        * 业务逻辑
        *
        * 1.得到的数据 与最终操作的数据不同(格式  数据内容不同)
        * 2.组织和调用不同的dao  最小数据操作粒度
        * */
        UserDao ud = new UserDaoImpl();
        //业务逻辑
        insertUser.setUphone("(+86)"+insertUser.getUphone());
        try {
            return ud.insertUser(insertUser);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public MyUser login(MyUser loginUser) {
        UserDao ud = new UserDaoImpl();
        try {
            return ud.login(loginUser);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<MyUser> getAllUser() {
        UserDao ud = new UserDaoImpl();
        try {
            return ud.getAllUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
