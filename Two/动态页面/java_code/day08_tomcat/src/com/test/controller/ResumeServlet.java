package com.test.controller;

import com.test.service.UserService;
import com.test.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * @author SunHang
 * @className: ResumeServlet
 * @description:
 * @createTime 2021/5/7 20:48
 */
@WebServlet("/resume/submit")
public class ResumeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // 设置编码格式，告诉tomcat，利用什么编码格式来解析数据  用来处理请求时的乱码 使用细节：在getParameter之前执行
        req.setCharacterEncoding("utf-8");
        //name=h+s&age=22&prov=110000&city=110100&county=110101&areaDetail=weqrqwer&resume=去玩儿&comment=我去二
        // 获取url中的参数  参数名为 name
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        String gender = req.getParameter("gender");
        String birth = req.getParameter("birth");
        String prov = req.getParameter("prov");
        String city = req.getParameter("city");
        String county = req.getParameter("county");
        String areaDetail = req.getParameter("areaDetail");
        String resume = req.getParameter("resume");
        String comment = req.getParameter("comment");
//        MyUser tmt = new MyUser("tmt");
        // 调用service中的方法，进行页面数据的处理
        UserService userService = new UserServiceImpl();
        // 设置响应头,根据什么格式解析数据 --处理响应乱码---告诉游览器如何处理响应报文
        resp.setContentType("text/html;charset=utf-8");
        // 得到一个写入html的对象
        PrintWriter writer = resp.getWriter();

        int i = userService.insertUser(name, password, phone, email,gender, birth,prov, city,
                county, areaDetail, resume, comment);
        // 根据 i的不同 来判断是否访问成功
        if(i>0){
            writer.print("<h1>恭喜你注册成功</h1>");
            writer.print("<div>"+name+"</div>");
            writer.print("<div>"+phone+"</div>");
            writer.print("<div>"+password+"</div>");
        }else{
            writer.print("<h1>系统异常 请联系管理员!!!</h1>");
        }
        writer.flush();
        writer.close();
    }

//    private User stringToObj(String name, String password, String phone,
//                             String gender, String birth, String prov, String city,
//                             String county, String areaDetail, String resume, String comment) {
//        Character newGender = null;
//        if ("1".equals(gender)) {
//            newGender = '女';
//        } else if ("0".equals(gender)) {
//            newGender = '男';
//        }
//        return null;
//    }

//    private String objToHtml(User user){
//        try (BufferedReader reader = new BufferedReader(new FileReader("../web/person.html"))) {
//            reader.readLine();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
