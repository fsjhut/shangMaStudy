package com.javasm.sys.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.javasm.commons.base.BaseEntity;

/**
 * (B2cReturnForm)实体类
 *
 * @author makejava
 * @since 2021-07-06 16:38:59
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class B2cReturnForm extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 543538151164736970L;
    /**
     * 订单编号
     */
    private Integer orderNumber;
    /**
     * 申述记录名称
     */
    private String statementRecordName;
    /**
     * 返厂类型0.维修1.更换
     */
    private String returnType;
    /**
     * 商品编码
     */
    private String goodsCode;
    /**
     * 记录人
     */
    private String noteTaker;
    /**
     * 记录时间
     */
    private String recordingTime;
    /**
     * 审批人
     */
    private String approved;
    /**
     * 审批时间
     */
    private String approvalTime;
    /**
     * 单据状态 0未审核 1已审核
     */
    private String documentStatus;


    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getStatementRecordName() {
        return statementRecordName;
    }

    public void setStatementRecordName(String statementRecordName) {
        this.statementRecordName = statementRecordName;
    }

    public String getReturnType() {
        return returnType;
    }

    public void setReturnType(String returnType) {
        this.returnType = returnType;
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public String getNoteTaker() {
        return noteTaker;
    }

    public void setNoteTaker(String noteTaker) {
        this.noteTaker = noteTaker;
    }

    public String getRecordingTime() {
        return recordingTime;
    }

    public void setRecordingTime(String recordingTime) {
        this.recordingTime = recordingTime;
    }

    public String getApproved() {
        return approved;
    }

    public void setApproved(String approved) {
        this.approved = approved;
    }

    public String getApprovalTime() {
        return approvalTime;
    }

    public void setApprovalTime(String approvalTime) {
        this.approvalTime = approvalTime;
    }

    public String getDocumentStatus() {
        return documentStatus;
    }

    public void setDocumentStatus(String documentStatus) {
        this.documentStatus = documentStatus;
    }

}
