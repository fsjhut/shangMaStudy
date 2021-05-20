package test.dao;

import test.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {
    //用户插入方法  入参 用户对象 返回值 执行成功的记录数
    int insertUser(User insertUser) throws SQLException;
    User login(User loginUser) throws SQLException;

    List<User> getAllUser() throws Exception;

    boolean existsUsername(String username);
}
