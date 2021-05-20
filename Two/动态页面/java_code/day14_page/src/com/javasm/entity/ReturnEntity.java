package com.javasm.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class ReturnEntity {

    private Integer code;
    private String returnMsg;
    private Object returnData;
    private PageInfo pif;

}
