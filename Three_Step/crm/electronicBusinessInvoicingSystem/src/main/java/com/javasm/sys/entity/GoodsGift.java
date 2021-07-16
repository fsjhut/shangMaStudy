package com.javasm.sys.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.javasm.commons.base.BaseEntity;

import java.io.Serializable;
import java.util.Objects;

/**
 * (GoodsGift)实体类
 *
 * @author makejava
 * @since 2021-07-05 00:04:51
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GoodsGift extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 430720394559370535L;
    /**
     * 赠品id
     */
    private Integer goodsId;
    /**
     * 赠品名称
     */
    private String goodsName;
    /**
     * 赠品类型
     */
    private String goodsType;
    /**
     * 赠品型号
     */
    private String goodsModel;
    /**
     * 赠品单价
     */
    private String marketRmb;
    /**
     * 赠品成本价格
     */
    private String procurementRmb;
    /**
     * 赠品库存
     */
    private Integer inventoryNumber;
    /**
     * 赠品颜色
     */
    private String goodsColor;
    /**
     * 赠品品牌
     */
    private String goodsBrand;
    /**
     * 商品转赠品入库数量
     */
    private Integer giftNumber;
    /**
     * 审核状态0已审核，1未审核，2审核未通过，3删除
     */
    private Integer giftReviewstatus;
    /**
     * 采购单价
     */
    private String purchasingPrice;
    /**
     * 采购部门
     */
    private String purchasingDepartment;
    /**
     * r入库数量
     */
    private String luboundNumber;
    /**
     * 天翼价
     */
    private String tianyiPrice;
    /**
     * 创建时间
     */
    private String creatTime;
    /**
     * 审核时间
     */
    private String updateTime;

    /**
     * 改变审核状态
     */
    private String descInfo;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 审核人
     */
    private String updateBy;

    @Override
    public String getCreateBy() {
        return createBy;
    }

    @Override
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    @Override
    public String getUpdateBy() {
        return updateBy;
    }

    @Override
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public String getDescInfo() {
        return descInfo;
    }

    public void setDescInfo(String descInfo) {
        this.descInfo = descInfo;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType;
    }

    public String getGoodsModel() {
        return goodsModel;
    }

    public void setGoodsModel(String goodsModel) {
        this.goodsModel = goodsModel;
    }

    public String getMarketRmb() {
        return marketRmb;
    }

    public void setMarketRmb(String marketRmb) {
        this.marketRmb = marketRmb;
    }

    public String getProcurementRmb() {
        return procurementRmb;
    }

    public void setProcurementRmb(String procurementRmb) {
        this.procurementRmb = procurementRmb;
    }

    public Integer getInventoryNumber() {
        return inventoryNumber;
    }

    public void setInventoryNumber(Integer inventoryNumber) {
        this.inventoryNumber = inventoryNumber;
    }

    public String getGoodsColor() {
        return goodsColor;
    }

    public void setGoodsColor(String goodsColor) {
        this.goodsColor = goodsColor;
    }

    public String getGoodsBrand() {
        return goodsBrand;
    }

    public void setGoodsBrand(String goodsBrand) {
        this.goodsBrand = goodsBrand;
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

    public String getPurchasingPrice() {
        return purchasingPrice;
    }

    public void setPurchasingPrice(String purchasingPrice) {
        this.purchasingPrice = purchasingPrice;
    }

    public String getPurchasingDepartment() {
        return purchasingDepartment;
    }

    public void setPurchasingDepartment(String purchasingDepartment) {
        this.purchasingDepartment = purchasingDepartment;
    }

    public String getLuboundNumber() {
        return luboundNumber;
    }

    public void setLuboundNumber(String luboundNumber) {
        this.luboundNumber = luboundNumber;
    }

    public String getTianyiPrice() {
        return tianyiPrice;
    }

    public void setTianyiPrice(String tianyiPrice) {
        this.tianyiPrice = tianyiPrice;
    }

    public String getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(String creatTime) {
        this.creatTime = creatTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GoodsGift goodsGift = (GoodsGift) o;
        return Objects.equals(goodsId, goodsGift.goodsId) &&
                Objects.equals(goodsName, goodsGift.goodsName) &&
                Objects.equals(goodsType, goodsGift.goodsType) &&
                Objects.equals(goodsModel, goodsGift.goodsModel) &&
                Objects.equals(marketRmb, goodsGift.marketRmb) &&
                Objects.equals(procurementRmb, goodsGift.procurementRmb) &&
                Objects.equals(inventoryNumber, goodsGift.inventoryNumber) &&
                Objects.equals(goodsColor, goodsGift.goodsColor) &&
                Objects.equals(goodsBrand, goodsGift.goodsBrand) &&
                Objects.equals(giftNumber, goodsGift.giftNumber) &&
                Objects.equals(giftReviewstatus, goodsGift.giftReviewstatus) &&
                Objects.equals(purchasingPrice, goodsGift.purchasingPrice) &&
                Objects.equals(purchasingDepartment, goodsGift.purchasingDepartment) &&
                Objects.equals(luboundNumber, goodsGift.luboundNumber) &&
                Objects.equals(tianyiPrice, goodsGift.tianyiPrice) &&
                Objects.equals(creatTime, goodsGift.creatTime) &&
                Objects.equals(updateTime, goodsGift.updateTime) &&
                Objects.equals(descInfo, goodsGift.descInfo);
    }

    @Override
    public int hashCode() {

        return Objects.hash(goodsId, goodsName, goodsType, goodsModel, marketRmb, procurementRmb, inventoryNumber, goodsColor, goodsBrand, giftNumber, giftReviewstatus, purchasingPrice, purchasingDepartment, luboundNumber, tianyiPrice, creatTime, updateTime, descInfo);
    }
}
