package com.javasm;

import com.javasm.controller.MyTransactionManager;
import com.javasm.dao.SqlDao;
import com.javasm.entity.SysUser;
import com.javasm.service.SqlService;
import com.javasm.service.impl.SqlServiceImpl;
import com.javasm.utils.JDBCUtil;
import com.javasm.utils.SpringUtil;
import lombok.SneakyThrows;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.util.List;

/**
 * @className: SqlTest
 * @description:   
 * @author SunHang
 * @createTime 2021/6/11 19:18
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class SqlTest {


    @Resource
    private SqlService sqlService;
//    @Resource
//    private SqlDao sqlDao;
//    @Resource
//    private SqlService sqlService;
    @SneakyThrows
    @Test
    public void test1_manager(){
        System.out.println(sqlService);
        SysUser user = new SysUser("sss", "1122");
        int i = sqlService.addUser(user);
        System.out.println(i);
//        List<SysUser> sysUsers = sqlService.selectUserList();
//        System.out.println(sysUsers);
    }

    @SneakyThrows
    @Test
    public void test2_select(){
        SysUser sysUser = sqlService.selectUserById(1);
        System.out.println(sysUser);
        List<SysUser> sysUsers = sqlService.selectUserList();
        System.out.println(sysUsers);
    }
//    @Test
//    public void test2_sqlDao(){
//
//    }
    @Test
    public void test3_sqlService(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
        SpringUtil springUtil = new SpringUtil();
        springUtil.setApplicationContext(ac);
        DataSource bean = SpringUtil.getBean(DataSource.class);
        System.out.println(bean);
    }
}
