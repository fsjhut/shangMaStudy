package com.javasm.entity;

public class ReturnEntity {

    private Integer code;
    private String returnMsg;
    private Object returnData;

    public ReturnEntity(Integer code, String returnMsg, Object returnData) {
        this.code = code;
        this.returnMsg = returnMsg;
        this.returnData = returnData;
    }
    public ReturnEntity() {

    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getReturnMsg() {
        return returnMsg;
    }

    public void setReturnMsg(String returnMsg) {
        this.returnMsg = returnMsg;
    }

    public Object getReturnData() {
        return returnData;
    }

    public void setReturnData(Object returnData) {
        this.returnData = returnData;
    }

    @Override
    public String toString() {
        return "ReturnEntity{" +
                "code=" + code +
                ", returnMsg='" + returnMsg + '\'' +
                ", returnData=" + returnData +
                '}';
    }
}
