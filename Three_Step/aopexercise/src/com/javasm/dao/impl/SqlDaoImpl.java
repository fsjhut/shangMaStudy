package com.javasm.dao.impl;


import com.javasm.controller.CurrentThreadConnection;
import com.javasm.dao.SqlDao;
import com.javasm.entity.SysUser;
import com.javasm.utils.JDBCUtil;
import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.GenerousBeanProcessor;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * @className: SqlDaoImpl
 * @description:   
 * @author SunHang
 * @createTime 2021/6/11 19:17
 */
@Repository
public class SqlDaoImpl implements SqlDao<SysUser> {

    private PreparedStatement ps;
    private String sqlStr;
    @Resource
    private DataSource dataSource;

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public int addObj(SysUser sysUser) throws SQLException {
        sqlStr = "insert into sysuser (uname,upwd) values (?,?)";
        ps = CurrentThreadConnection.getConnection().prepareStatement(sqlStr);
        ps.setString(1, sysUser.getUname());
        ps.setString(2, sysUser.getUpwd());
        System.out.println("核心添加程序");
        return ps.executeUpdate();
    }

    @Override
    public int delObj(int id) throws SQLException {
        sqlStr = "delete from sysuser where id=?";
        ps = CurrentThreadConnection.getConnection().prepareStatement(sqlStr);
        ps.setInt(1,id);
        System.out.println("核心删除程序");
        return ps.executeUpdate();
    }

    @Override
    public int updateObj(SysUser sysUser) throws SQLException {
        sqlStr = "update sysuser set uname=?,upwd=? where id=? ";
        ps = CurrentThreadConnection.getConnection().prepareStatement(sqlStr);
        ps.setString(1,sysUser.getUname());
        ps.setString(2,sysUser.getUpwd());
        ps.setInt(3,sysUser.getUid());
        System.out.println("核心更新程序");
        return ps.executeUpdate();
    }

    @Override
    public SysUser selectById(int id) throws SQLException {
        sqlStr="select uid,uname,upwd from sysuser where uid=?";
        return new QueryRunner(dataSource).query(sqlStr,
                new BeanHandler<>(SysUser.class, new BasicRowProcessor(new GenerousBeanProcessor())), id);

    }

    @Override
    public List<SysUser> selectList() throws SQLException {
        sqlStr="select uid,uname,upwd from sysuser";
        return new QueryRunner(dataSource).query(sqlStr,
                new BeanListHandler<>(SysUser.class, new BasicRowProcessor(new GenerousBeanProcessor())));
    }
}
