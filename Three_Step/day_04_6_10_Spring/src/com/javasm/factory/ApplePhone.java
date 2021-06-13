package com.javasm.factory;
/**
 * @className: ApplePhone
 * @description:   
 * @author SunHang
 * @createTime 2021/6/10 21:33
 */
public class ApplePhone implements Phone {
    public ApplePhone() {
        System.out.println("生产了一个苹果手机");
    }

    @Override
    public void start() {
        System.out.println("我是苹果手机");
        System.out.println("开始使用");
    }

    @Override
    public void over() {
        System.out.println("苹果手机寿命到期");
    }
}
