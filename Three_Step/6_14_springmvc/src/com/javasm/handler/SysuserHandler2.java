package com.javasm.handler;

import com.javasm.entity.Sysuser;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @className: SysuserHandler2
 * @description:   
 * @author SunHang
 * @createTime 2021/6/14 21:36
 */
@Controller
@RequestMapping("user2")
public class SysuserHandler2 {
    // 处理方法的形参中只能有一个RequestBody注解
    @RequestMapping("add")
    public String addUser(@RequestBody Map u) throws InvocationTargetException, IllegalAccessException {
        System.out.println(u);
        Sysuser sysuser = new Sysuser();
        BeanUtils.populate(sysuser,u);
        return "main";
    }
}
