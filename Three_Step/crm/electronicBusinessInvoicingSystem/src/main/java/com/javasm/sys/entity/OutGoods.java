package com.javasm.sys.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.javasm.commons.base.BaseEntity;

/**
 * (OutGoods)实体类
 *
 * @author makejava
 * @since 2021-07-05 17:35:35
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OutGoods extends BaseEntity implements Serializable {
    private static final long serialVersionUID = -97043432287448016L;

    private Integer outGoodsId;
    /**
     * 出库单单号
     */
    private Integer outOrder;

    private Integer goodsIem;


    public Integer getOutGoodsId() {
        return outGoodsId;
    }

    public void setOutGoodsId(Integer outGoodsId) {
        this.outGoodsId = outGoodsId;
    }

    public Integer getOutOrder() {
        return outOrder;
    }

    public void setOutOrder(Integer outOrder) {
        this.outOrder = outOrder;
    }

    public Integer getGoodsIem() {
        return goodsIem;
    }

    public void setGoodsIem(Integer goodsIem) {
        this.goodsIem = goodsIem;
    }

}
