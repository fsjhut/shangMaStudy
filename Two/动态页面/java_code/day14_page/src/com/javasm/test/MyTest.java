package com.javasm.test;

import com.javasm.dao.ProdDao;
import com.javasm.dao.impl.ProdDaoImpl;
import com.javasm.entity.MyProduct;

import java.util.List;

public class MyTest {
    public static void main(String[] args) {
       // UserDao ud = new UserDaoImpl();
/*        MyUser newuser = new MyUser("bbb2","bbb");
        MyUser login = ud.login(newuser);*/
      /*  List<MyUser> allUser = ud.getAllUser();
        System.out.println(allUser);*/
        ProdDao pd = new ProdDaoImpl();
        //List<MyProduct> allProduct = pd.getAllProduct();
        //System.out.println(allProduct);
        MyProduct myProduct = new MyProduct();
        myProduct.setProdId("sh060555");
        myProduct.setProdName("洗发水333");
        myProduct.setProdPrice(11.24d);
        myProduct.setProdImg("xxxx33");

        System.out.println( pd.editProd(myProduct));
    }

}
