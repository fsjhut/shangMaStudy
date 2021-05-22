package com.test.servlet;

import com.alibaba.fastjson.JSON;
import com.test.entity.MyCity;
import com.test.entity.ReturnCode;
import com.test.entity.ReturnEntity;
import com.test.service.impl.CityService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @className: GetCity
 * @description:   
 * @author SunHang
 * @createTime 2021/5/22 9:55
 */
@WebServlet("/getarea")
public class GetCity extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /* 允许跨域的主机地址 */
        resp.setHeader("Access-Control-Allow-Origin", "http://127.0.0.1:8848");
        /* 允许跨域的请求方法GET, POST, HEAD 等 */
        resp.setHeader("Access-Control-Allow-Methods", "*");
        /* 重新预检验跨域的缓存时间 (s) */
        resp.setHeader("Access-Control-Max-Age", "3600");
        /* 允许跨域的请求头 */
        resp.setHeader("Access-Control-Allow-Headers", "*");
        /* 是否携带cookie */
        resp.setHeader("Access-Control-Allow-Credentials", "true");

        req.setCharacterEncoding("utf-8");

/*      BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
        String s = br.readLine();
        System.out.println(s);*/
        Integer pid = Integer.parseInt(req.getParameter("pcode"));
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        CityService cityService = new CityService();
        List<MyCity> myCities = cityService.selectByPid(pid);
        ReturnEntity re = new ReturnEntity();
        if(myCities.size()>0){
            re.setCode(ReturnCode.REQ_SUCCESS.getCode());
            re.setReturnMsg(ReturnCode.REQ_SUCCESS.getMsg());
            re.setReturnData(myCities);
        }else{
            re.setCode(ReturnCode.NO_DATA.getCode());
            re.setReturnMsg(ReturnCode.NO_DATA.getMsg());
        }
        // 将对象ReturnEntity()转为json
        writer.print(JSON.toJSONString(re));
        writer.flush();
        writer.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
