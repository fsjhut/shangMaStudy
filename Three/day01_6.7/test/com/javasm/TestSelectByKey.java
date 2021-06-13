package com.javasm;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;

/**
 * @className: TestSelectByKey
 * @description:   
 * @author SunHang
 * @createTime 2021/6/7 13:29
 */
public class TestSelectByKey {
    @Test
    public void test1_selectByKey(){
        // 运行mybatis 步骤
        InputStream in = TestSelectByKey.class.getClassLoader().getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(in, "dev");
        SqlSession sqlSession = ssf.openSession();
        Object o = sqlSession.selectOne("aa.bb.selectUserByKey", 1); // 1:是sql语句中需要拼接的参数
        System.out.println(o);
    }
}
