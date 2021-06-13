package com.javasm.entity;

import lombok.*;

/**
 * @className: SysDicts
 * @description:   
 * @author SunHang
 * @createTime 2021/6/8 20:21
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SysDicts {
    private Integer dictId;
    private Integer dictParentId;
    private Integer dictValue;
    private Integer dictSort;
    private String dictName;
    private String dictType;
    private String dictRemark;
}
