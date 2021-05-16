package com.javasm.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @className: Product
 * @description:   
 * @author SunHang
 * @createTime 2021/5/11 21:17
 */
@ToString
@Getter
@Setter
public class Product {
    private Integer id;
    private String name;
    private Integer number;
    private String remark;

    public Product(String name, Integer number, String remark) {
        this.name = name;
        this.number = number;
        this.remark = remark;
    }

    public Product(Integer id, String name, Integer number, String remark) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.remark = remark;
    }

    public Product() {
    }
}
