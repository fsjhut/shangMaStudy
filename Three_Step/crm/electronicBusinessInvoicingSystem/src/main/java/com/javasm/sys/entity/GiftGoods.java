package com.javasm.sys.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.javasm.commons.base.BaseEntity;

/**
 * (GiftGoods)实体类
 *
 * @author makejava
 * @since 2021-07-05 00:18:03
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GiftGoods extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 841496764236556431L;

    private Integer giftId;
    /**
     * 商品名称
     */
    private String giftName;
    /**
     * 商品类型
     */
    private String giftType;
    /**
     * 商品品牌
     */
    private String giftBrand;
    /**
     * 赠品型号
     */
    private String giftModel;
    /**
     * 商品颜色
     */
    private String giftColor;
    /**
     * 天翼价
     */
    private Double giftTyprice;
    /**
     * 采购成本
     */
    private Double giftCost;
    /**
     * 商品价格
     */
    private Double giftPrice;
    /**
     * 赠品库存
     */
    private String giftInventory;
    /**
     * 采购部门
     */
    private String giftDepartment;
    /**
     * 入库数量
     */
    private Integer giftNumber;
    /**
     * 审核状态 0未审核，1已审核，2审核未通过，3草稿
     */
    private Integer giftReviewstatus;
    /**
     * 创建人
     */
    private String createBy;
    /**
     * 审核人
     */
    private String updateBy;
    /**
     * 审核创建时间
     */
    private String createTime;
    /**
     * 审核时间
     */
    private String updateTime;
    /**
     * 审核意见
     */
    private String auditOpinion;
    /**
     * 状态描述
     */
    private String desc;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getGiftId() {
        return giftId;
    }

    public void setGiftId(Integer giftId) {
        this.giftId = giftId;
    }

    public String getGiftName() {
        return giftName;
    }

    public void setGiftName(String giftName) {
        this.giftName = giftName;
    }

    public String getGiftType() {
        return giftType;
    }

    public void setGiftType(String giftType) {
        this.giftType = giftType;
    }

    public String getGiftBrand() {
        return giftBrand;
    }

    public void setGiftBrand(String giftBrand) {
        this.giftBrand = giftBrand;
    }

    public String getGiftModel() {
        return giftModel;
    }

    public void setGiftModel(String giftModel) {
        this.giftModel = giftModel;
    }

    public String getGiftColor() {
        return giftColor;
    }

    public void setGiftColor(String giftColor) {
        this.giftColor = giftColor;
    }

    public Double getGiftTyprice() {
        return giftTyprice;
    }

    public void setGiftTyprice(Double giftTyprice) {
        this.giftTyprice = giftTyprice;
    }

    public Double getGiftCost() {
        return giftCost;
    }

    public void setGiftCost(Double giftCost) {
        this.giftCost = giftCost;
    }

    public Double getGiftPrice() {
        return giftPrice;
    }

    public void setGiftPrice(Double giftPrice) {
        this.giftPrice = giftPrice;
    }

    public String getGiftInventory() {
        return giftInventory;
    }

    public void setGiftInventory(String giftInventory) {
        this.giftInventory = giftInventory;
    }

    public String getGiftDepartment() {
        return giftDepartment;
    }

    public void setGiftDepartment(String giftDepartment) {
        this.giftDepartment = giftDepartment;
    }

    public Integer getGiftNumber() {
        return giftNumber;
    }

    public void setGiftNumber(Integer giftNumber) {
        this.giftNumber = giftNumber;
    }

    public Integer getGiftReviewstatus() {
        return giftReviewstatus;
    }

    public void setGiftReviewstatus(Integer giftReviewstatus) {
        this.giftReviewstatus = giftReviewstatus;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
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

    public String getAuditOpinion() {
        return auditOpinion;
    }

    public void setAuditOpinion(String auditOpinion) {
        this.auditOpinion = auditOpinion;
    }

}
