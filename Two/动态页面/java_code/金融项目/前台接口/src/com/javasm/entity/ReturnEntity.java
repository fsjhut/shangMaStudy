package com.javasm.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ReturnEntity {
    private Integer returnCode;
    private String returnMsg;
    private List returnData;
    private PageInfo pageinfo;
    private Object extData;
}
