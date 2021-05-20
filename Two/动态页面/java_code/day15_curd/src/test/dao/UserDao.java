package test.dao;

import test.entity.MyUser;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {
    //用户插入方法  入参 用户对象 返回值 执行成功的记录数
    int insertUser(MyUser insertUser) throws SQLException;
    MyUser login(MyUser loginUser) throws SQLException;

    List<MyUser> getAllUser() throws Exception;

}
