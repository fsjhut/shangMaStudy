package com.javasm.sys.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.javasm.commons.base.BaseEntity;

/**
 * (CrmSupplyGoods)实体类
 *
 * @author makejava
 * @since 2021-07-05 11:41:37
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CrmSupplyGoods extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 956940014651267699L;
    /**
     * 供应商品id
     */
    private Integer gid;
    /**
     * 商品名称
     */
    private String goodName;
    /**
     * 商品类型
     */
    private String goodType;
    /**
     * 采购价
     */
    private String purchasePrice;
    /**
     * 市场价
     */
    private String marketValue;
    /**
     * 商品品牌
     */
    private String goodBrand;
    /**
     * 商品型号
     */
    private String goodModel;
    /**
     * 商品库存
     */
    private Integer goodStock;
    /**
     * 商品颜色
     */
    private String goodColor;
    /**
     * 创建时间
     */
    private String createTime;


    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public String getGoodType() {
        return goodType;
    }

    public void setGoodType(String goodType) {
        this.goodType = goodType;
    }

    public String getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(String purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public String getMarketValue() {
        return marketValue;
    }

    public void setMarketValue(String marketValue) {
        this.marketValue = marketValue;
    }

    public String getGoodBrand() {
        return goodBrand;
    }

    public void setGoodBrand(String goodBrand) {
        this.goodBrand = goodBrand;
    }

    public String getGoodModel() {
        return goodModel;
    }

    public void setGoodModel(String goodModel) {
        this.goodModel = goodModel;
    }

    public Integer getGoodStock() {
        return goodStock;
    }

    public void setGoodStock(Integer goodStock) {
        this.goodStock = goodStock;
    }

    public String getGoodColor() {
        return goodColor;
    }

    public void setGoodColor(String goodColor) {
        this.goodColor = goodColor;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

}
