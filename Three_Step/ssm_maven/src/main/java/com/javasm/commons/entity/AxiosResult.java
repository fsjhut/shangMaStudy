package com.javasm.commons.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AxiosResult {
    private Integer code;
    private String msg;
    private Object data;

    public AxiosResult(){}
    public AxiosResult(S s, Object data) {
        this.code = s.getCode();
        this.msg = s.getMsg();
        this.data = data;
    }

    public AxiosResult(S s) {
        this.code = s.getCode();
        this.msg = s.getMsg();
    }

    public AxiosResult(Object data) {
        this(S.SUC,data);
    }

    public static AxiosResult suc(){
        return new AxiosResult(S.SUC);
    }
    public static AxiosResult suc(S s){
        return new AxiosResult(s);
    }
    public static AxiosResult suc(Object data){
        return new AxiosResult(data);
    }
    public static AxiosResult suc(S s, Object data){
        return new AxiosResult(s,data);
    }
    public static AxiosResult error(S s){
        return new AxiosResult(s);
    }
    public static AxiosResult error(){
        return new AxiosResult(S.ERROR);
    }
    public static AxiosResult error(S s, Object data){
        return new AxiosResult(s,data);
    }
    public static AxiosResult error(Object data){
        return new AxiosResult(S.ERROR,data);
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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "AxiosResult{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
