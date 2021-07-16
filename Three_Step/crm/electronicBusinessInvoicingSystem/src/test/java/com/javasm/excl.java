package com.javasm;

import cn.hutool.poi.excel.ExcelReader;

import cn.hutool.poi.excel.ExcelUtil;
import com.javasm.sys.entity.B2cOrder;
import com.javasm.sys.entity.GoodsManager;
import com.javasm.sys.service.B2cOrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: JAVASM
 * @className: excl
 * @date: 2021/7/5 21:40
 * @version: 8.8.8
 * @since:6.6.6
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("classpath:conf/Spring.xml")
public class excl {
    @Resource
    private B2cOrderService b2cOrderService;
        @Test
    public void readExcelTest() {
        ExcelReader reader = ExcelUtil.getReader("E:/B2C.xlsx");
        List<B2cOrder> all = reader.readAll(B2cOrder.class);
//            for (B2cOrder b2cOrder : all) {
//                b2cOrderService.add(b2cOrder);
//            }
            System.out.println(all);
//            b2cOrderService.insertB2C(all);


    }
}
