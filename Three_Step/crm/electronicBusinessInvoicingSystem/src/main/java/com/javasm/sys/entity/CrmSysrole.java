package com.javasm.sys.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.javasm.commons.base.BaseEntity;

/**
 * (CrmSysrole)实体类
 *
 * @author makejava
 * @since 2021-07-02 11:00:48
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CrmSysrole extends BaseEntity implements Serializable {
    private static final long serialVersionUID = -35126008664962619L;
    /**
     * 角色id
     */
    private Integer rid;
    /**
     * 角色名称
     */
    private String rname;
    /**
     * 角色编码
     */
    private String rcode;
    /**
     * 角色描述
     */
    private String rdesc;
    /**
     * 角色状态-1无效0.有效
     */
    private Integer rstate;
    /**
     * 部门编号
     */
    private Integer deptno;


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

    public String getRcode() {
        return rcode;
    }

    public void setRcode(String rcode) {
        this.rcode = rcode;
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

}
