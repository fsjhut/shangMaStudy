package com.javasm.entity;

public enum ReturnCode {

    NAME_OK(10001,"用户名可用"),
    NAME_DUP(10003,"用户名重复"),
    REQ_SUCCESS(20001,"请求成功"),
    REQ_FAILED(50000,"请求失败");



    private Integer code;
    private String msg;
    private ReturnCode(Integer code,String msg){
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
