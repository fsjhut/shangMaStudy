package test.controller;

import com.alibaba.fastjson.JSON;
import test.entity.MyProduct;
import test.entity.PageInfo;
import test.entity.ReturnCode;
import test.entity.ReturnEntity;
import test.service.ProdService;
import test.service.impl.ProdServiceImpl;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @className: AjaxProdServlet
 * @description:   
 * @author SunHang
 * @createTime 2021/5/14 20:52
 */
@WebServlet("/ajaxprod/*")
public class AjaxProdServlet extends baseServlet {

    public void ajaxquery(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
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
        // 将查询 到的数据库的数据转为json格式
        List<MyProduct> allProduct = ps.getAllProduct(page,pageSize,myProduct);
        Integer totalPage = ps.getTotalPage(pageSize,myProduct);
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        ReturnEntity re = new ReturnEntity();
        System.out.println(re);
        // 判断是否查询到数据
        if(allProduct.size()>0){
            re.setCode(ReturnCode.REQ_SUCCESS.getCode());
            re.setReturnMsg(ReturnCode.REQ_SUCCESS.getMsg());
            re.setReturnData(allProduct);
            PageInfo pageInfo = new PageInfo(page, pageSize, totalPage);
            re.setPif(pageInfo);
        }else{
            re.setCode(ReturnCode.NO_DATA.getCode());
            re.setReturnMsg(ReturnCode.NO_DATA.getMsg());
            PageInfo pageInfo = new PageInfo(1, 0, 0);
            re.setPif(pageInfo);
        }
        // 将对象ReturnEntity()转为json
        writer.print(JSON.toJSONString(re));
        writer.flush();
        writer.close();
    }
    public void ajaxadd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
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
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.print(JSON.toJSONString(returnObj(resNum)));
        System.out.println(JSON.toJSONString(returnObj(resNum)));
        writer.flush();
        writer.close();
    }
    public void readyForEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        // 获取需要修改的数据
        req.setCharacterEncoding("utf-8");
        String prodId = req.getParameter("prodId");
        ProdService prodService = new ProdServiceImpl();
        MyProduct oldProduct = prodService.getProductById(prodId);
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter writer = resp.getWriter();
//        System.out.println(oldProduct);
        writer.print(JSON.toJSONString(returnObj(oldProduct)));
        writer.flush();
        writer.close();
    }
    public void ajaxedit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
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
        Integer resNum = prodService.editProd(myProduct);
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.print(JSON.toJSONString(returnObj(resNum)));
        writer.flush();
        writer.close();
    }
    public void ajaxdelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        req.setCharacterEncoding("utf-8");
        String prodId = req.getParameter("prodId");
        ProdService prodService = new ProdServiceImpl();
        Integer integer = prodService.delProd(prodId);
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.print(JSON.toJSONString(returnObj(integer)));
        writer.flush();
        writer.close();
    }
    private ReturnEntity returnObj(MyProduct product){
        ReturnEntity re = new ReturnEntity();
        if(product!=null){
            re.setCode(ReturnCode.REQ_SUCCESS.getCode());
            re.setReturnMsg(ReturnCode.REQ_SUCCESS.getMsg());
            re.setReturnData(product);
        }else{
            re.setCode(ReturnCode.REQ_FAILED.getCode());
            re.setReturnMsg(ReturnCode.REQ_FAILED.getMsg());
        }
        return re;
    }
    private ReturnEntity returnObj(Integer resNum){
        ReturnEntity re = new ReturnEntity();
        if(resNum>0){
            re.setCode(ReturnCode.REQ_SUCCESS.getCode());
            re.setReturnMsg(ReturnCode.REQ_SUCCESS.getMsg());
        }else{
            re.setCode(ReturnCode.REQ_FAILED.getCode());
            re.setReturnMsg(ReturnCode.REQ_FAILED.getMsg());
        }
        return re;
    }
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        // 接口的文档信息
//        /*获取商品信息服务接口
//         * 接口访问地址  : ajaxprod
//         * 接收的参数    :  page      查询的页码
//         *                 pageSize  每页记录数
//         *                 prodid    商品id
//         *                 prodname  商品名称(模糊查询)
//         * 接收方式      : get/post
//         * 返回数据格式  :json
//         * 返回数据示例  :
//         *               有数据
//         *               {"code":20001,
//         *               "pif":{"page":1,"pageSize":5,"totalPage":2},
//         *               "returnData":[{"prodDesc":"xxxx","prodId":"1322333","prodImg":"img/xx.jpg","prodName":"商品1","prodPrice":300},
//         *                            {"prodDesc":"333","prodId":"1333332","prodImg":"3333","prodName":"1333","prodPrice":33},
//         *                            {"prodDesc":"4444","prodId":"333444","prodImg":"444","prodName":"4444","prodPrice":4444},
//         *                            {"prodDesc":"444","prodId":"4444","prodImg":"444","prodName":"4444","prodPrice":4444},
//         *                            {"prodDesc":"55555","prodId":"555","prodImg":"5555","prodName":"555游戏5","prodPrice":5555}],
//         *               "returnMsg":"请求成功"}
//         *               无数据
//         *               {"code":30001,
//         *               "pif":{"page":1,"pageSize":0,"totalPage":0},
//         *               "returnMsg":"没有数据"}
//         * */
//
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        doGet(req,resp);
//    }
}
