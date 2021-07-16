package com.javasm.commons.utils;

import cn.hutool.core.io.IoUtil;
import org.apache.commons.io.IOUtils;
import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class DfsUtil {
    private static TrackerClient client = null;
    private static String REAL_NAME="realName";
    private static String FILE_SIZE="size";
    private static String UPLOAD_TIME="uploadTime";
    private static String UPLOAD_BY="uploadBy";

    static{
        try {
            String confPath = Objects.requireNonNull(DfsUtil.class.getClassLoader().
                    getResource("\\conf\\fdfs_client.conf")).getPath();
            //1.加载配置文件,配置信息加载静态类ClientGlobal中.
            ClientGlobal.init(confPath);
            int g_tracker_http_port = ClientGlobal.getG_tracker_http_port();
            //2.初始化TrackerClient对象
            client = new TrackerClient();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String uploadImg(byte[] bytes,String realName,Long size,String by){
        if(bytes==null) {
            return null;
        }
        String extName = realName.substring(realName.lastIndexOf(".") + 1);

        TrackerServer trackerServer =null;
        StorageServer storageServer = null;
        StorageClient1 storageClient1 = null;
        try {
            trackerServer = client.getConnection();//得到某台具体的跟踪服务器对象
            String hostName = trackerServer.getSocket().getInetAddress().getHostName();

            //工具
            storageClient1 = new StorageClient1(trackerServer,storageServer);//存储服务器的工具类对象,操作存储服务器

            String s = storageClient1.upload_file1(bytes, extName, null);//此时会对storageServer存储服务器进行赋值,从跟踪服务器中获取可用的存储服务器
            return "http://"+hostName+":"+ClientGlobal.getG_tracker_http_port()+"/"+s;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(storageServer!=null) {
                try {
                    storageServer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(trackerServer!=null){
                try {
                    trackerServer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    public static String upload(byte[] bytes,String realName,Long size,String by){
        if(bytes==null) {
            return null;
        }
        String extName = realName.substring(realName.lastIndexOf(".") + 1);

        TrackerServer trackerServer =null;
        StorageServer storageServer = null;
        StorageClient1 storageClient1 = null;
        try {
            trackerServer = client.getConnection();//得到某台具体的跟踪服务器对象
            //工具
            storageClient1 = new StorageClient1(trackerServer,storageServer);//存储服务器的工具类对象,操作存储服务器
            //元数据信息
            NameValuePair[] metaDatas = new NameValuePair[]{
                new NameValuePair(REAL_NAME,realName),
                new NameValuePair(FILE_SIZE,size+""),
                new NameValuePair(UPLOAD_TIME,DateUtil.getYMDHMS()),
                new NameValuePair(UPLOAD_BY,by)
            };
            String s = storageClient1.upload_file1(bytes, extName, metaDatas);//此时会对storageServer存储服务器进行赋值,从跟踪服务器中获取可用的存储服务器
            return s;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(storageServer!=null) {
                try {
                    storageServer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(trackerServer!=null){
                try {
                    trackerServer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    public static Map<String,String> getMetaDatas(String path){
        if(path==null||"".equals(path)) {
            return null;
        }
        Map<String,String> datas = new HashMap<>();
        TrackerServer trackerServer =null;
        StorageServer storageServer = null;
        StorageClient1 storageClient1 = null;
        try {
            trackerServer = client.getConnection();//得到某台具体的跟踪服务器对象
            //工具
            storageClient1 = new StorageClient1(trackerServer,storageServer);//存储服务器的工具类对象,操作存储服务器
            NameValuePair[] metadata1 = storageClient1.get_metadata1(path);
            for (NameValuePair nameValuePair : metadata1) {
                datas.put(nameValuePair.getName(),nameValuePair.getValue());
            }
            return datas;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (storageServer == null) {
            } else {
                try {
                    storageServer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(trackerServer!=null){
                try {
                    trackerServer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    public static String getRealName(Map<String, String> metaDatas){
        return metaDatas.get(REAL_NAME);
    }
    public static String getFileSize(Map<String, String> metaDatas){
        return metaDatas.get(FILE_SIZE);
    }
    public static String getUploadTime(Map<String, String> metaDatas){
        return metaDatas.get(UPLOAD_TIME);
    }
    public static String getUploadBy(Map<String, String> metaDatas){
        return metaDatas.get(UPLOAD_BY);
    }


    public static byte[] download(String path) {
        if(path==null||"".equals(path)) {
            return null;
        }

        TrackerServer trackerServer =null;
        StorageServer storageServer = null;
        StorageClient1 storageClient1 = null;
        try {
            trackerServer = client.getConnection();//得到某台具体的跟踪服务器对象
            //工具
            storageClient1 = new StorageClient1(trackerServer,storageServer);//存储服务器的工具类对象,操作存储服务器
            byte[] bytes = storageClient1.download_file1(path);
            return bytes;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(storageServer!=null) {
                try {
                    storageServer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(trackerServer!=null){
                try {
                    trackerServer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    public static boolean delFile(String path) {
        if(path==null||"".equals(path)) {
            return false;
        }

        TrackerServer trackerServer =null;
        StorageServer storageServer = null;
        StorageClient1 storageClient1 = null;
        try {
            trackerServer = client.getConnection();//得到某台具体的跟踪服务器对象
            //工具
            storageClient1 = new StorageClient1(trackerServer,storageServer);//存储服务器的工具类对象,操作存储服务器
            int i = storageClient1.delete_file1(path);
            return i == 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(storageServer!=null) {
                try {
                    storageServer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(trackerServer!=null){
                try {
                    trackerServer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }
}
