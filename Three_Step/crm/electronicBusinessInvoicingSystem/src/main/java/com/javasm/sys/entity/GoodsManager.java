package com.javasm.sys.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.javasm.commons.base.BaseEntity;

/**
 * (GoodsManager)实体类
 *
 * @author makejava
 * @since 2021-06-30 16:42:40
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GoodsManager extends BaseEntity implements Serializable {

    private static final long serialVersionUID = -22272976534741533L;
    /**
     * 商品序号 id
     */
    private Integer goodsId;
    /**
     * 商品名称
     */
    private String goodsName;
    /**
     * 商品分类
     */
    private String goodsType;
    /**
     * 商品品牌
     */
    private String goodsBrand;
    /**
     * 商品型号
     */
    private String goodsModel;
    /**
     * 商品颜色
     */
    private String goodsColor;
    /**
     * 采购价
     */
    private Double procurementRmb;
    /**
     * 市场价
     */
    private Double marketRmb;
    /**
     * 商场价
     */
    private Double mallRmb;
    /**
     * 是否可采购 0表示不可购买;1表示可购买
     */
    private Integer booleanBuy;
    /**
     * 存货档案编码
     */
    private String goodsCode;
    /**
     * 库存量
     */
    private Integer inventoryNumber;
    /**
     * 基础库-业务模式
     */
    private String businessModel;
    /**
     * 基础库_采购模式
     */
    private String basePurchasingMode;
    /**
     * 基础库_辅货
     */
    private String baseComplementaryGoods;
    /**
     * 基础库-备机
     */
    private String baseStandby;
    /**
     * 商品级别 一类商品为1; 二类商品为:2
     */
    private Integer goodsLevel;


    @Override
    public String toString() {
        return "GoodsManager{" +
                "goodsId=" + goodsId +
                ", goodsName='" + goodsName + '\'' +
                ", goodsType='" + goodsType + '\'' +
                ", goodsBrand='" + goodsBrand + '\'' +
                ", goodsModel='" + goodsModel + '\'' +
                ", goodsColor='" + goodsColor + '\'' +
                ", procurementRmb=" + procurementRmb +
                ", marketRmb=" + marketRmb +
                ", mallRmb=" + mallRmb +
                ", booleanBuy=" + booleanBuy +
                ", goodsCode='" + goodsCode + '\'' +
                ", inventoryNumber=" + inventoryNumber +
                ", businessModel='" + businessModel + '\'' +
                ", basePurchasingMode='" + basePurchasingMode + '\'' +
                ", baseComplementaryGoods='" + baseComplementaryGoods + '\'' +
                ", baseStandby='" + baseStandby + '\'' +
                ", goodsLevel=" + goodsLevel +
                '}';
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

    public String getGoodsColor() {
        return goodsColor;
    }

    public void setGoodsColor(String goodsColor) {
        this.goodsColor = goodsColor;
    }

    public Double getProcurementRmb() {
        return procurementRmb;
    }

    public void setProcurementRmb(Double procurementRmb) {
        this.procurementRmb = procurementRmb;
    }

    public Double getMarketRmb() {
        return marketRmb;
    }

    public void setMarketRmb(Double marketRmb) {
        this.marketRmb = marketRmb;
    }

    public Double getMallRmb() {
        return mallRmb;
    }

    public void setMallRmb(Double mallRmb) {
        this.mallRmb = mallRmb;
    }

    public Integer getBooleanBuy() {
        return booleanBuy;
    }

    public void setBooleanBuy(Integer booleanBuy) {
        this.booleanBuy = booleanBuy;
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public Integer getInventoryNumber() {
        return inventoryNumber;
    }

    public void setInventoryNumber(Integer inventoryNumber) {
        this.inventoryNumber = inventoryNumber;
    }

    public String getBusinessModel() {
        return businessModel;
    }

    public void setBusinessModel(String businessModel) {
        this.businessModel = businessModel;
    }

    public String getBasePurchasingMode() {
        return basePurchasingMode;
    }

    public void setBasePurchasingMode(String basePurchasingMode) {
        this.basePurchasingMode = basePurchasingMode;
    }

    public String getBaseComplementaryGoods() {
        return baseComplementaryGoods;
    }

    public void setBaseComplementaryGoods(String baseComplementaryGoods) {
        this.baseComplementaryGoods = baseComplementaryGoods;
    }

    public String getBaseStandby() {
        return baseStandby;
    }

    public void setBaseStandby(String baseStandby) {
        this.baseStandby = baseStandby;
    }

    public Integer getGoodsLevel() {
        return goodsLevel;
    }

    public void setGoodsLevel(Integer goodsLevel) {
        this. goodsLevel = goodsLevel;
    }

}
