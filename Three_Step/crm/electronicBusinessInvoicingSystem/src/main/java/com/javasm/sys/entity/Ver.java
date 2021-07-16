package com.javasm.sys.entity;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.javasm.commons.base.BaseEntity;

import java.io.Serializable;

/**
 * (Verify)实体类
 *
 * @author makejava
 * @since 2021-07-01 19:35:22
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Ver extends BaseEntity implements Serializable {
    private static final long serialVersionUID = -32564236729215453L;
    /**
     * 审批单id
     */
    private Integer verifyId;
    /**
     * 申请人
     */
    private String applicant;
    /**
     * 需要审核的表格(数据库中的表名)
     */
    private String verifyTable;
    /**
     * 数据库表中的id
     */
    private String verifyTableId;
    /**
     * 审核人
     */
    private String verifyPerson;
    /**
     * 审核状态，字典数据，0：未审核，1：通过，2：未通过
     */
    private Integer verifyStatus;
    /**
     * 审核意见
     */
    private String verifySuggestion;
    /**
     * 审核时间
     */
    private String verifyTime;


    public Integer getVerifyId() {
        return verifyId;
    }

    public void setVerifyId(Integer verifyId) {
        this.verifyId = verifyId;
    }

    public String getApplicant() {
        return applicant;
    }

    public void setApplicant(String applicant) {
        this.applicant = applicant;
    }

    public String getVerifyTable() {
        return verifyTable;
    }

    public void setVerifyTable(String verifyTable) {
        this.verifyTable = verifyTable;
    }

    public String getVerifyTableId() {
        return verifyTableId;
    }

    public void setVerifyTableId(String verifyTableId) {
        this.verifyTableId = verifyTableId;
    }

    public String getVerifyPerson() {
        return verifyPerson;
    }

    public void setVerifyPerson(String verifyPerson) {
        this.verifyPerson = verifyPerson;
    }

    public Integer getVerifyStatus() {
        return verifyStatus;
    }

    public void setVerifyStatus(Integer verifyStatus) {
        this.verifyStatus = verifyStatus;
    }

    public String getVerifySuggestion() {
        return verifySuggestion;
    }

    public void setVerifySuggestion(String verifySuggestion) {
        this.verifySuggestion = verifySuggestion;
    }

    public String getVerifyTime() {
        return verifyTime;
    }

    public void setVerifyTime(String verifyTime) {
        this.verifyTime = verifyTime;
    }

}
