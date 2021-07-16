package com.javasm;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.javasm.sys.dao.SysuserDao;
import com.javasm.sys.entity.Sysuser;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * @className: TestWrapper
 * @description:   
 * @author SunHang
 * @createTime 2021/7/14 17:28
 */
@SpringBootTest
public class TestWrapper {
    @Resource
    private SysuserDao ud;

    @Test
    public void test1_selectByMap(){
        HashMap<String, Object> map =  new HashMap<>();
        // 查询条件
        map.put("uphone","11111");
        List<Sysuser> sysusers = ud.selectByMap(map);
        System.out.println(sysusers);
    }
    @Test
    public void test2_selectByWrapper(){
        QueryWrapper w = new QueryWrapper(); // 用在查询,删除的地方
//        UpdateWrapper u; // update更新
        w.eq("uphone","1111");
        w.like("uemail","hn");
        List<Sysuser> sysusers1 = ud.selectList(w);

    }
    @Test
    public void test3_selectByWrapper(){
        Sysuser sysuser = new Sysuser();
        sysuser.setDeptId(11);
        sysuser.setUname("222");

        QueryWrapper w = new QueryWrapper(sysuser); // 用在查询,删除的地方
//        UpdateWrapper u; // update更新

        List<Sysuser> sysusers1 = ud.selectList(w);

    }
    @Test
    public void update(){
        Sysuser sysuser1 = ud.selectById(1);
        sysuser1.setUphone("333333");
        ud.updateById(sysuser1);
    }
    @Test
    public void selectList(){
        IPage<Sysuser> p = new Page<>(1,2);
        ud.selectPage(p, null);
        System.out.println(p);
    }
    @Test
    public void selectListPageHelper(){
//        PageHelper
        PageHelper.startPage(1,2);
        List<Sysuser> sysusers = ud.selectList(null);
        System.out.println(new PageInfo<>(sysusers));
    }
}
