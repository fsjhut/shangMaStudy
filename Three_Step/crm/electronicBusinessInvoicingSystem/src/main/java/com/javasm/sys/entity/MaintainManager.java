package com.javasm.sys.entity;


import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.javasm.commons.base.BaseEntity;

/**
 * (MaintainManager)实体类
 *
 * @author makejava
 * @since 2021-07-05 17:50:55
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MaintainManager extends BaseEntity implements Serializable {
    private static final long serialVersionUID = -78097479350574610L;
    /**
     * 唯一ID
     */
    private Integer maintainId;
    /**
     * 公司名称
     */
    private String maintainName;
    /**
     * 公司详细地址
     */
    private String maintainAddress;
    /**
     * 热线电话
     */
    private String maintainPhone;

    /**
     * 省市地址
     */
    private Integer maintainCity;


    public Integer getMaintainId() {
        return maintainId;
    }

    public void setMaintainId(Integer maintainId) {
        this.maintainId = maintainId;
    }

    public String getMaintainName() {
        return maintainName;
    }

    public void setMaintainName(String maintainName) {
        this.maintainName = maintainName;
    }

    public String getMaintainAddress() {
        return maintainAddress;
    }

    public void setMaintainAddress(String maintainAddress) {
        this.maintainAddress = maintainAddress;
    }

    public String getMaintainPhone() {
        return maintainPhone;
    }

    public void setMaintainPhone(String maintainPhone) {
        this.maintainPhone = maintainPhone;
    }



    public Integer getMaintainCity() {
        return maintainCity;
    }

    public void setMaintainCity(Integer maintainCity) {
        this.maintainCity = maintainCity;
    }

}
