package com.javasm.test;

import com.javasm.entity.Menu;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:sunhang
 * @className: MyTest
 * @description:
 * @date: 2021-05-30 11:25
 * @version:0.1
 * @since: 1.8
 */
public class MyTest {
    public static void main(String[] args) {
        /*
        需要返回的数据格式如下 ，需要使用fastjson进行数据格式的转换
        mymenu:[{"mid":1000,"menuname":"系统管理","menuicon":"el-icon-setting","submenu":[
							{"mid":1001,"menuname":"系统参数"},
							{"mid":1002,"menuname":"人员设置"}]},
						{"mid":2000,"menuname":"订单管理","menuicon":"el-icon-s-check","submenu":[
							{"mid":2001,"menuname":"订单查询"},
							{"mid":2002,"menuname":"订单核对"}],
						}]
		 如何进行数据的处理，可以实现上述的数据格式
         */
        List<Menu> mlist = new ArrayList<>();
//        mlist.add();


    }
}
