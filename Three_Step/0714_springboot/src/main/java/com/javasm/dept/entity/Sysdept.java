package com.javasm.dept.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * (Sysdept)实体类
 *
 * @author makejava
 * @since 2021-07-14 20:16:18
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@TableName("Sysdept")
public class Sysdept implements Serializable {
    private static final long serialVersionUID = 384797308533465678L;
    /**
     * 部门id
     */
    private Integer deptId;
    /**
     * 部门名字
     */
    private String deptName;
    /**
     * 部门所属的父级部门的id
     */
    private Integer deptParentId;
    /**
     * 部门负责人的用户id
     */
    private Integer deptManagerId;
    /**
     * 部门的电话
     */
    private String deptPhone;
    /**
     * 更新部门信息的时间
     */
    private String updateTime;


    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Integer getDeptParentId() {
        return deptParentId;
    }

    public void setDeptParentId(Integer deptParentId) {
        this.deptParentId = deptParentId;
    }

    public Integer getDeptManagerId() {
        return deptManagerId;
    }

    public void setDeptManagerId(Integer deptManagerId) {
        this.deptManagerId = deptManagerId;
    }

    public String getDeptPhone() {
        return deptPhone;
    }

    public void setDeptPhone(String deptPhone) {
        this.deptPhone = deptPhone;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

}
