package com.javasm.sys.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.javasm.commons.base.BaseEntity;

/**
 * (SysdictsType)实体类
 *
 * @author makejava
 * @since 2021-06-17 15:16:07
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SysdictsType extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 937514685027504782L;

    private Integer did;

    private String dname;

    private String dkey;

    private String ddesc;


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

    public String getDkey() {
        return dkey;
    }

    public void setDkey(String dkey) {
        this.dkey = dkey;
    }

    public String getDdesc() {
        return ddesc;
    }

    public void setDdesc(String ddesc) {
        this.ddesc = ddesc;
    }

}
