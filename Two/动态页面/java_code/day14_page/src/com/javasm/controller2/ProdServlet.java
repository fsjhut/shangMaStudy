package com.javasm.controller2;

import com.javasm.entity.MyProduct;
import com.javasm.service.ProdService;
import com.javasm.service.impl.ProdServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.namespace.QName;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

@WebServlet("/prod/*")
public class ProdServlet extends BaseServlet {


    public void query(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*
        * 自定义查询方法
        * */
        req.setCharacterEncoding("utf-8");

        String pageStr = req.getParameter("page");
        String pageSizeStr = req.getParameter("pageSize");

        //接收用户的查询参数 并封装成对象
        String prodid = req.getParameter("prodid");
        String prodname = req.getParameter("prodname");
        MyProduct myProduct = new MyProduct(prodid, prodname);


        Integer page = 1;
        Integer pageSize = 3;
        //无key        null
        //有key无值   ""
        if(pageStr!=null&&!"".equals(pageStr)){
            page = Integer.parseInt(pageStr);
        }
        if(pageSizeStr!=null&&!"".equals(pageSizeStr)){
            pageSize = Integer.parseInt(pageSizeStr);
        }
        ProdService ps = new ProdServiceImpl();

        List<MyProduct> allProduct = ps.getAllProduct(page,pageSize,myProduct);
        Integer totalPage = ps.getTotalPage(pageSize,myProduct);
        req.setAttribute("queryProd",myProduct);
        req.setAttribute("page",page);
        req.setAttribute("pageSize",pageSize);
        req.setAttribute("totalPage",totalPage);
        req.setAttribute("listProd",allProduct);
        req.getRequestDispatcher("/mypage/productPage.jsp").forward(req,resp);




    }

    public void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("执行了添加1");
/*
* prodId: 123
prodName: 123
prodPrice: 321
prodImg: 123
prodDesc: 321
* */
        req.setCharacterEncoding("utf-8");
        String prodId = req.getParameter("prodId");
        String prodName = req.getParameter("prodName");
        String prodPriceStr = req.getParameter("prodPrice");
        Double prodPrice = 0d;
        if(prodPriceStr!=null&&!"".equals(prodPriceStr)){
            prodPrice = Double.valueOf(prodPriceStr);
        }
        String prodImg = req.getParameter("prodImg");
        String prodDesc = req.getParameter("prodDesc");

        MyProduct mp = new MyProduct(prodId, prodName, prodPrice, prodImg, prodDesc);
        ProdService ps = new ProdServiceImpl();
        Integer resNum = ps.inserProd(mp);
        if(resNum>0){
            req.setAttribute("resImg","img/ok.png");
            req.setAttribute("resMsg","执行成功");
        }else{
            req.setAttribute("resImg","img/wrong.png");
            req.setAttribute("resMsg","出现异常 请联系管理员");
        }
        req.getRequestDispatcher("/mypage/showRes.jsp").forward(req,resp);


    }

    public void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("执行了修改");
        req.setCharacterEncoding("utf-8");
        String prodId = req.getParameter("prodId");
        String prodName = req.getParameter("prodName");
        String prodPriceStr = req.getParameter("prodPrice");
        Double prodPrice = 0d;
        if(prodPriceStr!=null&&!"".equals(prodPriceStr)){
            prodPrice = Double.valueOf(prodPriceStr);
        }
        String prodImg = req.getParameter("prodImg");
        String prodDesc = req.getParameter("prodDesc");

        MyProduct mp = new MyProduct(prodId, prodName, prodPrice, prodImg, prodDesc);
        ProdService ps = new ProdServiceImpl();
        Integer resNum = ps.editProd(mp);
        if(resNum>0){
            req.setAttribute("resImg","img/ok.png");
            req.setAttribute("resMsg","执行成功");
        }else{
            req.setAttribute("resImg","img/wrong.png");
            req.setAttribute("resMsg","出现异常 请联系管理员");
        }
        req.getRequestDispatcher("/mypage/showRes.jsp").forward(req,resp);


    }


    public void readyForEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String prodId = req.getParameter("prodId");
        ProdService ps = new ProdServiceImpl();
        //修改准备的数据
        MyProduct product = ps.getProductById(prodId);
        req.setAttribute("editProduct",product);
        req.getRequestDispatcher("/mypage/editProdPage.jsp").forward(req,resp);

    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       /*
         在一个servlet中可以执行不同的代码段
       * 1. doWhat = query     doWhat = add
       *   String doWhat = req.getParameter("doWhat");
           if("query".equals(doWhat)){
       * 2. 使用http提供的方法细分 rest
       * 3. 自定义规则 重写方法细分
       *
       * */



    }
}
