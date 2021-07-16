package com.javasm.sys.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.javasm.commons.base.BaseEntity;

/**
 * (BrandManager)实体类
 *
 * @author makejava
 * @since 2021-07-04 22:13:55
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BrandManager extends BaseEntity implements Serializable {
    private static final long serialVersionUID = -47499523116826402L;
    /**
     * 品牌id
     */
    private Integer brandId;
    /**
     * 品牌名称
     */
    private String brandName;
    /**
     * 品牌官网
     */
    private String brandUrl;
    /**
     * 品牌描述
     */
    private String brandDesc;
    /**
     * 1代表存在着  0代表真就删除了
     */
    private Integer brandDeleteStatus;



    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getBrandUrl() {
        return brandUrl;
    }

    public void setBrandUrl(String brandUrl) {
        this.brandUrl = brandUrl;
    }

    public String getBrandDesc() {
        return brandDesc;
    }

    public void setBrandDesc(String brandDesc) {
        this.brandDesc = brandDesc;
    }

    public Integer getBrandDeleteStatus() {
        return brandDeleteStatus;
    }

    public void setBrandDeleteStatus(Integer brandDeleteStatus) {
        this.brandDeleteStatus = brandDeleteStatus;
    }

}
