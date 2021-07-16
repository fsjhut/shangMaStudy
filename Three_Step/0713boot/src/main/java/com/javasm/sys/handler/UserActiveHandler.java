package com.javasm.sys.handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class UserActiveHandler {
    @GetMapping("active/{id}")
    public String userActive(@PathVariable("id")String id){
        System.out.println("用户激活:"+id);
        return "suc";
    }
}
