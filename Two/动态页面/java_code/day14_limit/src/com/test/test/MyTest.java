package com.test.test;

import com.test.dao.ProdDao;
import com.test.dao.impl.ProdDaoImpl;
import com.test.entity.MyProduct;

import java.util.List;

/**
 * @className: MyTest
 * @description:   
 * @author SunHang
 * @createTime 2021/5/14 16:26
 */
public class MyTest {
    public static void main(String[] args) {

        ProdDao pd = new ProdDaoImpl();
        //List<MyProduct> allProduct = pd.getAllProduct();
        //System.out.println(allProduct);
        MyProduct myProduct = new MyProduct();
        myProduct.setProdId("sh060425");
        myProduct.setProdName("洗发水");
        List<MyProduct> allProduct = pd.getAllProduct(1, 4,myProduct);
//        System.out.println(allProduct);
    }
}
