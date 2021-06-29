package com.javasm.sys.entity;

import com.javasm.base.BaseEntity;

import java.io.Serializable;


public class Sysrole extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 969353176766255076L;

    private Integer rid;

    private String rname;

    private String rdesc;


    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
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

}
