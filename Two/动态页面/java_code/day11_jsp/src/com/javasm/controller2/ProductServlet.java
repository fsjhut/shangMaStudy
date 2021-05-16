package com.javasm.controller2;

import com.javasm.entity.Product;
import com.javasm.service.ProductService;
import com.javasm.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @className: ProductServlet
 * @description:   
 * @author SunHang
 * @createTime 2021/5/11 21:12
 */
@WebServlet("/product")
public class ProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductService productService = new ProductServiceImpl();
        List<Product> allProduct =  productService.getAllProduct();
        req.setAttribute("allProduct",allProduct);
        req.getRequestDispatcher("/mypage/productPage.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
