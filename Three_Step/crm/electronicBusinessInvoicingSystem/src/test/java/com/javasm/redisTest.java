package com.javasm;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.javasm.commons.cache.RedisService;
import com.javasm.sys.entity.GoodsManager;
import com.javasm.sys.service.impl.GoodsManagerServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: JAVASM
 * @className: redisTest
 * @date: 2021/6/30 15:59
 * @version: 8.8.8
 * @since:6.6.6
 */

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("classpath:conf/Spring.xml")
public class redisTest {
    @Resource
    private RedisService redisService;
    @Resource
    private GoodsManagerServiceImpl goodsManagerService;

    @Test
    public void redis() {
        redisService.set("aa", "aaa");
    }

    @Test
    public void readExcelTest() {
        ExcelReader reader = ExcelUtil.getReader("d:/采购手机.xlsx");
//        ExcelReader reader = ExcelUtil.getReader("d:/aaa.xlsx");
//        List<Map<String,Object>> readAll = reader.readAll();
        List<GoodsManager> all = reader.readAll(GoodsManager.class);


        goodsManagerService.insertGoods(all);
        System.out.println(all);

    }

    @Test
    public void writeToExcelTest() {


    }

}
