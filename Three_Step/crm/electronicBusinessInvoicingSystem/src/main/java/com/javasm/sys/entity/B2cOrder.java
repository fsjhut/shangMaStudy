package com.javasm.sys.entity;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.javasm.commons.base.BaseEntity;

/**
 * (B2cOrder)实体类
 *
 * @author makejava
 * @since 2021-07-05 16:11:39
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class B2cOrder extends BaseEntity implements Serializable {
    private static final long serialVersionUID = -71323901045918450L;

    private Integer id;
    /**
     * 订单编号
     */
    private Integer orderNumber;
    /**
     * 订单类型
     */
    private String orderType;
    /**
     * 订单动作
     */
    private String orderAction;
    /**
     * 业务类型
     */
    private String businessTypes;
    /**
     * 支付方式
     */
    private String payMethod;
    /**
     * 配送方式
     */
    private String distribution;
    /**
     * 订单状态
     */
    private String orderState;
    /**
     * 下单日期
     */
    private String orderDate;
    /**
     * 出库订单创建人
     */
    private String creatBy;
    /**
     * 出库订单创建时间
     */
    private String creatTime;
    /**
     * 收货人id
     */
    private Integer consigneeId;

    @Override
    public String toString() {
        return "B2cOrder{" + "id=" + id + ", orderNumber=" + orderNumber + ", orderType='" + orderType + '\'' + ", orderAction='" + orderAction + '\'' + ", businessTypes='" + businessTypes + '\'' + ", payMethod='" + payMethod + '\'' + ", distribution='" + distribution + '\'' + ", orderState='" + orderState + '\'' + ", orderDate='" + orderDate + '\'' + ", creatBy='" + creatBy + '\'' + ", creatTime='" + creatTime + '\'' + ", consigneeId=" + consigneeId + ", consigneeInformation=" + consigneeInformation + '}';
    }

    public ConsigneeInformation getConsigneeInformation() {
        return consigneeInformation;
    }

    public void setConsigneeInformation(ConsigneeInformation consigneeInformation) {
        this.consigneeInformation = consigneeInformation;
    }

    private ConsigneeInformation consigneeInformation;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getOrderAction() {
        return orderAction;
    }

    public void setOrderAction(String orderAction) {
        this.orderAction = orderAction;
    }

    public String getBusinessTypes() {
        return businessTypes;
    }

    public void setBusinessTypes(String businessTypes) {
        this.businessTypes = businessTypes;
    }

    public String getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(String payMethod) {
        this.payMethod = payMethod;
    }

    public String getDistribution() {
        return distribution;
    }

    public void setDistribution(String distribution) {
        this.distribution = distribution;
    }

    public String getOrderState() {
        return orderState;
    }

    public void setOrderState(String orderState) {
        this.orderState = orderState;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getCreatBy() {
        return creatBy;
    }

    public void setCreatBy(String creatBy) {
        this.creatBy = creatBy;
    }

    public String getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(String creatTime) {
        this.creatTime = creatTime;
    }

    public Integer getConsigneeId() {
        return consigneeId;
    }

    public void setConsigneeId(Integer consigneeId) {
        this.consigneeId = consigneeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        B2cOrder b2cOrder = (B2cOrder) o;
        return Objects.equals(id, b2cOrder.id) && Objects.equals(orderNumber, b2cOrder.orderNumber) && Objects.equals(orderType, b2cOrder.orderType) && Objects.equals(orderAction, b2cOrder.orderAction) && Objects.equals(businessTypes, b2cOrder.businessTypes) && Objects.equals(payMethod, b2cOrder.payMethod) && Objects.equals(distribution, b2cOrder.distribution) && Objects.equals(orderState, b2cOrder.orderState) && Objects.equals(orderDate, b2cOrder.orderDate) && Objects.equals(creatBy, b2cOrder.creatBy) && Objects.equals(creatTime, b2cOrder.creatTime) && Objects.equals(consigneeId, b2cOrder.consigneeId) && Objects.equals(consigneeInformation, b2cOrder.consigneeInformation);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, orderNumber, orderType, orderAction, businessTypes, payMethod, distribution, orderState, orderDate, creatBy, creatTime, consigneeId, consigneeInformation);
    }
}
