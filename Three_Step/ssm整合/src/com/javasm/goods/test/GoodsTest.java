package com.javasm.goods.test;

import com.javasm.goods.entity.Goods;
import com.javasm.goods.service.GoodsService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @className: GoodsTest
 * @description:   
 * @author SunHang
 * @createTime 2021/6/16 19:33
 */
public class GoodsTest {

    @Test
    public void test1_spring(){
        // 加载配置文件
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring.xml");
        // 获取对象
        GoodsService bean = ac.getBean(GoodsService.class);
        // 调用方法
        bean.addGoods(new Goods());
        System.out.println(bean);
    }

}
