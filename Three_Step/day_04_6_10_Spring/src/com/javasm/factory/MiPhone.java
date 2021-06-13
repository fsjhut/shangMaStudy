package com.javasm.factory;
/**
 * @className: MiPhone
 * @description:   
 * @author SunHang
 * @createTime 2021/6/10 21:33
 */
public class MiPhone implements Phone {
    public MiPhone() {
        System.out.println("生产了一个小米手机");
    }

    @Override
    public void start() {
        System.out.println("我是小米手机");
        System.out.println("小米手机开始使用");
    }

    @Override
    public void over() {
        System.out.println("小米手机坏了");
    }
}
