package com.test.dao.impl;

import com.test.dao.UserDao;
import com.test.entity.MyUser;
import com.test.utils.DBUtil;
import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.GenerousBeanProcessor;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;


import java.sql.SQLException;
import java.util.List;

/**
 * @className: UserDaoImpl
 * @description:   
 * @author SunHang
 * @createTime 2021/5/10 16:31
 */
public class UserDaoImpl implements UserDao {

    private String sql;
    @Override
    public MyUser login(MyUser loginUser) throws SQLException {
//        <td>名字</td>
//				<td>手机号</td>
//				<td>邮箱</td>
//				<td>生日</td>
//				<td>地址</td>
        sql = "select u.name,u.phone,u.email,u.birth,u.area_detail from `user` as u where u.name=? and u.password=?";
        return new QueryRunner(DBUtil.getDataSource()).query(sql,
                new BeanHandler<>(MyUser.class, new BasicRowProcessor(new GenerousBeanProcessor())),
                loginUser.getName(),loginUser.getPassWord());
    }

    @Override
    public List<MyUser> getAllUser() throws SQLException {
//        sql = "select u.name,u.phone,u.email,u.birth,u.area_detail from `user` as u ";
        sql = "select * from `user` as u ";
        return new QueryRunner(DBUtil.getDataSource())
                .query(sql, new BeanListHandler<>(MyUser.class,
                        new BasicRowProcessor(new GenerousBeanProcessor())));
    }
}
