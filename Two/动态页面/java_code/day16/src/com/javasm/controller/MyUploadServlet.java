package com.javasm.controller;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

@WebServlet("/myupload")
public class MyUploadServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*
        * Content-Type: multipart/form-data;
        * req.getParameter("myfile"); 取不到值 服务器不解析
        * */
        req.setCharacterEncoding("utf-8");
        String myfile = req.getParameter("myfile");
        String uname = req.getParameter("uname");
        System.out.println(myfile);
        System.out.println(uname);
        //获取代码运行的在服务器上的本地路径
        String basePath = req.getServletContext().getRealPath("/");
        System.out.println(basePath);
        //拼接上指定的目录(文件夹)
        String folderPath = "upload/";

        boolean multipartContent = ServletFileUpload.isMultipartContent(req);
        System.out.println(multipartContent);

        //创建本地文件临时工厂
        DiskFileItemFactory dff = new DiskFileItemFactory();
        //解析输入流核心对象
        ServletFileUpload servletFileUpload = new ServletFileUpload(dff);

        try {
            //解析后封装成的文件对象
            List<FileItem> list = servletFileUpload.parseRequest(req);
            for(FileItem fi:list){
                // 判断是否是文件
                if(!fi.isFormField()){
                    //处理文件
                    //文件名
                    // filename如果有中文，则是乱码。。
                    String filename = fi.getName();
                    System.out.println(filename);
//                    String newFileName = new String(filename.getBytes("iso-8859-1"), "utf-8");
//                    System.out.println(newFileName);
                    File newfile = new File(basePath + folderPath + filename);
                    //从临时文件 写入到本地创建的新文件
                    fi.write(newfile);
                    System.out.println("写入成功");
                }else{
                    //处理普通表单字段
                    String fieldName = fi.getFieldName();
                    if("uname".equals(fieldName)){
                        String string = fi.getString();
                        String newstr = new String(string.getBytes("iso-8859-1"), "utf-8");
                        System.out.println("取到的uname的值:"+ newstr);
                    }
                }
            }
            System.out.println(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
