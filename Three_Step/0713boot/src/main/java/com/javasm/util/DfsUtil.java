package com.javasm.util;

import cn.hutool.core.io.IoUtil;
import cn.hutool.extra.spring.SpringUtil;
import com.github.tobato.fastdfs.domain.fdfs.MetaData;
import com.github.tobato.fastdfs.domain.fdfs.StorageNode;
import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import com.github.tobato.fastdfs.domain.proto.storage.DownloadCallback;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import com.github.tobato.fastdfs.service.TrackerClient;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;


public class DfsUtil {

    public static String uploadFile(InputStream in ,long size,String filename){
        FastFileStorageClient bean = SpringUtil.getBean(FastFileStorageClient.class);

        // 后缀名
        String extName=filename.substring(filename.lastIndexOf(".")+1);
        Set<MetaData> datas = new HashSet<>();
        datas.add(new MetaData("upload_time",System.currentTimeMillis()+""));
        datas.add(new MetaData("real_name",filename));
        datas.add(new MetaData("file_size",size+""));

        StorePath storePath = bean.uploadFile(in, size, extName, datas);
        return storePath.getFullPath();
    }

    public static String uploadImg2HttpPath(InputStream in ,long size,String filename){
        FastFileStorageClient bean = SpringUtil.getBean(FastFileStorageClient.class);
        TrackerClient tc = SpringUtil.getBean(TrackerClient.class);
        String port = SpringUtil.getProperty("fdfs.http-port");

        String extName=filename.substring(filename.lastIndexOf(".")+1);

        Set<MetaData> datas = new HashSet<>();
        datas.add(new MetaData("upload_time",System.currentTimeMillis()+""));
        datas.add(new MetaData("real_name",filename));
        datas.add(new MetaData("file_size",size+""));

        StorePath storePath = bean.uploadFile(in, size, extName, datas);
        String fullPath = storePath.getFullPath();

        StorageNode storeStorage = tc.getStoreStorage();
        String ip = storeStorage.getIp();
        return "http://"+ip+":"+port+"/"+fullPath;
    }

    public static String[] uploadImgThumb2HttpPath(InputStream in, long size, String filename) {
        FastFileStorageClient bean = SpringUtil.getBean(FastFileStorageClient.class);
        TrackerClient tc = SpringUtil.getBean(TrackerClient.class);
        String port = SpringUtil.getProperty("fdfs.http-port");
        String width = SpringUtil.getProperty("fdfs.thumb-image.width");
        String height = SpringUtil.getProperty("fdfs.thumb-image.height");

        String extName=filename.substring(filename.lastIndexOf(".")+1);

        Set<MetaData> datas = new HashSet<>();
        datas.add(new MetaData("upload_time",System.currentTimeMillis()+""));
        datas.add(new MetaData("real_name",filename));
        datas.add(new MetaData("file_size",size+""));

        StorePath storePath = bean.uploadImageAndCrtThumbImage(in, size, extName, datas);
        String fullPath = storePath.getFullPath();//group1/M00/00/14/wKgU_GDtSXaAEuFMAAA-NMSV1yM91.jpg
        String thumbPath = fullPath.substring(0,fullPath.lastIndexOf("."))+"_"+width+"x"+height+"."+extName;
        StorageNode storeStorage = tc.getStoreStorage();
        String ip = storeStorage.getIp();
        String bigImg = "http://"+ip+":"+port+"/"+fullPath;
        String thumbImg = "http://"+ip+":"+port+"/"+thumbPath;
        return new String[]{bigImg,thumbImg};
    }

    public static FileEntity getMetaDatas(String path) {
        FileEntity e = new FileEntity();
//        group1/M00/00/14/wKgU_GDtWUKAFLWoAAA-NMSV1yM84.java
        FastFileStorageClient bean = SpringUtil.getBean(FastFileStorageClient.class);
        String groupName=path.substring(0,path.indexOf("/"));
        String storePath = path.substring(path.indexOf("/")+1);
        System.out.println(groupName);
        System.out.println(storePath);
        Set<MetaData> metadata = bean.getMetadata(groupName, storePath);
        System.out.println(metadata);
        for (MetaData t : metadata) {
            String name = t.getName();
            String value = t.getValue();
            if(name.equals("upload_time")){
                e.setUploadTime(value);
            }else if(name.equals("real_name")){
                e.setRealName(value);
            }else if(name.equals("file_size")){
                e.setSize(value);
            }
        }
        return e;
//        bean.getMetadata("","");
    }

    public static FileEntity download(String path) {
        FileEntity e = getMetaDatas(path);

        FastFileStorageClient bean = SpringUtil.getBean(FastFileStorageClient.class);
        String groupName=path.substring(0,path.indexOf("/"));
        String storePath = path.substring(path.indexOf("/")+1);
        byte[] bytes = bean.downloadFile(groupName, storePath,IoUtil::readBytes);
//        byte[] bytes1 = bean.downloadFile(groupName, storePath, new DownloadCallback<byte[]>() {
//            @Override
//            public byte[] recv(InputStream ins) throws IOException {
//                byte[] bytes1 = IoUtil.readBytes(ins);
//                return bytes1;
//            }
//        });
        e.setBytes(bytes);

        return e;

    }

    public static void del(String path) {
        FastFileStorageClient bean = SpringUtil.getBean(FastFileStorageClient.class);
        bean.deleteFile(path);
    }
}
