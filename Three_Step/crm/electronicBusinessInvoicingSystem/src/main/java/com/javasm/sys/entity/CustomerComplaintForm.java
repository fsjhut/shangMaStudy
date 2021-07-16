package com.javasm.sys.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.javasm.commons.base.BaseEntity;

/**
 * (CustomerComplaintForm)实体类
 *
 * @author makejava
 * @since 2021-07-06 16:33:35
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomerComplaintForm extends BaseEntity implements Serializable {
    private static final long serialVersionUID = -35837159035346611L;
    /**
     * 申诉编号
     */
    private Integer cid;
    /**
     * 商品串码
     */
    private String goodsIem;
    /**
     * 商品订单
     */
    private Integer orderNumber;
    /**
     * 申述名称
     */
    private String cname;
    /**
     * 申述来源
     */
    private String sourceRepresentation;
    /**
     * 申诉描述
     */
    private String complaintDescription;
    /**
     * 退换货类型 退货0  换货1
     */
    private String solutions;
    /**
     * 换货原因 质量问题0 非质量问题1
     */
    private String reasonReplacement;
    /**
     * 问题详细信息
     */
    private String detailedInformation;
    /**
     * 申请时间
     */
    private String createTime;
    /**
     * 检修点
     */
    private String maintenancePoint;
    /**
     * 检修电话
     */
    private String maintenancePhone;
    /**
     * 答复意见
     */
    private String replyComment;
    /**
     * 备注
     */
    private String cdesc;
    /**
     * 制作人
     */
    private String makePeople;


    private Ver ver;
    private String verifyPerson;
    private String verifySuggestion;
    private String verifyTime;
    private Integer comStatus;

    public Integer getComStatus() {
        return comStatus;
    }

    public void setComStatus(Integer comStatus) {
        this.comStatus = comStatus;
    }

    public String getVerifyPerson() {
        return verifyPerson;
    }

    public void setVerifyPerson(String verifyPerson) {
        this.verifyPerson = verifyPerson;
    }

    public String getVerifySuggestion() {
        return verifySuggestion;
    }

    public void setVerifySuggestion(String verifySuggestion) {
        this.verifySuggestion = verifySuggestion;
    }

    public String getVerifyTime() {
        return verifyTime;
    }

    public void setVerifyTime(String verifyTime) {
        this.verifyTime = verifyTime;
    }

    public Ver getVer() {
        return ver;
    }

    public void setVer(Ver ver) {
        this.ver = ver;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getGoodsIem() {
        return goodsIem;
    }

    public void setGoodsIem(String goodsIem) {
        this.goodsIem = goodsIem;
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getSourceRepresentation() {
        return sourceRepresentation;
    }

    public void setSourceRepresentation(String sourceRepresentation) {
        this.sourceRepresentation = sourceRepresentation;
    }

    public String getComplaintDescription() {
        return complaintDescription;
    }

    public void setComplaintDescription(String complaintDescription) {
        this.complaintDescription = complaintDescription;
    }

    public String getSolutions() {
        return solutions;
    }

    public void setSolutions(String solutions) {
        this.solutions = solutions;
    }

    public String getReasonReplacement() {
        return reasonReplacement;
    }

    public void setReasonReplacement(String reasonReplacement) {
        this.reasonReplacement = reasonReplacement;
    }

    public String getDetailedInformation() {
        return detailedInformation;
    }

    public void setDetailedInformation(String detailedInformation) {
        this.detailedInformation = detailedInformation;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getMaintenancePoint() {
        return maintenancePoint;
    }

    public void setMaintenancePoint(String maintenancePoint) {
        this.maintenancePoint = maintenancePoint;
    }

    public String getMaintenancePhone() {
        return maintenancePhone;
    }

    public void setMaintenancePhone(String maintenancePhone) {
        this.maintenancePhone = maintenancePhone;
    }

    public String getReplyComment() {
        return replyComment;
    }

    public void setReplyComment(String replyComment) {
        this.replyComment = replyComment;
    }

    public String getCdesc() {
        return cdesc;
    }

    public void setCdesc(String cdesc) {
        this.cdesc = cdesc;
    }

    public String getMakePeople() {
        return makePeople;
    }

    public void setMakePeople(String makePeople) {
        this.makePeople = makePeople;
    }

}
