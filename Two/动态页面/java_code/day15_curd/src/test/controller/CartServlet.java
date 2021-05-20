package test.controller;



import test.entity.MyProduct;
import test.service.ProdService;
import test.service.impl.ProdServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebServlet("/cart")
public class CartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        ProdService ps = new ProdServiceImpl();
        List<MyProduct> productList = new ArrayList<MyProduct>();
        for(Cookie ck:cookies){
            //找到商品信息
            if(ck.getName().startsWith("prod_")){
                 String prodid = ck.getName().split("_")[1];
                MyProduct productById = ps.getProductById(prodid);
                productById.setProdNum(Integer.parseInt(ck.getValue()));
                productList.add(productById);
            }
        }
//        System.out.println(productList);
        req.setAttribute("prodList",productList);
        req.getRequestDispatcher("/mypage/cartPage.jsp").forward(req,resp);
/*
* MyProductDo   数据模型
* private String prodId;
    private String prodName;
    private Double prodPrice;
    private String prodImg;
    private String prodDesc;
*MyProductVo    显示模型
*  private String prodId;
    private String prodName;
    private Double prodPrice;
    private String prodImg;
    private String prodDesc;
    private Integer prodNum;
*
* */

    }
}
