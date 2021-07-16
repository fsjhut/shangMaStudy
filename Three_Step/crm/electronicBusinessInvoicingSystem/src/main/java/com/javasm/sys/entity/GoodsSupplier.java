package com.javasm.sys.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.javasm.commons.base.BaseEntity;

/**
 * (GoodsSupplier)实体类
 *
 * @author makejava
 * @since 2021-07-05 17:16:06
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GoodsSupplier extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 726762549472555697L;

    private Integer sid;

    private Integer goodsId;


    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

}
