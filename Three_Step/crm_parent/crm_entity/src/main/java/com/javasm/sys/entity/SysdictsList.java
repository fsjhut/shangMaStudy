package com.javasm.sys.entity;

import com.javasm.base.BaseEntity;

import java.io.Serializable;

public class SysdictsList extends BaseEntity implements Serializable {
    private static final long serialVersionUID = -47390765792334234L;

    private Integer lid;

    private String lname;

    private String lkey;

    private String dkey;

    private Integer lsort;


    public Integer getLid() {
        return lid;
    }

    public void setLid(Integer lid) {
        this.lid = lid;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getLkey() {
        return lkey;
    }

    public void setLkey(String lkey) {
        this.lkey = lkey;
    }

    public String getDkey() {
        return dkey;
    }

    public void setDkey(String dkey) {
        this.dkey = dkey;
    }

    public Integer getLsort() {
        return lsort;
    }

    public void setLsort(Integer lsort) {
        this.lsort = lsort;
    }

}
