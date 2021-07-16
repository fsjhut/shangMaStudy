package com.javasm.sys.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * 系统用户表(Sysuser)实体类
 *
 * @author makejava
 * @since 2021-07-13 09:48:53
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Sysuser implements Serializable {
    private static final long serialVersionUID = -50072734622720037L;

    private Integer uid;

    private String uname;

    private String upwd;

    private String uphone;

    private String uwechat;

    private String uemail;

    private String createTime;

    private String updateTime;

    private String createBy;
    /**
     * 角色id
     */
    private Integer rid;

    private Integer usex;

    private Integer did;

    private String uposition;

    @Override
    public String toString() {
        return "Sysuser{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", upwd='" + upwd + '\'' +
                ", uphone='" + uphone + '\'' +
                ", uwechat='" + uwechat + '\'' +
                ", uemail='" + uemail + '\'' +
                ", createTime='" + createTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", createBy='" + createBy + '\'' +
                ", rid=" + rid +
                ", usex=" + usex +
                ", did=" + did +
                ", uposition='" + uposition + '\'' +
                '}';
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpwd() {
        return upwd;
    }

    public void setUpwd(String upwd) {
        this.upwd = upwd;
    }

    public String getUphone() {
        return uphone;
    }

    public void setUphone(String uphone) {
        this.uphone = uphone;
    }

    public String getUwechat() {
        return uwechat;
    }

    public void setUwechat(String uwechat) {
        this.uwechat = uwechat;
    }

    public String getUemail() {
        return uemail;
    }

    public void setUemail(String uemail) {
        this.uemail = uemail;
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

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Integer getUsex() {
        return usex;
    }

    public void setUsex(Integer usex) {
        this.usex = usex;
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public String getUposition() {
        return uposition;
    }

    public void setUposition(String uposition) {
        this.uposition = uposition;
    }

}
