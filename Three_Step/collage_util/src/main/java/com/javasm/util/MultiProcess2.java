package com.javasm.util;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * @className: MultiProcess
 * @description:   
 * @author SunHang
 * @createTime 2021/6/27 15:46
 */
public class MultiProcess2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor executor =
                new ThreadPoolExecutor(30, 50, 400,
                        TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(30),
                        Executors.defaultThreadFactory(),
                        new ThreadPoolExecutor.CallerRunsPolicy());
        GetSpecialize2.generateAllUrl(30,4000);
        ArrayList<String> pathList = GetSpecialize2.getPathList();
        int index;
        for (index = 0; index < pathList.size(); index++) {
            String path = pathList.get(index);
            executor.submit(() -> GetSpecialize2.mainFunc(path));
//            if(!submit.get()){
//                "https://static-data.eol.cn/www/2.0/schoolspecialindex/2018/487/41/1/8/1.json";
//                // 如果访问2018返回的结果是false，则直接访问2019，如果访问2020返回的结果是false，则直接访问488
////                String fileName = path.substring(path.lastIndexOf("/") + 1);
////                System.out.println(fileName);
////                int subindex = Integer.parseInt(fileName.substring(0, fileName.indexOf(".") - 1));
//                int subIndex = Integer.parseInt(path.substring(54, 58));
//                int schoolId = Integer.parseInt(path.substring(60,))
//                urlStr.append("https://static-data.eol.cn/www/2.0/schoolspecialindex/");
//                urlStr.append(String.valueOf(2014));
//                urlStr.append("/");
//                urlStr.append(String.valueOf(i));
//                urlStr.append("/41/1/8/");
//                urlStr.append(String.valueOf(k));
//                urlStr.append(".json");
//                if(subIndex==2020) {
//                    pathList.indexOf()
//                }
//
//            }


        }
//        for (String path : pathList) {
//            executor.submit(()->GetSpecialize2.mainFunc(path));
//        }
        GetSpecialize2.getErrorList().forEach(System.out::println);
        executor.shutdown();



//        GetEnroll2 account1 = new GetEnroll2();
//        GetEnroll2 account2 = new GetEnroll2();
//        executor.submit(() -> account1.mainFunc(2000,3000));
//        executor.submit(() -> account2.mainFunc(3000,4000));


//        executor.submit(()->specialize6.mainFunc(2400,2500));
//        executor.submit(()->specialize7.mainFunc(2628,2750));
//        executor.submit(()->specialize8.mainFunc(2750,2900));
//        executor.submit(()->specialize9.mainFunc(2900,3100));
//        executor.submit(()->specialize10.mainFunc(3100,3500));
//        executor.shutdown();
    }
}
