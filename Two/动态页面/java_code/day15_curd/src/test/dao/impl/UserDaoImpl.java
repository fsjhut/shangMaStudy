package test.dao.impl;



import test.dao.UserDao;
import test.entity.MyProduct;
import test.entity.MyUser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl extends BaseDaoImpl<MyUser> implements UserDao {
    private String sql;
    @Override
    public List<MyUser> getAllUser() throws Exception {
        sql = "select uid,uname,uphone,uemail,uremark from tb_user ";
        return queryList(sql);
    }

    @Override
    public int insertUser(MyUser insertUser) throws SQLException {
        sql = "insert into tb_user(uid,uname,upwd,uphone,uemail,uremark) VALUES (?,?,?,?,?,?)";
        return update(sql,insertUser.getUid(),insertUser.getUname(),insertUser.getUpwd(),
                insertUser.getUphone(), insertUser.getUmail(),insertUser.getUremark());
    }

    @Override
    public MyUser login(MyUser loginUser) throws SQLException {
        String sql = "select tu.uid,tu.uname,tu.uphone,tu.uemail,tu.uremark from tb_user tu " +
                "WHERE tu.uname = ? and tu.upwd = ? ";
        return queryOne(sql, loginUser.getUname(),loginUser.getUpwd());
    }
}
