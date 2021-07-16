package com.javasm.sys.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * (Sysuser)实体类
 *
 * @author makejava
 * @since 2021-07-14 16:21:24
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@TableName(value = "sysuser")
public class Sysuser implements Serializable {
    private static final long serialVersionUID = 274310266305423801L;
    /**
     * 用户id
     */
    @TableId(value = "uid",type = IdType.ASSIGN_ID)
    private String uid;
    /**
     * 用户名字
     */
    private String uname;
    /**
     * 用户密码
     */
    private String upwd;
    /**
     * 用户的手机号
     */
//  @TableField(condition = "%s like concat('%%',#{%s},'%%')")
    @TableField(condition = SqlCondition.LIKE)
    private String uphone;
    /**
     * 用户的微信号
     */
    private String uwechat;
    /**
     * 用户的邮箱
     */
    private String uemail;
    /**
     * 用户的性别
     */
    private Integer userGender;
    /**
     * 用户所属角色的id
     */
    private Integer rid;
    /**
     * 用户所属部门的id
     */
    private Integer deptId;
    /**
     * 创建该用户的时间
     */
    private String createTime;
    /**
     * 修改用户的时间
     */
    private String updateTime;
    /**
     * 创建人
     */
    private String createBy;

    @Override
    public String toString() {
        return "Sysuser{" +
                "uid='" + uid + '\'' +
                ", uname='" + uname + '\'' +
                ", upwd='" + upwd + '\'' +
                ", uphone='" + uphone + '\'' +
                ", uwechat='" + uwechat + '\'' +
                ", uemail='" + uemail + '\'' +
                ", userGender=" + userGender +
                ", rid=" + rid +
                ", deptId=" + deptId +
                ", createTime='" + createTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", createBy='" + createBy + '\'' +
                ", test2='" + test2 + '\'' +
                ", version=" + version +
                '}';
    }

    // 数据库中没有这个字段。
    @TableField(exist = false)
    private String test2;

    @Version
    private Integer version;

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
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

    public Integer getUserGender() {
        return userGender;
    }

    public void setUserGender(Integer userGender) {
        this.userGender = userGender;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
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

}
