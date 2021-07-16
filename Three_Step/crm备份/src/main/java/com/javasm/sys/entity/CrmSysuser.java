package com.javasm.sys.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.javasm.commons.base.BaseEntity;

/**
 * (CrmSysuser)实体类
 *
 * @author makejava
 * @since 2021-06-30 10:29:39
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CrmSysuser extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 591021665961629132L;
    /**
     * 用户id
     */
    private Integer uid;
    /**
     * 用户登录名
     */
    private String uname;
    /**
     * 用户真实姓名
     */
    private String realname;
    /**
     * 用户密码
     */
    private String upassword;
    /**
     * 用户性别
     */
    private String usex;
    /**
     * 用户状态-1.无效.0有效
     */
    private Integer ustate;
    /**
     * 用户职务 0.员工1.经理2.处长
     */
    private Integer ujob;
    /**
     * 用户手机号
     */
    private String uphone;
    /**
     * 用户邮箱
     */
    private String uemail;
    /**
     * 备注信息
     */
    private String udesc;
    /**
     * 部门编号
     */
    private Integer deptno;
    /**
     * 角色id
     */
    private Integer rid;


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

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getUpassword() {
        return upassword;
    }

    public void setUpassword(String upassword) {
        this.upassword = upassword;
    }

    public String getUsex() {
        return usex;
    }

    public void setUsex(String usex) {
        this.usex = usex;
    }

    public Integer getUstate() {
        return ustate;
    }

    public void setUstate(Integer ustate) {
        this.ustate = ustate;
    }

    public Integer getUjob() {
        return ujob;
    }

    public void setUjob(Integer ujob) {
        this.ujob = ujob;
    }

    public String getUphone() {
        return uphone;
    }

    public void setUphone(String uphone) {
        this.uphone = uphone;
    }

    public String getUemail() {
        return uemail;
    }

    public void setUemail(String uemail) {
        this.uemail = uemail;
    }

    public String getUdesc() {
        return udesc;
    }

    public void setUdesc(String udesc) {
        this.udesc = udesc;
    }

    public Integer getDeptno() {
        return deptno;
    }

    public void setDeptno(Integer deptno) {
        this.deptno = deptno;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }
}
