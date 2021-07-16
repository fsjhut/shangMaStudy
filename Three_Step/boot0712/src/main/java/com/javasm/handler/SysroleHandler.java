package com.javasm.handler;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("role")
public class SysroleHandler {


    //request,session,ServletContext
    @GetMapping("rolelist")
    public String forwardRoleList(Model model, HttpSession session){
        List<Sysuser> ul = new ArrayList<>();
        ul.add(new Sysuser("2","aaaa1","aaaa1"));
        ul.add(new Sysuser("3","aaaa2","aaaa2"));
        ul.add(new Sysuser("4","aaaa3","aaaa3"));

        //1.向request中加入数据
        model.addAttribute("p","超群");//request.setAttribute
        model.addAttribute("u",new Sysuser("1","admin","1111111111"));
        model.addAttribute("ul",ul);

        //2.向session中加入数据
        session.setAttribute("sp","超群session");

        //3.向servletContext中加入数据
        ServletContext servletContext = session.getServletContext();
        servletContext.setAttribute("scp","超群servletContext");

        return "rl";//ThyemeleafViewRsolver拼接前缀后缀.
    }

    @GetMapping("goadd")
    public String goadd(Integer rid,String rname)
    {
        System.out.println(rid);
        System.out.println(rname);
        return "add";//ThyemeleafViewRsolver拼接前缀后缀.
    }

    @PostMapping("doadd")
    public String doadd(String rname){
        System.out.println(rname);
        return "redirect:rolelist";
    }
}
