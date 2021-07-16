package com.javasm.sys.handler;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.javasm.sys.dao.SysdeptDao;
import com.javasm.sys.entity.Sysdept;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("dept")
public class SysdeptHandler {

    @Resource
    private SysdeptDao dd;

    @GetMapping("list")
    public PageInfo selectDepts(@RequestParam(defaultValue = "1") Integer pageNum,@RequestParam(defaultValue = "2") Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<Sysdept> list = dd.selectList();//Page对象
        return new PageInfo(list);
    }
}
