package com.javasm;

import com.javasm.factory.Phone;
import com.javasm.factory.PhoneFactory;
import org.junit.Test;

/**
 * @className: FactoryTest
 * @description:   
 * @author SunHang
 * @createTime 2021/6/10 21:38
 */
public class FactoryTest {
    @Test
    public void test1_phone(){
        Phone honor = PhoneFactory.createPhone("honor");
        assert honor != null;
        honor.start();
    }
    @Test
    public void test2_createPhone2(){
        Phone honor = PhoneFactory.createPhone2("honor");
        assert honor != null;
        honor.start();
        Phone apple = PhoneFactory.createPhone("apple");
        apple.over();
    }
}
