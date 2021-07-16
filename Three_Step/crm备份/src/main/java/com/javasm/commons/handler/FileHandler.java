package com.javasm.commons.handler;

import com.javasm.commons.entity.AxiosResult;
import com.javasm.commons.utils.CurrentLoginUser;
import com.javasm.commons.utils.DfsUtil;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
@RequestMapping("file")
public class FileHandler {
    //MappingJack2HttpMessageConverter:content-type:application/json
    //CommonsMultipartFileResolver:content-type:multipart/form-data

    //MultipartFile即CommonsMultipartFileResolver文件解析器对象解析了文件数据,得到MultipartFile对象
    @PostMapping("upload")
    public AxiosResult doUploadFile(MultipartFile file, HttpServletRequest  req) throws IOException {
        byte[] bytes = file.getBytes();//文件内容,字节数据,适合小文件
        InputStream inputStream = file.getInputStream();//文件内容,输入流,适合大文件,没啥用
        String originalFilename = file.getOriginalFilename();//文件名
        long size = file.getSize();//文件大小

        //文件保存fastdfs中.
        String path = DfsUtil.upload(bytes, originalFilename, size, CurrentLoginUser.getUname());

        Map<String,Object> result = new HashMap<>();
        result.put("path",path);
        result.put("realName",originalFilename);
        result.put("uploadTime",System.currentTimeMillis());
        result.put("size",size);
        return AxiosResult.suc(result);
    }

    @PostMapping("uploadimg")
    public AxiosResult doUploadImg(MultipartFile jl) throws IOException {
        byte[] bytes = jl.getBytes();//文件内容,字节数据,适合小文件
        String originalFilename = jl.getOriginalFilename();//文件名
        long size = jl.getSize();//文件大小

        //文件保存fastdfs中.
        String path = DfsUtil.uploadImg(bytes, originalFilename, size, CurrentLoginUser.getUname());
        Map<String,Object> result = new HashMap<>();
        result.put("path",path);
        result.put("realName",originalFilename);
        result.put("uploadTime",System.currentTimeMillis());
        result.put("size",size);
        return AxiosResult.suc(result);
    }

    @GetMapping("down")
    public ResponseEntity doDownload(String path,HttpServletRequest req) throws IOException {
        Map<String, String> metaDatas = DfsUtil.getMetaDatas(path);
        String filename = DfsUtil.getRealName(metaDatas);
        byte[] bytes = DfsUtil.download(path);

        //设置响应头
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition","attachment;filename="+URLEncoder.encode(filename,"UTF-8"));
        // 将文件相关信息写入到响应头中，供前端获取
        headers.setAll(metaDatas);
        return new ResponseEntity(bytes,headers,HttpStatus.OK);
    }

    @GetMapping("del")
    public AxiosResult doDel(String path) throws IOException {
        boolean b = DfsUtil.delFile(path);
        return AxiosResult.suc();
    }
}
