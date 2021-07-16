package com.javasm.sys.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.javasm.commons.base.BaseEntity;

/**
 * (OutManager)实体类
 *
 * @author makejava
 * @since 2021-07-05 12:07:19
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OutManager extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 110732486806515482L;
    /**
     * 返厂出库单号
     */
    private Integer outOrderNum;
    /**
     * 返厂出库标志 未出库/已经出库
     */
    private String outMark;
    /**
     * 审核状态 未审核/已经审核/未通过
     */
    private String auditStatus;
    /**
     * 订单id
     */
    private Integer orderId;
    /**
     * 制单人
     */
    private String orderPerson;
    /**
     * 审批人
     */
    private String auditPerson;
    /**
     * 制单时间
     */
    private String makeTime;
    /**
     * 审批时间
     */
    private String auditTime;
    /**
     * 返厂地点
     */
    private String outArea;
    /**
     * 返厂原因
     */
    private String outReason;
    /**
     * 备注
     */
    private String outNote;
    /**
     * 创建时间
     */
    private String createTime;
    /**
     * 修改时间
     */
    private String updateTime;
    /**
     * 删除真删除假删除0/1
     */
    private Integer deleteStatus;
    private GoodsInfo goodsInfo;

    public GoodsInfo getGoodsInfo() {
        return goodsInfo;
    }

    public void setGoodsInfo(GoodsInfo goodsInfo) {
        this.goodsInfo = goodsInfo;
    }

    public Integer getOutOrderNum() {
        return outOrderNum;
    }

    public void setOutOrderNum(Integer outOrderNum) {
        this.outOrderNum = outOrderNum;
    }

    public String getOutMark() {
        return outMark;
    }

    public void setOutMark(String outMark) {
        this.outMark = outMark;
    }

    public String getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getOrderPerson() {
        return orderPerson;
    }

    public void setOrderPerson(String orderPerson) {
        this.orderPerson = orderPerson;
    }

    public String getAuditPerson() {
        return auditPerson;
    }

    public void setAuditPerson(String auditPerson) {
        this.auditPerson = auditPerson;
    }

    public String getMakeTime() {
        return makeTime;
    }

    public void setMakeTime(String makeTime) {
        this.makeTime = makeTime;
    }

    public String getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(String auditTime) {
        this.auditTime = auditTime;
    }

    public String getOutArea() {
        return outArea;
    }

    public void setOutArea(String outArea) {
        this.outArea = outArea;
    }

    public String getOutReason() {
        return outReason;
    }

    public void setOutReason(String outReason) {
        this.outReason = outReason;
    }

    public String getOutNote() {
        return outNote;
    }

    public void setOutNote(String outNote) {
        this.outNote = outNote;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(Integer deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

}
