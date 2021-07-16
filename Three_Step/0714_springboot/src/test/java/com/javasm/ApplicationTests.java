package com.javasm;

import com.javasm.sys.dao.SysuserDao;
import com.javasm.sys.entity.Sysuser;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.awt.*;
import java.util.List;

@SpringBootTest
class ApplicationTests {

    @Resource
    private SysuserDao ud;
    @Test
    void test1_select() {
        List<Sysuser> sysusers = ud.selectList(null);
        System.out.println(sysusers);
    }
    @Test
    void test2_selectById(){
        Sysuser sysuser = ud.selectById(1);
        System.out.println(sysuser);
    }
    @Test
    void test3_inset(){
        Sysuser sysuser = new Sysuser();
        sysuser.setUname("ssss");
        sysuser.setUphone("1111111");
        sysuser.setDeptId(12);
        int insert = ud.insert(sysuser);
        System.out.println(insert);
    }

}
