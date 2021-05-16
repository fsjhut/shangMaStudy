package com.javasm.controller2;

import com.alibaba.fastjson.JSON;
import com.javasm.entity.MyArea;
import com.javasm.entity.ReturnCode;
import com.javasm.entity.ReturnEntity;
import com.javasm.service.AreaService;
import com.javasm.service.impl.AreaServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/getarea")
public class AreaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
/*获取地区服务接口
 * 接口访问地址  : getarea
 * 接收的参数    : pcode  上级数据的编号
 * 接收方式      : get/post
 * 返回数据格式  :json
 * 返回数据示例  :  {"code":10001,
 *                   "returnMsg":"用户名可用",
 *                   "returnData":[{"areaCode":100000,"areaName":"xxxxxx"},
 *                                {"areaCode":200000,"areaName":"xxxxxx"}]
 *                   }
*
*
*   附加文档 状态码表
*     NAME_OK(10001,"用户名可用"),
    NAME_DUP(10003,"用户名重复"),
    REQ_SUCCESS(20001,"请求成功"),
    REQ_FAILED(50000,"请求失败");
*
*
* */

        req.setCharacterEncoding("utf-8");
        String pcodeStr = req.getParameter("pcode");

        /*
        *
        * 参数转换时 需要判断 数据为空的情况
        * getarea? 没有传参
        * pcodeStr==null
        * getarea?pcode=&xxx= 参数是空字符串
        * "".equals(pcodeStr)
        * */
        Integer pcode = 0;
        if(pcodeStr!=null&&!"".equals(pcodeStr)){
            pcode = Integer.parseInt(pcodeStr);
        }

        AreaService as = new AreaServiceImpl();
        List<MyArea> areaByParentCode = as.getAreaByParentCode(pcode);

        ReturnEntity re = new ReturnEntity();
        if(areaByParentCode.size()>0){
            //正常情况
            re.setCode(ReturnCode.REQ_SUCCESS.getCode());
            re.setReturnMsg(ReturnCode.REQ_SUCCESS.getMsg());
            re.setReturnData(areaByParentCode);
        }else{
            //异常情况
            re.setCode(ReturnCode.REQ_FAILED.getCode());
            re.setReturnMsg(ReturnCode.REQ_FAILED.getMsg());
        }

        resp.setContentType("application/json;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        //使用工具 把需要返回的数据 转成json格式字符串
        writer.print(JSON.toJSONString(re));
        writer.flush();
        writer.close();


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
