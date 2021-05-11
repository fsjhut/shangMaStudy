package com.test.service;


/**
 * @author SunHang
 * @className: UserService
 * @description:
 * @createTime 2021/5/8 15:35
 */
public interface UserService {
    int insertUser(String name, String password, String phone, String email,
                   String gender, String birth, String prov, String city,
                   String county, String areaDetail, String resume, String comment);
}
