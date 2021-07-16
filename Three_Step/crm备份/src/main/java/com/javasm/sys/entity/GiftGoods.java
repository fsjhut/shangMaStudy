package com.javasm.sys.entity;

import java.util.Date;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.javasm.commons.base.BaseEntity;

/**
 * (GiftGoods)实体类
 *
 * @author makejava
 * @since 2021-06-30 16:32:02
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GiftGoods extends BaseEntity implements Serializable {
    private static final long serialVersionUID = -71474108705535743L;

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
     * 商品价格
     */
    private Double giftPrice;
    /**
     * 商品数量
     */
    private Integer giftNumber;
    /**
     * 审核状态 0未审核，1已审核，2审核未通过，3草稿
     */
    private Integer giftReviewstatus;
    /**
     * 审核人
     */
    private String reviewer;
    /**
     * 审核时间
     */
    private String auditTime;
    /**
     * 审核意见
     */
    private String auditOpinion;

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

    public String getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(String auditTime) {
        this.auditTime = auditTime;
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

    public Double getGiftPrice() {
        return giftPrice;
    }

    public void setGiftPrice(Double giftPrice) {
        this.giftPrice = giftPrice;
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



    public String getAuditOpinion() {
        return auditOpinion;
    }

    public void setAuditOpinion(String auditOpinion) {
        this.auditOpinion = auditOpinion;
    }

}
