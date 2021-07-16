package com.javasm.sys.entity;

import com.javasm.commons.base.BaseEntity;

import java.io.Serializable;

/**
 * (CrmSupplier)实体类
 *
 * @author makejava
 * @since 2021-07-01 19:04:34
 */
public class CrmSupplier extends BaseEntity implements Serializable {
    private static final long serialVersionUID = -99503880825967932L;
    /**
     * 供应商id
     */
    private Integer sid;
    /**
     * 供应商名称
     */
    private String supplierName;
    /**
     * 联系人
     */
    private String supplierRealname;
    /**
     * 联系电话
     */
    private String supplierPhone;
    /**
     * 供应商邮箱
     */
    private String supplierEmail;
    /**
     * 供应商地址
     */
    private String supplierAddress;
    /**
     * 开户银行
     */
    private String depositBank;
    /**
     * 开户账号
     */
    private String accountNumber;


    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getSupplierRealname() {
        return supplierRealname;
    }

    public void setSupplierRealname(String supplierRealname) {
        this.supplierRealname = supplierRealname;
    }

    public String getSupplierPhone() {
        return supplierPhone;
    }

    public void setSupplierPhone(String supplierPhone) {
        this.supplierPhone = supplierPhone;
    }

    public String getSupplierEmail() {
        return supplierEmail;
    }

    public void setSupplierEmail(String supplierEmail) {
        this.supplierEmail = supplierEmail;
    }

    public String getSupplierAddress() {
        return supplierAddress;
    }

    public void setSupplierAddress(String supplierAddress) {
        this.supplierAddress = supplierAddress;
    }

    public String getDepositBank() {
        return depositBank;
    }

    public void setDepositBank(String depositBank) {
        this.depositBank = depositBank;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

}
