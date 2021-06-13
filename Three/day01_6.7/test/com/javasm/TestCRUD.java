package com.javasm;

import com.javasm.entity.Sysuser;
import com.javasm.utils.SSF;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.*;
import org.junit.runners.MethodSorters;

import java.util.List;

/**
 * @className: TestCRUD
 * @description:   
 * @author SunHang
 * @createTime 2021/6/7 19:29
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestCRUD {
    private static SqlSessionFactory ssf = null;
    private SqlSession session = null;
    @BeforeClass
    public static void beforeClass()
    {
        ssf= SSF.getFactory();
    }
    @AfterClass
    public static void afterClass(){
        ssf=null;
    }
    @Before
    public void init(){
        session= ssf.openSession();
    }

    @After
    public void close(){
        session.close();
    }
    @Test
    public void test1_addUser(){
        Sysuser u = new Sysuser();
        u.setUname("huawei");
        u.setUpwd("123123");
        //受影响的行数
        int rows = session.insert("aa.bb.addUser", u);
        System.out.println(rows);
        Integer uid = u.getUid();
        System.out.println("uid:"+uid);
        session.commit();
        //set autocommit false
    }
    @Test
    public void test2_updateUser() {
        Sysuser u = new Sysuser();
        u.setUname("huawei");
        u.setUpwd("654342");
        u.setUid(4);
        //受影响的行数
        int rows = session.update("aa.bb.updateUser", u);
        System.out.println(rows);
        session.commit();
        //set autocommit false
    }
    @Test
    public void test3_deleteUser() {
        int rows = session.update("aa.bb.deleteUser", 7);
        System.out.println(rows);
        session.commit();
        //set autocommit false
    }
    @Test
    public void test4_selectUserByKey() {
        Object o = session.selectOne("aa.bb.selectUserByKey", 1);
        System.out.println(o);
    }
    @Test
    public void test5_selectListUser() {
        List<Object> objects = session.selectList("aa.bb.selectListUser");
        System.out.println(objects);
    }
}
