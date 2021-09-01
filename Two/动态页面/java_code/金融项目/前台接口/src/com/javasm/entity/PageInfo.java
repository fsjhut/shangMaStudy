package com.javasm.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageInfo {
    private Integer page;
    private Integer pagesize;
    private Integer total;
}
