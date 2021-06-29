package com.javasm.handler;

import com.javasm.entity.Sysuser;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.ModelAndView;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.Map;

/**
 * @className: SysuserHandler
 * @description:   
 * @author SunHang
 * @createTime 2021/6/14 13:37
 */
@Controller
@RequestMapping("user")
public class SysuserHandler {

//    @RequestMapping("hellomvc")
//    public String hello(){
//        System.out.println("hello springMvc");
//        return "main";
////        HandlerAdapter
//    }
//    @RequestMapping("add")
//    public ModelAndView addUser(String name,Date ubirthday){
//        ModelAndView mv = new ModelAndView();
//        Sysuser sysuser = new Sysuser();
//        sysuser.setUname(name);
//        sysuser.setUbirthday(ubirthday);
//        mv.setViewName(""); // 指定视图路经
//        // 指定视图中需要返回的数据
//        mv.addObject("sysuer","sysuser");
//        return mv;
//    }
//    @RequestMapping("add")
//    public String addUser(String name, @DateTimeFormat(pattern = "yyyy-MM-dd")
//            Date ubirthday, Model model){
//        ModelAndView mv = new ModelAndView();
//        Sysuser sysuser = new Sysuser();
//        sysuser.setUname(name);
//        sysuser.setUbirthday(ubirthday);
//        mv.setViewName(""); // 指定视图路经
//        // 指定视图中需要返回的数据
//        model.addAttribute("sysuer","sysuser");
//        return "main";
//    }
//    @RequestMapping("add")
//    public String addUser(Sysuser sysuser){
//        System.out.println(sysuser);
//        return "main";
//    }
//    @RequestMapping("list")
//    public String getUsers(Sysuser u,
//                           @RequestParam(defaultValue = "1")Integer pageNum,
//                           @RequestParam(defaultValue="10")Integer pageSize){
//        System.out.println(u);
//        return "main";
//    }
    @RequestMapping("add")
    public String addUser(@RequestBody Sysuser u){
        System.out.println(u);
        Sysuser sysuser = new Sysuser();
//        BeanUtils.populate(sysuser,u);
        return "main";
}
}
