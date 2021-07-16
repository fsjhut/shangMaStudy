package com.javasm.sys.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.javasm.commons.base.BaseEntity;

/**
 * (BrandManager)实体类
 *
 * @author makejava
 * @since 2021-06-30 16:41:53
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BrandManager extends BaseEntity implements Serializable {
    private static final long serialVersionUID = -16269800299094916L;
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
     * 品牌藐视
     */
    private String brandDesc;


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

}
