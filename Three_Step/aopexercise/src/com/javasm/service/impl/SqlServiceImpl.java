package com.javasm.service.impl;

import com.javasm.annotation.an;
import com.javasm.dao.SqlDao;
import com.javasm.entity.SysUser;
import com.javasm.service.SqlService;
import com.javasm.utils.JDBCUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author SunHang
 * @className: SqlServiceImpl
 * @description:
 * @createTime 2021/6/11 19:17
 */
@Service
public class SqlServiceImpl implements SqlService {

    @Autowired
    private SqlDao sqlDao;


    @an
    @Override
    public int addUser(SysUser t) throws SQLException {
        int i = sqlDao.addObj(t);
//        System.out.println(1 / 0);
        return i;
    }

    @an
    @Override
    public int delUser(int id) throws SQLException {
        return sqlDao.delObj(id);
    }

    @an
    @Override
    public int updateUser(SysUser t) throws SQLException {
        return sqlDao.updateObj(t);
    }

    @Override
    public SysUser selectUserById(int id) throws SQLException {
        return (SysUser) sqlDao.selectById(id);
    }

    @Override
    public List<SysUser> selectUserList() throws SQLException {
        return sqlDao.selectList();
    }
}
