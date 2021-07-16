package com.javasm.sys.entity;

import java.util.Date;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.javasm.commons.base.BaseEntity;

/**
 * (B2cGodown)实体类
 *
 * @author makejava
 * @since 2021-07-05 23:55:55
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class B2cGodown extends BaseEntity implements Serializable {
    private static final long serialVersionUID = -31025605178516557L;

    private Integer godownId;

    private Integer orderId;

    private String operatePerson;

    private Date createTime;


    public Integer getGodownId() {
        return godownId;
    }

    public void setGodownId(Integer godownId) {
        this.godownId = godownId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getOperatePerson() {
        return operatePerson;
    }

    public void setOperatePerson(String operatePerson) {
        this.operatePerson = operatePerson;
    }


    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
