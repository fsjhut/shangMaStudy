package com.javasm.commons.entity;

public enum S {
    SUC(20000,"成功"),
    ERROR(50000,"失败"),
    PWD_ERROR(50001,"用户名错误或密码错误"),
    LOGIN_SUC(6002,"登录成功"),
    NO_LOGIN(50002,"未登录"),
    DIV_ZERO(50003,"除数未0"),
    LOGOUT_SUC(50006,"退出成功"),
    LOGOUT_ERROR(50005,"退出失败"),
    NO_USER(50004,"未注册") ,
    CODE_ERROR(50006,"验证码错误") ,
    GENERATE_ERROR(50010,"促销活动创建失败"),
    NO_EXISTS(50008,"手机号不存在") ;
    private Integer code;
    private String msg;

    S(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
