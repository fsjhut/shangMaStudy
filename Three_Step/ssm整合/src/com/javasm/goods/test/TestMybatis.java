package com.javasm.goods.test;

import com.javasm.goods.dao.GoodsDao;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @className: TestMybatis
 * @description:   
 * @author SunHang
 * @createTime 2021/6/16 20:48
 */
public class TestMybatis {

    @Test
    public void test1() throws IOException {
        // 加载mybatis的配置文件
        InputStream in = TestMybatis.class.getClassLoader().getResourceAsStream("mybatis.xml");
        // 创建SqlSessionFactory工厂对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        // 创建SqlSession对象
        SqlSession sqlSession = factory.openSession();
        // 获取到代理对象
        GoodsDao goodsDao = sqlSession.getMapper(GoodsDao.class);
        goodsDao.selectList();
        //释放资源
        sqlSession.close();
        in.close();
    }
}
