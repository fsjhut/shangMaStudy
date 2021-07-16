package com.javasm.sys.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.javasm.commons.base.BaseEntity;

/**
 * (PromoteProduct)实体类
 *
 * @author makejava
 * @since 2021-06-30 19:30:39
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PromoteProduct extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 887356370671660142L;

    private Integer promoteId;

    private Integer productId;

    private String productName;

    private Integer productStock;

    private Integer promoteNum;

    private Double marketPrice;

    private Double shoppingPrice;

    private Double promotePrice;


    public Integer getPromoteId() {
        return promoteId;
    }

    public void setPromoteId(Integer promoteId) {
        this.promoteId = promoteId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getProductStock() {
        return productStock;
    }

    public void setProductStock(Integer productStock) {
        this.productStock = productStock;
    }

    public Integer getPromoteNum() {
        return promoteNum;
    }

    public void setPromoteNum(Integer promoteNum) {
        this.promoteNum = promoteNum;
    }

    public Double getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(Double marketPrice) {
        this.marketPrice = marketPrice;
    }

    public Double getShoppingPrice() {
        return shoppingPrice;
    }

    public void setShoppingPrice(Double shoppingPrice) {
        this.shoppingPrice = shoppingPrice;
    }

    public Double getPromotePrice() {
        return promotePrice;
    }

    public void setPromotePrice(Double promotePrice) {
        this.promotePrice = promotePrice;
    }

}
