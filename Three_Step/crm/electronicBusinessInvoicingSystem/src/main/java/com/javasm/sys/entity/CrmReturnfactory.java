package com.javasm.sys.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.javasm.commons.base.BaseEntity;

/**
 * (CrmReturnfactory)实体类
 *
 * @author makejava
 * @since 2021-07-05 11:11:37
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CrmReturnfactory extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 335137547167434168L;
    /**
     * 返厂单号id
     */
    private Integer fid;
    /**
     * 返厂入库单号
     */
    private String refactoryCode;
    /**
     * 返厂入库标志0.已出库1.已入库
     */
    private Integer refactoryFlag;
    /**
     * 审批状态
     */
    private Integer refactoryState;
    /**
     * 商品编号
     */
    private String returnsId;

    private String crendTime;
    private String upendTime;
    private String uname;

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getCrendTime() {
        return crendTime;
    }

    public void setCrendTime(String crendTime) {
        this.crendTime = crendTime;
    }

    public String getUpendTime() {
        return upendTime;
    }

    public void setUpendTime(String upendTime) {
        this.upendTime = upendTime;
    }

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public String getRefactoryCode() {
        return refactoryCode;
    }

    public void setRefactoryCode(String refactoryCode) {
        this.refactoryCode = refactoryCode;
    }

    public Integer getRefactoryFlag() {
        return refactoryFlag;
    }

    public void setRefactoryFlag(Integer refactoryFlag) {
        this.refactoryFlag = refactoryFlag;
    }

    public Integer getRefactoryState() {
        return refactoryState;
    }

    public void setRefactoryState(Integer refactoryState) {
        this.refactoryState = refactoryState;
    }

    public String getReturnsId() {
        return returnsId;
    }

    public void setReturnsId(String returnsId) {
        this.returnsId = returnsId;
    }

}
