package com.bean;
/**
 * @className: Customer
 * @description:
 * @author SunHang
 * @createTime 2021/4/17 23:02
 */


import java.sql.Date;

/**
 * ORM的编程思想：
 *  1. 一个数据表对应一个java类
 *  2. 表中的一条记录对应java的一个对象
 *  3. 表中的一个字段对应一个属性
 */
public class Customer {
    private int id;
    private String name;
    private String email;
    private Date birth;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Customer() {

    }

    public Customer(int id, String name, String email, Date birth) {

        this.id = id;
        this.name = name;
        this.email = email;
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", birth=" + birth +
                '}';
    }
}
