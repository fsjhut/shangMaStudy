package com.test.entity;
/**
 * @className: ReturnCode
 * @description:   
 * @author SunHang
 * @createTime 2021/5/14 20:24
 */
public enum ReturnCode {
    NAME_OK(10001,"用户名可用"),
    NAME_DUP(10003,"用户名重复"),
    REQ_SUCCESS(20001,"请求成功"),
    NO_DATA(30001,"没有数据"),
    REQ_FAILED(50000,"请求失败");
    // 代码
    private Integer code;
    // 信息
    private String msg;

    ReturnCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    public Integer getCode(){
        return code;
    }
    public String getMsg(){
        return msg;
    }
}
