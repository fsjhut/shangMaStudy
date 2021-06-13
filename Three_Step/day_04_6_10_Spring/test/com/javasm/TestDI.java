package com.javasm;

import com.javasm.controller.DiTest;
import com.javasm.entity.SysUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @className: TestDI
 * @description:   
 * @author SunHang
 * @createTime 2021/6/10 20:56
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:DITest.xml")
public class TestDI {
    private ApplicationContext ac  = new ClassPathXmlApplicationContext("DITest.xml");
    @Test
    public void test1_bean(){
        DiTest bean = ac.getBean(DiTest.class);
        System.out.println(bean);
        System.out.println(bean.getSysUser());
//        SysUser bean1 = ac.getBean(SysUser.class);
//        System.out.println(bean1);
    }
    @Test
    public void test2_construct(){

    }
}
