package com.javasm.commons.entity;

public enum S {
    SUC(20000,"成功"),
    ERROR(50000,"失败"),
    PWD_ERROR(50001,"密码错误"),
    NO_LOGIN(50002,"未登录"),
    DIV_ZERO(50003,"除数未0"),
    NO_USER(50004,"未注册"),
    HAS_CHILDS(50005,"删除的数据有子节点"),
    VALIECODE_ERROR(50006,"验证码错误"),
    REGISTER_ERROR(50007,"用户注册失败")
    ;
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
