package test.controller;



import test.entity.MyProduct;
import test.service.ProdService;
import test.service.impl.ProdServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
@WebServlet("/prod/*")
public class ProdServlet extends baseServlet {

    public void query(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        // 自定义的查询方法
        System.out.println("查询");
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
    public void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        // 进行添加数据的操作
        req.setCharacterEncoding("utf-8");
        String prodId = req.getParameter("prodId");
        String prodName = req.getParameter("prodName");
        String prodPriceStr = req.getParameter("prodPrice");
        String prodImg = req.getParameter("prodImg");
        String prodDesc = req.getParameter("prodDesc");
        Double prodPrice = 0d;
        if(prodPriceStr!=null&&!"".equals(prodPriceStr)){
            prodPrice = Double.valueOf(prodPriceStr);
        }
        MyProduct myProduct = new MyProduct(prodId,prodName,prodPrice,prodImg,prodDesc);
        // 往数据库中添加数据
        ProdService prodService = new ProdServiceImpl();
        Integer resNum = prodService.insertProd(myProduct);
        if(resNum>0){
            req.setAttribute("resImg","img/ok.png");
            req.setAttribute("resMsg","执行成功");
        }else{
            req.setAttribute("resImg","img/wrong.png");
            req.setAttribute("resMsg","出现异常 请联系管理员");
        }
        req.getRequestDispatcher("/mypage/showRes.jsp").forward(req,resp);
//        prodService.insert(myProduct);
    }
    public void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
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
    public void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        System.out.println("执行了修改");
        req.setCharacterEncoding("utf-8");
        String prodId = req.getParameter("prodId");
        ProdService ps = new ProdServiceImpl();
        Integer integer = ps.delProd(prodId);
        if(integer>0){
            req.setAttribute("resImg","img/ok.png");
            req.setAttribute("resMsg","执行成功");
        }else{
            req.setAttribute("resImg","img/wrong.png");
            req.setAttribute("resMsg","出现异常 请联系管理员");
        }
        req.getRequestDispatcher("/mypage/showRes.jsp").forward(req,resp);

    }
    public void readyForEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
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
