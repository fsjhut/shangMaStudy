package com.test.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @className: ReturnEntity
 * @description:   
 * @author SunHang
 * @createTime 2021/5/14 20:23
 */
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class ReturnEntity {
    private Integer code;
    private String returnMsg;
    private Object returnData;
    private Integer cardNo;

    public ReturnEntity(Integer code, String returnMsg, Object returnData) {
        this.code = code;
        this.returnMsg = returnMsg;
        this.returnData = returnData;
    }
}
