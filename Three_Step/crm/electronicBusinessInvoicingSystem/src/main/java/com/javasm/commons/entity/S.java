package com.javasm.commons.entity;

public enum S {
    SUC(20000,"成功"),
    ERROR(50000,"失败"),
    INVENTORY_STORTAGE(50017,"库存不足"),
    PWD_ERROR(50001,"用户名错误或密码错误"),
    LOGIN_SUC(10000,"登录成功"),
    NO_LOGIN(50002,"未登录"),
    DIV_ZERO(50003,"除数未0"),
    NO_USER(50004,"未注册") ,
    LOGOUT_ERROR(50005,"退出失败"),
    LOGOUT_SUC(50006,"退出成功"),
    FIELD_EXISTS(50007, "已存在，添加失败"),
    NO_EXISTS(50008,"手机号不存在"),
    MODIFY_SUC(5009,"修改成功"),
    MODIFY_ERROR(5010,"修改失败"),
    CODE_ERROR(50011,"验证码错误"),
    SON_ERROR(50012,"该部门下有子部门，无法删除"),
    ELEYOO_ERROR(50013,"该部门下有员工，无法删除"),
    GENERATE_ERROR(50100,"生成活动失败"),
    DEPTNO_DNAME_EXISTS(50014,"你添加的部门编号或部门名称已存在"),
    ADD_SUC(50015,"添加成功"),
    MODIFY_ERROR2(50016,"该部门名称已存在，请换其它名称"),;
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
