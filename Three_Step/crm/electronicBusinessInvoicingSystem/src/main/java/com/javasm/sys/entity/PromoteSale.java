package com.javasm.sys.entity;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.javasm.commons.base.BaseEntity;

/**
 * (PromoteSale)实体类
 *
 * @author makejava
 * @since 2021-06-30 16:10:18
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PromoteSale extends BaseEntity implements Serializable {
    private static final long serialVersionUID = -59131385505818228L;
    /**
     * 促销活动id
     */
    private Integer promoteId;
    /**
     * 活动名称
     */
    private String promoteName;
    /**
     * 活动开始时间
     */
    private String startTime;
    /**
     * 活动结束时间
     */
    private String endTime;
    /**
     * 活动类型(字典)：1-每日限量 2-连续促销
     */
    private Integer promoteType;
    /**
     * 优惠价格开始时间
     */
    private String priceStartTime;
    /**
     * 优惠价格结束时间
     */
    private String priceEndTime;
    /**
     * 活动策划方案(添加，删除，下载)
     */
    private String promoteFile;
    /**
     * 活动详情
     */
    private String promoteDetail;
    /**
     * 备注信息
     */
    private String remark;
    /**
     * 申请人
     */
    private String createBy;
    /**
     * 0草稿1待审核2已驳回3审核通过4已过期
     */
    private Integer promoteStatus;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PromoteSale that = (PromoteSale) o;

        return promoteId != null ? promoteId.equals(that.promoteId) : that.promoteId == null;
    }

    @Override
    public int hashCode() {
        return promoteId != null ? promoteId.hashCode() : 0;
    }

    /**
     * 添加优惠活动的单中的商品
     */


    private List<GoodsManager> goods;

    public List<GoodsManager> getGoods() {
        return goods;
    }

    public void setGoods(List<GoodsManager> goods) {
        this.goods = goods;
    }

    public Integer getPromoteId() {
        return promoteId;
    }

    public void setPromoteId(Integer promoteId) {
        this.promoteId = promoteId;
    }

    public String getPromoteName() {
        return promoteName;
    }

    public void setPromoteName(String promoteName) {
        this.promoteName = promoteName;
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

    public Integer getPromoteType() {
        return promoteType;
    }

    public void setPromoteType(Integer promoteType) {
        this.promoteType = promoteType;
    }

    public String getPriceStartTime() {
        return priceStartTime;
    }

    public void setPriceStartTime(String priceStartTime) {
        this.priceStartTime = priceStartTime;
    }

    public String getPriceEndTime() {
        return priceEndTime;
    }

    public void setPriceEndTime(String priceEndTime) {
        this.priceEndTime = priceEndTime;
    }

    public String getPromoteFile() {
        return promoteFile;
    }

    public void setPromoteFile(String promoteFile) {
        this.promoteFile = promoteFile;
    }

    public String getPromoteDetail() {
        return promoteDetail;
    }

    public void setPromoteDetail(String promoteDetail) {
        this.promoteDetail = promoteDetail;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Integer getPromoteStatus() {
        return promoteStatus;
    }

    public void setPromoteStatus(Integer promoteStatus) {
        this.promoteStatus = promoteStatus;
    }

}
