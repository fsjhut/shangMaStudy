package com.test.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @className: Person
 * @description:   
 * @author SunHang
 * @createTime 2021/5/7 21:01
 */
@Getter
@Setter
public class MyUser {
    private String id;
    private String name;
    private String passWord;
    private String phone;
    private String email;
    private String gender;
    private Date birth;
    private String provCode;
    private String cityCode;
    private String countyCode;
    private String areaDetail;
    private String resume;
    private String comment;

    public MyUser(String name, String passWord) {
        this.name = name;
        this.passWord = passWord;
    }

    public MyUser() {
    }

    public MyUser(String name, String passWord, String phone, String email,
                  String gender, Date birth, String provCode, String cityCode,
                  String countyCode, String areaDetail, String resume, String comment) {
        this.name = name;
        this.passWord = passWord;
        this.phone = phone;
        this.email = email;
        this.gender = gender;
        this.birth = birth;
        this.provCode = provCode;
        this.cityCode = cityCode;
        this.countyCode = countyCode;
        this.areaDetail = areaDetail;
        this.resume = resume;
        this.comment = comment;
    }

    public MyUser(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", passWord='" + passWord + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", birth=" + birth +
                ", provCode='" + provCode + '\'' +
                ", cityCode='" + cityCode + '\'' +
                ", countyCode='" + countyCode + '\'' +
                ", areaDetail='" + areaDetail + '\'' +
                ", resume='" + resume + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
