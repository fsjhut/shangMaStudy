package com.test.Bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.nio.charset.Charset;

/**
 * @className: Person
 * @description:   
 * @author SunHang
 * @createTime 2021/5/7 21:01
 */
@Getter
@Setter
@ToString
public class Person {
    private String name;
    private Integer age;
    private Character gender;
    private Integer preCode;
    private Integer cityCode;
    private Integer countyCode;
    private String  areaDetail;
    private String resume;
    private String comment;

    public Person() {
    }

    public Person(String name, Integer age, Character gender, Integer preCode,
                  Integer cityCode, Integer countyCode, String areaDetail,
                  String resume, String comment) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.preCode = preCode;
        this.cityCode = cityCode;
        this.countyCode = countyCode;
        this.areaDetail = areaDetail;
        this.resume = resume;
        this.comment = comment;
    }
}
