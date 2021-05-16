package com.test.entity;

public class MyProduct {

    private String prodId;
    private String prodName;
    private Double prodPrice;
    private String prodImg;
    private String prodDesc;
    //购物车显示数量使用
    private Integer prodNum;


    public MyProduct(String prodId, String prodName, Double prodPrice, String prodImg, String prodDesc) {
        this.prodId = prodId;
        this.prodName = prodName;
        this.prodPrice = prodPrice;
        this.prodImg = prodImg;
        this.prodDesc = prodDesc;
    }

    public MyProduct(String prodId, String prodName) {
        this.prodId = prodId;
        this.prodName = prodName;

    }

    public MyProduct() {
    }

    public Integer getProdNum() {
        return prodNum;
    }

    public void setProdNum(Integer prodNum) {
        this.prodNum = prodNum;
    }

    public String getProdId() {
        return prodId;
    }

    public void setProdId(String prodId) {
        this.prodId = prodId;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public Double getProdPrice() {
        return prodPrice;
    }

    public void setProdPrice(Double prodPrice) {
        this.prodPrice = prodPrice;
    }

    public String getProdImg() {
        return prodImg;
    }

    public void setProdImg(String prodImg) {
        this.prodImg = prodImg;
    }

    public String getProdDesc() {
        return prodDesc;
    }

    public void setProdDesc(String prodDesc) {
        this.prodDesc = prodDesc;
    }


    @Override
    public String toString() {
        return "MyProduct{" +
                "prodId='" + prodId + '\'' +
                ", prodName='" + prodName + '\'' +
                ", prodPrice=" + prodPrice +
                ", prodImg='" + prodImg + '\'' +
                ", prodDesc='" + prodDesc + '\'' +
                ", prodNum=" + prodNum +
                '}';
    }
}
