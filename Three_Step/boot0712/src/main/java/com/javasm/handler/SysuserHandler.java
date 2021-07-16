package com.javasm.handler;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("user")
public class SysuserHandler {

    //
    @GetMapping("format")
    public String formatDate(Date udate){
        System.out.println(udate);
        return "format-suc";
    }

    @GetMapping("{uid}")
    public String getuserBYId(@PathVariable("uid")String uid){
        int a=1/0;
        System.out.println("用户id:"+uid);
        return "suc";
    }
}
