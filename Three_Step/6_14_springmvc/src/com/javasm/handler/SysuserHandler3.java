package com.javasm.handler;

import com.javasm.entity.Sysuser;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @className: SysuserHandler2
 * @description:   
 * @author SunHang
 * @createTime 2021/6/14 21:36
 */
@Controller
//@RestController
@RequestMapping("user3")
public class SysuserHandler3 {
    // 处理方法的形参中只能有一个RequestBody注解
    @RequestMapping("add")
    @ResponseBody//只可以指定响应体 ResponseEntity可以将响应头和响应体都传过去
    public Sysuser addUser(@RequestBody Map u) throws InvocationTargetException, IllegalAccessException {
        System.out.println(u);
        Sysuser sysuser = new Sysuser();
        sysuser.setUid(11111);
        return sysuser;
    }
    @RequestMapping("add2")
    @ResponseBody//只可以指定响应体 ResponseEntity可以将响应头和响应体都传过去
    public ResponseEntity addUser2(@RequestBody Sysuser u) throws InvocationTargetException, IllegalAccessException {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("mycustomerHeader","ewee");
        return new ResponseEntity(u, httpHeaders, HttpStatus.OK);
    }
}
