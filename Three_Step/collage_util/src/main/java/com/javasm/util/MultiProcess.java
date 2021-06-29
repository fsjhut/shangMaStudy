package com.javasm.util;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @className: MultiProcess
 * @description:   
 * @author SunHang
 * @createTime 2021/6/27 15:46
 */
public class MultiProcess {
    public static void main(String[] args) {
        ThreadPoolExecutor executor =
                new ThreadPoolExecutor(5, 20, 400,
                        TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(30),
                        Executors.defaultThreadFactory(),
                        new ThreadPoolExecutor.CallerRunsPolicy());
//        GetEnroll2 account1 = new GetEnroll2();
//        GetEnroll2 account2 = new GetEnroll2();
//        executor.submit(() -> account1.mainFunc(2000,3000));
//        executor.submit(() -> account2.mainFunc(3000,4000));

        GetSpecialize specialize1 = new GetSpecialize();
        GetSpecialize specialize2 = new GetSpecialize();
        GetSpecialize specialize3 = new GetSpecialize();
        GetSpecialize specialize4 = new GetSpecialize();
        GetSpecialize specialize5 = new GetSpecialize();
        GetSpecialize specialize6 = new GetSpecialize();
        GetSpecialize specialize7 = new GetSpecialize();
        GetSpecialize specialize8 = new GetSpecialize();
        GetSpecialize specialize9 = new GetSpecialize();
        GetSpecialize specialize10 = new GetSpecialize();
        executor.submit(()->specialize1.mainFunc(3400,3500));
        executor.submit(()->specialize2.mainFunc(1750,1900));
        executor.submit(()->specialize3.mainFunc(2066,2200));
        executor.submit(()->specialize4.mainFunc(2200,2300));
        executor.submit(()->specialize5.mainFunc(2300,2400));
        executor.submit(()->specialize6.mainFunc(2400,2500));
        executor.submit(()->specialize7.mainFunc(2628,2750));
        executor.submit(()->specialize8.mainFunc(2750,2900));
        executor.submit(()->specialize9.mainFunc(2900,3100));
        executor.submit(()->specialize10.mainFunc(3100,3500));
        executor.shutdown();
    }
}
