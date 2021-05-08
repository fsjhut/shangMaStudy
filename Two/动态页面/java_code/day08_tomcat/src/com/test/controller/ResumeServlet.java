package com.test.controller;

import com.alibaba.fastjson.JSON;
import com.test.Bean.Person;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置编码格式，告诉tomcat，利用什么编码格式来解析数据  用来处理请求时的乱码 使用细节：在getParameter之前执行
        req.setCharacterEncoding("utf-8");
        //name=h+s&age=22&prov=110000&city=110100&county=110101&areaDetail=weqrqwer&resume=去玩儿&comment=我去二
        // 获取url中的参数  参数名为 name
        String name = req.getParameter("name");
        String age = req.getParameter("age");
        String gender = req.getParameter("gender");
//        String prov = req.getParameter("prov");
//        String city = req.getParameter("city");
        String city = "10220";
        String county = "10220";
        String prov = "10220";
//        String county = req.getParameter("county");
        String areaDetail = req.getParameter("areaDetail");
        String resume = req.getParameter("resume");
        String comment = req.getParameter("comment");
        // 将数据封装为一个对象
        Person person = stringToObj(name, age, gender, prov, city, county, areaDetail, resume, comment);
        // 设置响应头,根据什么格式解析数据 --处理响应乱码---告诉游览器如何处理响应报文
//        String htmlStr = objToHtml(person);
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.print("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "<meta charset=\"UTF-8\">\n" +
                "<title>Title</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<b>姓名</b>:" + person.getName()+ "\n" +
                "<b>年龄</b>:" + person.getAge()+ "\n" +
                "<b>籍贯</b>:" + person.getAreaDetail()+ "\n" +
                req.getParameter("city") + "\n" +
                req.getParameter("coun") + "\n" +
                "<b>地址</b>:" + person.getAreaDetail()+ "\n" +
                "<b>性别</b>:" + person.getGender()+ "\n" +
                "<b>简介</b>:" + person.getResume() + "\n" +
                "<b>备注</b>:" + person.getComment() + "\n" +
                "</body>\n" +
                "</html>");
        writer.flush();
        writer.close();
    }

    private String objToHtml(Person person){
        try (BufferedReader reader = new BufferedReader(new FileReader("../web/person.html"))) {
            reader.readLine();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Person stringToObj(String name, String age, String gender, String prov,
                               String city, String county, String areaDetail,
                               String resume, String comment) {
        Integer newAge = Integer.parseInt(age);
        Character newGender = null;
        if ("1".equals(gender)) {
            newGender = '女';
        } else if ("0".equals(gender)) {
            newGender = '男';
        }
        Integer newPre = Integer.parseInt(prov);
        Integer newCity = Integer.parseInt(city);
        Integer newCounty = Integer.parseInt(county);
        return new Person(name, newAge, newGender, newPre, newCity, newCounty, areaDetail, resume, comment);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
