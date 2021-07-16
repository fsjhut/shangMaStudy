package com.javasm.commons.bean;

import com.javasm.sys.entity.CrmSyspermission;

import java.util.List;

/**
 * @className:ReturnCrmSysRole
 * @author:NO
 * @date:2021/7/211:10
 * @version:0.1
 * @since:1.8
 **/
public class ReturnCrmSysRole {
    private Integer rid;
    private String rcode;
    private String rname;
    private String rdesc;
    private Integer rstate;
    private Integer deptno;
    private String dname;
    private Integer qid;
    private String qname;
    private List<CrmSyspermission> crmSyspermissions;

    public Integer getQid() {
        return qid;
    }

    public void setQid(Integer qid) {
        this.qid = qid;
    }

    public String getQname() {
        return qname;
    }

    public void setQname(String qname) {
        this.qname = qname;
    }

    public String getRcode() {
        return rcode;
    }

    public void setRcode(String rcode) {
        this.rcode = rcode;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public String getRdesc() {
        return rdesc;
    }

    public void setRdesc(String rdesc) {
        this.rdesc = rdesc;
    }

    public Integer getRstate() {
        return rstate;
    }

    public void setRstate(Integer rstate) {
        this.rstate = rstate;
    }

    public Integer getDeptno() {
        return deptno;
    }

    public void setDeptno(Integer deptno) {
        this.deptno = deptno;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public List<CrmSyspermission> getCrmSyspermissions() {
        return crmSyspermissions;
    }

    public void setCrmSyspermissions(List<CrmSyspermission> crmSyspermissions) {
        this.crmSyspermissions = crmSyspermissions;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }
}
