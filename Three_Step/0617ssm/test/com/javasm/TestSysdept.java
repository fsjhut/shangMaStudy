package com.javasm;


import com.javasm.sys.entity.Sysdept;
import com.javasm.sys.service.SysdeptService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class TestSysdept {
    @Autowired
    private SysdeptService s;
    @Test
    public void getChilds(){
        Sysdept d = new Sysdept();
        d.setDuser("aaa");
        List<Sysdept> list = s.selectList(d);

        List<Sysdept> tree = s.createTree(list);
    }

}
