package com.javasm.controller2;

import com.alibaba.fastjson.JSON;
import com.javasm.entity.MyProduct;
import com.javasm.entity.PageInfo;
import com.javasm.entity.ReturnCode;
import com.javasm.entity.ReturnEntity;
import com.javasm.service.ProdService;
import com.javasm.service.impl.ProdServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/ajaxprod")
public class AjaxProdServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*获取商品信息服务接口
         * 接口访问地址  : ajaxprod
         * 接收的参数    : page      查询的页码
         *                 pageSize  每页记录数
         *                 prodid    商品id
         *                 prodname  商品名称(模糊查询)
         * 接收方式      : get/post
         * 返回数据格式  :json
         * 返回数据示例  :
         *               有数据
         *               {"code":20001,
         *               "pif":{"page":1,"pageSize":5,"totalPage":2},
         *               "returnData":[{"prodDesc":"xxxx","prodId":"1322333","prodImg":"img/xx.jpg","prodName":"商品1","prodPrice":300},
         *                            {"prodDesc":"333","prodId":"1333332","prodImg":"3333","prodName":"1333","prodPrice":33},
         *                            {"prodDesc":"4444","prodId":"333444","prodImg":"444","prodName":"4444","prodPrice":4444},
         *                            {"prodDesc":"444","prodId":"4444","prodImg":"444","prodName":"4444","prodPrice":4444},
         *                            {"prodDesc":"55555","prodId":"555","prodImg":"5555","prodName":"555游戏5","prodPrice":5555}],
         *               "returnMsg":"请求成功"}
         *               无数据
         *               {"code":30001,
         *               "pif":{"page":1,"pageSize":0,"totalPage":0},
         *               "returnMsg":"没有数据"}
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

        resp.setContentType("application/json;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        ReturnEntity re = new ReturnEntity();
        if(allProduct.size()>0){
            re.setCode(ReturnCode.REQ_SUCCESS.getCode());
            re.setReturnMsg(ReturnCode.REQ_SUCCESS.getMsg());
            re.setReturnData(allProduct);
            PageInfo pif = new PageInfo(page,pageSize,totalPage);
            re.setPif(pif);
        }else{
            re.setCode(ReturnCode.NO_DATA.getCode());
            re.setReturnMsg(ReturnCode.NO_DATA.getMsg());
            PageInfo pif = new PageInfo(1,0,0);
            re.setPif(pif);
        }
        writer.print(JSON.toJSONString(re));
        writer.flush();
        writer.close();



       /* req.setAttribute("queryProd",myProduct);
        req.setAttribute("page",page);
        req.setAttribute("pageSize",pageSize);
        req.setAttribute("totalPage",totalPage);
        req.setAttribute("listProd",allProduct);
        req.getRequestDispatcher("/mypage/productPage.jsp").forward(req,resp);*/





    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
