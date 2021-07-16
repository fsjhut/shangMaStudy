package com.javasm.sys.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.javasm.commons.base.BaseEntity;

/**
 * (CrmSyspermission)实体类
 *
 * @author makejava
 * @since 2021-07-02 11:25:23
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CrmSyspermission extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 544005587606605396L;
    /**
     * 权限id
     */
    private Integer qid;
    /**
     * 权限名称
     */
    private String qname;
    /**
     * 权限描述
     */
    private String qdesc;
    /**
     * 权限状态-1无效0.有效
     */
    private Integer qstate;
    /**
     * 权限范围-1.录入0.提交1.审核
     */
    private String qhandle;


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

    public String getQdesc() {
        return qdesc;
    }

    public void setQdesc(String qdesc) {
        this.qdesc = qdesc;
    }

    public Integer getQstate() {
        return qstate;
    }

    public void setQstate(Integer qstate) {
        this.qstate = qstate;
    }

    public String getQhandle() {
        return qhandle;
    }

    public void setQhandle(String qhandle) {
        this.qhandle = qhandle;
    }
}
