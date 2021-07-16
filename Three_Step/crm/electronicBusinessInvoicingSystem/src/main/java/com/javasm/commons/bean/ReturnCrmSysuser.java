package com.javasm.commons.bean;

/**
 * @className:ReturnCrmSysuser
 * @author:NO
 * @date:2021/6/3019:24
 * @version:0.1
 * @since:1.8
 **/
public class ReturnCrmSysuser {
    private Integer uid;
    private String uname;
    private String realname;
    private String dname;
    private Integer sexvalue;
    private Integer ustate;
    private Integer ujob;
    private String uphone;
    private String uemail;
    private String rname;
    private String upassword;
    private Integer deptno;

    public Integer getDeptno() {
        return deptno;
    }

    public void setDeptno(Integer deptno) {
        this.deptno = deptno;
    }

    public String getUpassword() {
        return upassword;
    }

    public void setUpassword(String upassword) {
        this.upassword = upassword;
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

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public Integer getSexvalue() {
        return sexvalue;
    }

    public void setSexvalue(Integer sexvalue) {
        this.sexvalue = sexvalue;
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

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }
}
