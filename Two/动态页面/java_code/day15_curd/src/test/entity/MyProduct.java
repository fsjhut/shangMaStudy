package test.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
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
}
