package com.javasm.sys.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.javasm.commons.base.BaseEntity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * (TbDept)实体类
 *
 * @author makejava
 * @since 2021-06-29 22:58:34
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Dept extends BaseEntity implements Serializable {
    private static final long serialVersionUID = -99661726535189401L;
    /**
     * 部门id
     */
    private Integer id;
    /**
     * 部门名称
     */
    private String dname;
    /**
     * 部门编号
     */
    private Integer deptno;
    /**
     * 是否启用
     */
    private Integer isEnabled;
    /**
     * 设为顶级部门
     */
    private Integer topDepartment;
    /**
     * 上级部门名称
     */
    private String sname;

    /**
     * 定义一个统计变量，用来接收查询数量
     */
    private Integer personNum;

    /**
     * 定义一个集合集合用户存储部门下的子部门
     */
    private List<Dept> deptList = new ArrayList<>();

    public Dept() {
    }

    public List<Dept> getDeptList() {
        return deptList;
    }

    public void setDeptList(List<Dept> deptList) {
        this.deptList = deptList;
    }

    public Integer getPersonNum() {
        return personNum;
    }

    public void setPersonNum(Integer personNum) {
        this.personNum = personNum;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public Integer getDeptno() {
        return deptno;
    }

    public void setDeptno(Integer deptno) {
        this.deptno = deptno;
    }

    public Integer getIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(Integer isEnabled) {
        this.isEnabled = isEnabled;
    }

    public Integer getTopDepartment() {
        return topDepartment;
    }

    public void setTopDepartment(Integer topDepartment) {
        this.topDepartment = topDepartment;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "id=" + id +
                ", dname='" + dname + '\'' +
                ", deptno=" + deptno +
                ", isEnabled=" + isEnabled +
                ", topDepartment=" + topDepartment +
                ", sname='" + sname + '\'' +
                ", personNum=" + personNum +
                '}';
    }
}
