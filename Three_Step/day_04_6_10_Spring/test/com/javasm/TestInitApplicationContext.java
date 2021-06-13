package com.javasm;

import com.javasm.controller.SysUserController;
import com.javasm.entity.SysUser;
import com.javasm.factory.SessionFactoryBean;
import com.javasm.service.impl.SysUserServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @className: TestInitApplication
 * @description:   
 * @author SunHang
 * @createTime 2021/6/10 12:47
 */
public class TestInitApplicationContext {
    private ApplicationContext ac  = new ClassPathXmlApplicationContext("spring.xml");
    @Test
    public void test1_initApplicationContext(){
        // 容器对象 ----- 默认是单例模式，getBean获取的对象都是同一个对象

        // 获取bean对象 通过getBean获取，需要进行类型强制转换
        SysUserController sysUser = (SysUserController) ac.getBean("sysUserController");
        sysUser.login();
        // 根据类类型获取
        SysUserController sysUser2 = ac.getBean(SysUserController.class);
        sysUser2.login();
        System.out.println(sysUser);
        System.out.println(sysUser2);
        System.out.println("--------------------------");
        sysUser.getUserService().logout("ssss");
        System.out.println(sysUser.getUserService());
    }
    @Test
    public void test2_factory(){
        SysUser bean = ac.getBean(SysUser.class);
        System.out.println(bean);
        SessionFactoryBean bean1 = ac.getBean(SessionFactoryBean.class);
        System.out.println(bean1);
    }
    @Test
    public void test3_(){
        SysUserServiceImpl userService =(SysUserServiceImpl) ac.getBean("userService");
        System.out.println(userService);
        SysUserServiceImpl userService2 =(SysUserServiceImpl) ac.getBean("sysUserServiceImpl");
        System.out.println(userService2);
    }
}
