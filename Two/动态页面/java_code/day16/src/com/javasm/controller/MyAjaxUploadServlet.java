package com.javasm.controller;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/ajaxUpload")
public class MyAjaxUploadServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //获取代码运行的在服务器上的本地路径
        String basePath = req.getServletContext().getRealPath("/");
        System.out.println(basePath);
        //拼接上指定的目录(文件夹)
        String folderPath = "upload/";
        String returnPath = "";
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

                if(!fi.isFormField()){
                    //处理文件
                    //文件名  filename 如果是中文，则乱码
                    String filename = fi.getName();
                    File newfile = new File(basePath + folderPath + filename);
                    //从临时文件 写入到本地创建的新文件
                    fi.write(newfile);
                    returnPath = folderPath+filename;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(returnPath);
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.print("{\"imgsrc\":\""+returnPath+"\"}");
        writer.flush();
        writer.close();
    }
}
