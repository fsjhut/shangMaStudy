package com.javasm.commons.handler;

import com.javasm.commons.entity.AxiosResult;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

@RestController
public class FileHandler {
    //MappingJack2HttpMessageConverter:content-type:application/json
    //CommonsMultipartFileResolver:content-type:multipart/form-data

    //MultipartFile即CommonsMultipartFileResolver文件解析器对象解析了文件数据,得到MultipartFile对象
    @PostMapping("upload")
    public AxiosResult doUploadFile(MultipartFile jl, HttpServletRequest  req) throws IOException {
        byte[] bytes = jl.getBytes();//文件内容,字节数据,适合小文件
        InputStream inputStream = jl.getInputStream();//文件内容,输入流,适合大文件,没啥用
        String originalFilename = jl.getOriginalFilename();//文件名
        long size = jl.getSize();//文件大小
        //存文件
        String realPath = req.getServletContext().getRealPath("/");
        String path = "/upload/"+originalFilename;
        System.out.println(realPath);
        System.out.println(path);
        //原生输出流写数据的过程
        IOUtils.write(bytes,new FileOutputStream(new File(realPath,path)));
        Map<String,Object> result = new HashMap<>();
        result.put("path",path);
        result.put("realName",originalFilename);
        result.put("uploadTime",System.currentTimeMillis());
        result.put("size",size);
        return AxiosResult.suc(result);
    }

    @GetMapping("down")
    public ResponseEntity doDownload(String path,HttpServletRequest req) throws IOException {
        String realPath = req.getServletContext().getRealPath("/");
        File f = new File(realPath,path);
        String filename = f.getName();
        byte[] bytes = FileUtils.readFileToByteArray(f);
        //设置响应头
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition",
                "attachment;filename="+URLEncoder.encode(filename,"UTF-8"));

        return new ResponseEntity(bytes,headers,HttpStatus.OK);
    }
}
