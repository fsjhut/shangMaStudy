package com.test.controller;

import com.test.entity.MyProduct;
import com.test.service.ProdService;
import com.test.service.impl.ProdServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @className: ProdServlet
 * @description:   
 * @author SunHang
 * @createTime 2021/5/14 16:23
 */
@WebServlet("/prod")
public class ProdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        ProdService ps = new ProdServiceImpl();
//        List<MyProduct> allProduct = ps.getAllProduct();

//        req.setAttribute("listProd",allProduct);
        doPost(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        // 获取前端页面传递的参数
        String pageStr = req.getParameter("page");
        String pageSizeStr = req.getParameter("pageSize");
        // 将前端获取的用户数据封装为对象
        String prodid = req.getParameter("prodid");
        String prodname = req.getParameter("prodname");
        MyProduct myProduct = new MyProduct(prodid, prodname);
        // 设置page和pageSize的默认值
        Integer page = 1;
        Integer pageSize = 3;
        // 判断传递的参数中是否有page 或 pageSize值
        if(pageStr!=null && !"".equals(pageStr)){
            page = Integer.parseInt(pageStr);
        }
        if(pageSizeStr!=null && !"".equals(pageSizeStr)){
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
        req.getRequestDispatcher("/mypage/prodPage.jsp").forward(req,resp);
    }
}
