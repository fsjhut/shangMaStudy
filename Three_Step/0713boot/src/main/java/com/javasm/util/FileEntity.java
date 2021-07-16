package com.javasm.util;

/**
 * @author SunHang
 * @className: FileEntity
 * @description:
 * @createTime 2021/7/13 16:20
 */
public class FileEntity {
    private String realName;
    private String size;
    private String uploadTime;
    private byte[] bytes;

    public FileEntity() {
    }

    public FileEntity(String realName, String size, String uploadTime, byte[] bytes) {
        this.realName = realName;
        this.size = size;
        this.uploadTime = uploadTime;
        this.bytes = bytes;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(String uploadTime) {
        this.uploadTime = uploadTime;
    }

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }
}
