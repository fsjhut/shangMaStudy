package com.javasm;

import com.javasm.entity.Sysrole;
import com.javasm.entity.Sysuser;
import com.javasm.mapper2.SysroleMapper;
import com.javasm.mapper2.SysuserMapper;
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
public class TestAsscation {

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


    // 一对多关系的第一种查询方法：手动使用两个查询语句，先查询第一个表，
    // 第一个表的部分结果做为查询参数进行第二个表的查询
    // 将第二个表的查询结果(对象)保存到第一个表的查询对象的属性()中。
    @Test
    public void test1_selectUserAndRole(){
        SysroleMapper rm = session.getMapper(SysroleMapper.class);
        SysuserMapper um = session.getMapper(SysuserMapper.class);
        Sysuser sysuser = um.selectById(1);
        Sysrole sysrole = rm.selectRoleByKey(sysuser.getRid());
        sysuser.setSysrole(sysrole);
        System.out.println(sysuser);
    }
    // 第二种查询方法，使用联合查询的sql语句进行一次性查询，将结果的数据进行二次映射
    @Test
    public void test2_selectUserAndRole2(){
        SysuserMapper mapper = session.getMapper(SysuserMapper.class);
        Sysuser sysuser = mapper.selectUserAndRoleById(1);
        System.out.println(sysuser);
    }
    // 第三种查询方法，利用mybatis进行自动二次查询
    @Test
    public void test3_selectUserAndRole3(){
        SysuserMapper mapper = session.getMapper(SysuserMapper.class);
        Sysuser sysuser = mapper.selectUserAndRoleById2(1);
        System.out.println(sysuser);
    }
    // 查询多个数据，返回一个List集合
    @Test
    public void test4_selectUsersAndRole(){
        SysuserMapper mapper = session.getMapper(SysuserMapper.class);
        List<Sysuser> sysusers = mapper.selectUsersAndRole();
        System.out.println(sysusers);
    }
}
