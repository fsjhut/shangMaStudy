package com.javasm.sys.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.javasm.commons.base.BaseEntity;

/**
 * (GoodsInfo)实体类
 *
 * @author makejava
 * @since 2021-07-05 17:34:32
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GoodsInfo extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 115769809285900271L;

    private Integer id;
    /**
     * 商品编码
     */
    private String goodsCode;
    /**
     * 商品名称
     */
    private String goodsName;
    /**
     * 单价
     */
    private Double goodsPrice;
    /**
     * 数量
     */
    private Integer goodsCount;
    /**
     * 总金额
     */
    private String totalAmount;
    /**
     * 商品颜色
     */
    private String goodsColor;
    /**
     * 商品品牌
     */
    private String goodsBrand;
    /**
     * 商品型号
     */
    private String goodsModel;
    /**
     * 商品供应商
     */
    private String goodsSupply;
    /**
     * 商品跟踪信息
     */
    private String goodsFollowing;
    /**
     * 商品返厂配置
     */
    private String returnSet;
    /**
     * 返厂类型
     */
    private String rturnType;
    /**
     * 商品外观
     */
    private String goodsAppearance;
    /**
     * 商品出库时生成的一个串码
     */
    private String goodsIem;

    private CustomerComplaintForm complaintForm;

    public CustomerComplaintForm getComplaintForm() {
        return complaintForm;
    }

    public void setComplaintForm(CustomerComplaintForm complaintForm) {
        this.complaintForm = complaintForm;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Double getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(Double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public Integer getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(Integer goodsCount) {
        this.goodsCount = goodsCount;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
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

    public String getGoodsModel() {
        return goodsModel;
    }

    public void setGoodsModel(String goodsModel) {
        this.goodsModel = goodsModel;
    }

    public String getGoodsSupply() {
        return goodsSupply;
    }

    public void setGoodsSupply(String goodsSupply) {
        this.goodsSupply = goodsSupply;
    }

    public String getGoodsFollowing() {
        return goodsFollowing;
    }

    public void setGoodsFollowing(String goodsFollowing) {
        this.goodsFollowing = goodsFollowing;
    }

    public String getReturnSet() {
        return returnSet;
    }

    public void setReturnSet(String returnSet) {
        this.returnSet = returnSet;
    }

    public String getRturnType() {
        return rturnType;
    }

    public void setRturnType(String rturnType) {
        this.rturnType = rturnType;
    }

    public String getGoodsAppearance() {
        return goodsAppearance;
    }

    public void setGoodsAppearance(String goodsAppearance) {
        this.goodsAppearance = goodsAppearance;
    }

    public String getGoodsIem() {
        return goodsIem;
    }

    public void setGoodsIem(String goodsIem) {
        this.goodsIem = goodsIem;
    }

}
