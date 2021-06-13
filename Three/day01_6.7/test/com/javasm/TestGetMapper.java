package com.javasm;

import com.javasm.entity.Sysuser;
import com.javasm.mapper2.SysuserMapper;
import com.javasm.utils.SSF;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.*;
import org.junit.runners.MethodSorters;

import java.util.HashMap;
import java.util.List;

/**
 * @className: TestGetMapper
 * @description:   
 * @author SunHang
 * @createTime 2021/6/7 20:17
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestGetMapper {
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
    public void test1_selectById(){
        //这个对象到底是什么类型?$Proxy9
        SysuserMapper mapper = session.getMapper(SysuserMapper.class);
        //selectById方法的调用是怎么找到com.javasm.sys.mapper2.SysuserMapper.selectById对应的MappedStatement对象.
        //在方法内部,获取mapper对象的类名(com.javasm.sys.mapper2.SysuserMapper.),再获取方法名selectById
        //com.javasm.sys.mapper2.SysuserMapper.selectById
        //sessin.selectOne("com.javasm.sys.mapper2.SysuserMapper.selectById",1)
        Sysuser sysuser = mapper.selectById(1);
        System.out.println(sysuser);
    }

    @Test
    public void test2_del(){
        //这个对象到底是什么类型?$Proxy9.SysuserMapper没有实现类,但能够得到实例化对象.
        SysuserMapper mapper = session.getMapper(SysuserMapper.class);
        int del = mapper.del(6);
        session.commit();
    }

    @Test
    public void test3_login(){
        SysuserMapper mapper = session.getMapper(SysuserMapper.class);
        List<Sysuser> admin = mapper.login("admin", "11111");
        System.out.println(admin);
        session.commit();
    }
    @Test
    public void test4_selectUsers(){
        SysuserMapper mapper = session.getMapper(SysuserMapper.class);
        List<Sysuser> sysusers = mapper.selectUsers();
        System.out.println(sysusers);
    }
    @Test
    public void test5_selectUsers2(){
        SysuserMapper mapper = session.getMapper(SysuserMapper.class);
//        (Map<String,Object> u);
        HashMap<String, String> map = new HashMap<>();
        map.put("uname_key","admin");
        map.put("upwd_key","11111");
        List<Sysuser> sysusers = mapper.selectUsers2(map);
        System.out.println(sysusers);
    }
}
