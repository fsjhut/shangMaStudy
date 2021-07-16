package com.javasm.sys.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.javasm.commons.base.BaseEntity;

/**
 * (Gift)实体类
 *
 * @author makejava
 * @since 2021-06-30 15:14:00
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Gift extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 631613107925295385L;
    /**
     * id
     */
    private Integer giftId;
    /**
     * 赠品名称
     */
    private String giftName;
    /**
     * 赠品类型
     */
    private String giftType;
    /**
     * 赠品型号
     */
    private String giftModel;
    /**
     * 赠品单价
     */
    private Double giftPrice;
    /**
     * 采购成本
     */
    private Double giftCost;
    /**
     * 采购部门
     */
    private String giftDepartment;
    /**
     * 赠品库存
     */
    private Integer giftInventory;
    /**
     * 赠品颜色
     */
    private String giftColor;
    /**
     * 赠品品牌
     */
    private String giftBrand;
    /**
     * 赠品状态
     */
    private Integer giftState;
    /**
     * 商品入库数
     */
    private Integer goodsStorage;
    /**
     * 天翼价
     */
    private Double giftTyprice;

    private Integer giftReviewstatus;

    public Integer getGiftReviewstatus() {
        return giftReviewstatus;
    }

    public void setGiftReviewstatus(Integer giftReviewstatus) {
        this.giftReviewstatus = giftReviewstatus;
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

    public String getGiftModel() {
        return giftModel;
    }

    public void setGiftModel(String giftModel) {
        this.giftModel = giftModel;
    }

    public Double getGiftPrice() {
        return giftPrice;
    }

    public void setGiftPrice(Double giftPrice) {
        this.giftPrice = giftPrice;
    }

    public Double getGiftCost() {
        return giftCost;
    }

    public void setGiftCost(Double giftCost) {
        this.giftCost = giftCost;
    }

    public String getGiftDepartment() {
        return giftDepartment;
    }

    public void setGiftDepartment(String giftDepartment) {
        this.giftDepartment = giftDepartment;
    }

    public Integer getGiftInventory() {
        return giftInventory;
    }

    public void setGiftInventory(Integer giftInventory) {
        this.giftInventory = giftInventory;
    }

    public String getGiftColor() {
        return giftColor;
    }

    public void setGiftColor(String giftColor) {
        this.giftColor = giftColor;
    }

    public String getGiftBrand() {
        return giftBrand;
    }

    public void setGiftBrand(String giftBrand) {
        this.giftBrand = giftBrand;
    }

    public Integer getGiftState() {
        return giftState;
    }

    public void setGiftState(Integer giftState) {
        this.giftState = giftState;
    }

    public Integer getGoodsStorage() {
        return goodsStorage;
    }

    public void setGoodsStorage(Integer goodsStorage) {
        this.goodsStorage = goodsStorage;
    }

    public Double getGiftTyprice() {
        return giftTyprice;
    }

    public void setGiftTyprice(Double giftTyprice) {
        this.giftTyprice = giftTyprice;
    }

}
