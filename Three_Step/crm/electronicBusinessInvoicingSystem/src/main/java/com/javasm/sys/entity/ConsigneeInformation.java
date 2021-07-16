package com.javasm.sys.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.javasm.commons.base.BaseEntity;

/**
 * (ConsigneeInformation)实体类
 *
 * @author makejava
 * @since 2021-07-05 16:23:13
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ConsigneeInformation extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 336743835974704426L;

    private Integer id;
    /**
     * 收货人姓名
     */
    private String consigneeName;
    /**
     * 会员账号
     */
    private String consigneeAccount;
    /**
     * 联系电话
     */
    private String consigneeCall;
    /**
     * 联系手机
     */
    private String consigneePhone;
    /**
     * 邮政编码
     */
    private String zipCode;
    /**
     * 收货地址
     */
    private String consigneeAddress;
    /**
     * 配送地区
     */
    private String distributionRegion;
    /**
     * 配送方式
     */
    private String distributionWay;
    /**
     * 配送费用
     */
    private String distributionMoney;
    /**
     * 支付方式
     */
    private String payMethod;
    /**
     * 自提时间
     */
    private String extractTime;
    /**
     * 电子邮箱
     */
    private String emil;
    /**
     * 汇款人
     */
    private String remitter;
    /**
     * 备注
     */
    private String note;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getConsigneeName() {
        return consigneeName;
    }

    public void setConsigneeName(String consigneeName) {
        this.consigneeName = consigneeName;
    }

    public String getConsigneeAccount() {
        return consigneeAccount;
    }

    public void setConsigneeAccount(String consigneeAccount) {
        this.consigneeAccount = consigneeAccount;
    }

    public String getConsigneeCall() {
        return consigneeCall;
    }

    public void setConsigneeCall(String consigneeCall) {
        this.consigneeCall = consigneeCall;
    }

    public String getConsigneePhone() {
        return consigneePhone;
    }

    public void setConsigneePhone(String consigneePhone) {
        this.consigneePhone = consigneePhone;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getConsigneeAddress() {
        return consigneeAddress;
    }

    public void setConsigneeAddress(String consigneeAddress) {
        this.consigneeAddress = consigneeAddress;
    }

    public String getDistributionRegion() {
        return distributionRegion;
    }

    public void setDistributionRegion(String distributionRegion) {
        this.distributionRegion = distributionRegion;
    }

    public String getDistributionWay() {
        return distributionWay;
    }

    public void setDistributionWay(String distributionWay) {
        this.distributionWay = distributionWay;
    }

    public String getDistributionMoney() {
        return distributionMoney;
    }

    public void setDistributionMoney(String distributionMoney) {
        this.distributionMoney = distributionMoney;
    }

    public String getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(String payMethod) {
        this.payMethod = payMethod;
    }

    public String getExtractTime() {
        return extractTime;
    }

    public void setExtractTime(String extractTime) {
        this.extractTime = extractTime;
    }

    public String getEmil() {
        return emil;
    }

    public void setEmil(String emil) {
        this.emil = emil;
    }

    public String getRemitter() {
        return remitter;
    }

    public void setRemitter(String remitter) {
        this.remitter = remitter;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

}
