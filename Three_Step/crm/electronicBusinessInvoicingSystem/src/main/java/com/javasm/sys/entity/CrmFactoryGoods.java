package com.javasm.sys.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.javasm.commons.base.BaseEntity;

/**
 * (CrmFactoryGoods)实体类
 *
 * @author makejava
 * @since 2021-07-05 15:09:16
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CrmFactoryGoods extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 699235288030719356L;
    /**
     * 商品串码
     */
    private String goodsCode;
    /**
     * 商品品牌
     */
    private String goodsBrand;
    /**
     * 商品名称
     */
    private String goodsName;
    /**
     * 商品型号
     */
    private String goodsModel;
    /**
     * 商品颜色
     */
    private String goodsColor;
    /**
     * 商品供应商
     */
    private String goodsFrom;
    /**
     * 商品跟踪信息
     */
    private String goodsFlowing;
    /**
     * 0.维修1.更换
     */
    private Integer outMark;
    /**
     * 更换后商品串码
     */
    private String editCode;
    /**
     * 返厂单号id
     */
    private Integer fid;
    /**
     * 返厂备注说明
     */
    private String fdesc;


    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public String getGoodsBrand() {
        return goodsBrand;
    }

    public void setGoodsBrand(String goodsBrand) {
        this.goodsBrand = goodsBrand;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsModel() {
        return goodsModel;
    }

    public void setGoodsModel(String goodsModel) {
        this.goodsModel = goodsModel;
    }

    public String getGoodsColor() {
        return goodsColor;
    }

    public void setGoodsColor(String goodsColor) {
        this.goodsColor = goodsColor;
    }

    public String getGoodsFrom() {
        return goodsFrom;
    }

    public void setGoodsFrom(String goodsFrom) {
        this.goodsFrom = goodsFrom;
    }

    public String getGoodsFlowing() {
        return goodsFlowing;
    }

    public void setGoodsFlowing(String goodsFlowing) {
        this.goodsFlowing = goodsFlowing;
    }

    public Integer getOutMark() {
        return outMark;
    }

    public void setOutMark(Integer outMark) {
        this.outMark = outMark;
    }

    public String getEditCode() {
        return editCode;
    }

    public void setEditCode(String editCode) {
        this.editCode = editCode;
    }

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public String getFdesc() {
        return fdesc;
    }

    public void setFdesc(String fdesc) {
        this.fdesc = fdesc;
    }

}
