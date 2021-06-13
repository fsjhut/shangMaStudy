package com.javasm.factory;
/**
 * @className: HonorPhone
 * @description:   
 * @author SunHang
 * @createTime 2021/6/10 21:34
 */
public class HonorPhone implements Phone {
    public HonorPhone() {
        System.out.println("生产了一个荣耀手机");
    }

    @Override
    public void start() {
        System.out.println("我是荣耀手机");
        System.out.println("荣耀手机开始使用");
    }

    @Override
    public void over() {
        System.out.println("荣耀手机坏了");
    }
}
