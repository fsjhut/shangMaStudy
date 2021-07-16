package com.javasm.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainHandler {
    private Logger l = LoggerFactory.getLogger(MainHandler.class);

    @GetMapping("main")
    public String main(){
        l.debug("debug日志....");
        return "main";
    }
}
