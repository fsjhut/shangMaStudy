package com.javasm.sys.handler;

import com.javasm.sys.service.SysuserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("sysuser")
public class SysuserHandler{

    @Resource
    private SysuserService sysuserService;




}
