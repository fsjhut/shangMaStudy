package com.javasm.handler;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @className: SysuserHandler
 * @description:   
 * @author SunHang
 * @createTime 2021/7/10 22:01
 */
@RestController
public class SysuserHandler {
//    @Value("${jdbc.url}")
//    private String url;

    @GetMapping("hello")
    public String hello(){
        System.out.println("1111111");
//        System.out.println(url);
        return "ok";
    }
}
