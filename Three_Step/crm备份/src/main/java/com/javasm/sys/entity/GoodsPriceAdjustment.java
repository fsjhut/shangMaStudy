package com.javasm.sys.entity;


import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.javasm.commons.base.BaseEntity;

/**
 * good_price_audit(GoodsPriceAdjustment)实体类
 *
 * @author makejava
 * @since 2021-06-30 11:03:38
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GoodsPriceAdjustment extends BaseEntity implements Serializable {
    private static final long serialVersionUID = -68958026238104768L;
    /**
     * 在期价格修改记录唯一ID
     */
    private String priceAdjustmentId;
    /**
     * 商品ID
     */
    private Integer goodId;
    /**
     * 商品原价
     */
    private Double originalPrice;
    /**
     * 商品修改价格
     */
    private Double currentPrice;
    /**
     * 价格生效时间
     */
    private String startTime;
    /**
     * 价格失效时间
     */
    private String endTime;
    /**
     * 备注
     */
    private String remark;
    /**
     * 调价原因
     */
    private String adjustAccount;

    private Integer pageNum;
    private Integer pageSize;
    //  商品名称
    private String goodsName;
    //  库存
    private Integer inventoryNumber;

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Integer getInventoryNumber() {
        return inventoryNumber;
    }

    public void setInventoryNumber(Integer inventoryNumber) {
        this.inventoryNumber = inventoryNumber;
    }

    public GoodsPriceAdjustment() {
    }

    public GoodsPriceAdjustment(String priceAdjustmentId, Integer goodId, Double originalPrice, Double currentPrice, String startTime, String endTime, String remark, String adjustAccount, Integer pageNum, Integer pageSize, Integer checkStatus) {
        this.priceAdjustmentId = priceAdjustmentId;
        this.goodId = goodId;
        this.originalPrice = originalPrice;
        this.currentPrice = currentPrice;
        this.startTime = startTime;
        this.endTime = endTime;
        this.remark = remark;
        this.adjustAccount = adjustAccount;
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.checkStatus = checkStatus;
    }

    public GoodsPriceAdjustment(String priceAdjustmentId, Integer goodId, Double originalPrice, Double currentPrice, String startTime, String endTime, String remark, String adjustAccount, Integer pageNum, Integer pageSize, String goodsName, Integer inventoryNumber, Integer checkStatus) {
        this.priceAdjustmentId = priceAdjustmentId;
        this.goodId = goodId;
        this.originalPrice = originalPrice;
        this.currentPrice = currentPrice;
        this.startTime = startTime;
        this.endTime = endTime;
        this.remark = remark;
        this.adjustAccount = adjustAccount;
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.goodsName = goodsName;
        this.inventoryNumber = inventoryNumber;
        this.checkStatus = checkStatus;
    }



    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    //    /**
//     * 创建时间
//     */
//    private String createTime;
//    /**
//     * 修改时间
//     */
//    private String updateTime;
//    /**
//     * 创建人
//     */
//    private Integer createBy;
//    /**
//     * 修改人
//     */
//    private Integer updateBy;
    /**
     * 0草稿1待审核2已驳回3审核通过4已过期
     */
    private Integer checkStatus;


    public String getPriceAdjustmentId() {
        return priceAdjustmentId;
    }

    public void setPriceAdjustmentId(String priceAdjustmentId) {
        this.priceAdjustmentId = priceAdjustmentId;
    }

    public Integer getGoodId() {
        return goodId;
    }

    public void setGoodId(Integer goodId) {
        this.goodId = goodId;
    }

    public Double getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(Double originalPrice) {
        this.originalPrice = originalPrice;
    }

    public Double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(Double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getAdjustAccount() {
        return adjustAccount;
    }

    public void setAdjustAccount(String adjustAccount) {
        this.adjustAccount = adjustAccount;
    }
//
//    public String getCreateTime() {
//        return createTime;
//    }
//
//    public void setCreateTime(String createTime) {
//        this.createTime = createTime;
//    }
//
//    public String getUpdateTime() {
//        return updateTime;
//    }
//
//    public void setUpdateTime(String updateTime) {
//        this.updateTime = updateTime;
//    }
//
//    public Integer getCreateBy() {
//        return createBy;
//    }
//
//    public void setCreateBy(Integer createBy) {
//        this.createBy = createBy;
//    }
//
//    public Integer getUpdateBy() {
//        return updateBy;
//    }
//
//    public void setUpdateBy(Integer updateBy) {
//        this.updateBy = updateBy;
//    }

    public Integer getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(Integer checkStatus) {
        this.checkStatus = checkStatus;
    }

}
