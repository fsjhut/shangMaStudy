package com.javasm.dynamic.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * (DynamicImg)实体类
 *
 * @author makejava
 * @since 2021-07-18 19:32:19
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@TableName("Dynamic_img")
public class DynamicImg implements Serializable {
    private static final long serialVersionUID = -15873385232497996L;
    /**
     * 动态的id
     */

    private Integer dynamicId;
    /**
     * 主播的id
     */
    private Integer uid;
    /**
     * 图片路径
     */
    private String imgSrc;


    public Integer getDynamicId() {
        return dynamicId;
    }

    public void setDynamicId(Integer dynamicId) {
        this.dynamicId = dynamicId;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

}
