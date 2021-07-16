package com.javasm;

import cn.hutool.core.io.IoUtil;
import com.github.tobato.fastdfs.domain.fdfs.MetaData;
import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import com.javasm.util.DfsUtil;
import com.javasm.util.FileEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

@SpringBootTest
class ApplicationTests {

    @Test
    void upload_file() throws FileNotFoundException {
        File f = new File("E:\\Test.java");
        String name = f.getName();
        InputStream in =new FileInputStream(f);
        String s = DfsUtil.uploadFile(in, f.length(), name);
        System.out.println(s);
        //group1/M00/00/14/wKgU_GDtSXaAEuFMAAA-NMSV1yM91.java
    }

    @Test
    public void upload_Img() throws FileNotFoundException {
        File f = new File("D:\\sss.png");
        String name = f.getName();
        InputStream in =new FileInputStream(f);
        String s = DfsUtil.uploadImg2HttpPath(in, f.length(), name);
        System.out.println(s);
    }

    @Test
    public void upload_ImgAndThumb() throws FileNotFoundException {
        File f = new File("D:\\sss.png");
        String name = f.getName();
        InputStream in =new FileInputStream(f);
        String[] s = DfsUtil.uploadImgThumb2HttpPath(in, f.length(), name);
        System.out.println(s[0]);
        System.out.println(s[1]);
    }

    @Test
    public void getMetas(){
        String path="group1/M00/00/14/wKgU_GDtWUKAFLWoAAA-NMSV1yM84.java";
        FileEntity entity = DfsUtil.getMetaDatas(path);
        System.out.println(entity.getRealName());
    }

    @Test
    public void download() throws FileNotFoundException {
        String path="group1/M00/00/14/wKgU_GDtWUKAFLWoAAA-NMSV1yM84.java";
        FileEntity e = DfsUtil.download(path);
        String realName =e.getRealName();
        byte[] bytes = e.getBytes();//数据
        OutputStream out = new FileOutputStream("D:\\"+realName);
        IoUtil.write(out,true,bytes);
    }

    @Test
    public void del(){

        String path="group1/M00/00/14/wKgU_GDtWUKAFLWoAAA-NMSV1yM84.java";
        DfsUtil.del(path);
    }


}
