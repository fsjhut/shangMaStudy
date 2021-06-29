package com.javasm.sys.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.javasm.commons.base.BaseEntity;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Syspermission extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 650012417485244217L;

    private Integer perid;

    private String pername;

    private String perurl;

    private String pericon;

    private Integer parentid;

    private Integer persort;


    public Integer getPerid() {
        return perid;
    }

    public void setPerid(Integer perid) {
        this.perid = perid;
    }

    public String getPername() {
        return pername;
    }

    public void setPername(String pername) {
        this.pername = pername;
    }

    public String getPerurl() {
        return perurl;
    }

    public void setPerurl(String perurl) {
        this.perurl = perurl;
    }

    public String getPericon() {
        return pericon;
    }

    public void setPericon(String pericon) {
        this.pericon = pericon;
    }

    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    public Integer getPersort() {
        return persort;
    }

    public void setPersort(Integer persort) {
        this.persort = persort;
    }

}
