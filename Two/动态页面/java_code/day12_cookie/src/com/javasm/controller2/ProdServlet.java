package com.javasm.controller2;

import com.javasm.entity.MyProduct;
import com.javasm.service.ProdService;
import com.javasm.service.impl.ProdServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/prod")
public class ProdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProdService ps = new ProdServiceImpl();
//        List<MyProduct> allProduct = ps.getAllProduct();

//        req.setAttribute("listProd",allProduct);
        req.getRequestDispatcher("/mypage/productPage.jsp").forward(req,resp);


    }
}
