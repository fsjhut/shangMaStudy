package com.javasm.sys.entity;

import com.javasm.base.BaseEntity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 系统管理-部门管理
 * (Sysdept)实体类
 *
 * @author makejava
 * @since 2021-06-18 15:29:17
 */

public class Sysdept extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 561689768530049892L;

    private Integer did;

    private String dname;

    private String duser;

    private String duphone;

    private Integer dparentid;

    private String createTime;

    private String updateTime;

    private List<Sysdept> children=new ArrayList<>();

    public List<Sysdept> getChildren() {
        return children;
    }

    public void setChildren(List<Sysdept> children) {
        this.children = children;
    }


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
