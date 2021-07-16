package com.javasm.sys.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 系统管理-部门管理
 * (Sysdept)实体类
 *
 * @author makejava
 * @since 2021-07-12 17:47:51
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Sysdept implements Serializable {
    private static final long serialVersionUID = -59394675771119907L;

    private Integer did;

    private String dname;

    private String duser;

    private String duphone;

    private Integer dparentid;

    private String createTime;

    private String updateTime;


    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getDuser() {
        return duser;
    }

    public void setDuser(String duser) {
        this.duser = duser;
    }

    public String getDuphone() {
        return duphone;
    }

    public void setDuphone(String duphone) {
        this.duphone = duphone;
    }

    public Integer getDparentid() {
        return dparentid;
    }

    public void setDparentid(Integer dparentid) {
        this.dparentid = dparentid;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

}
