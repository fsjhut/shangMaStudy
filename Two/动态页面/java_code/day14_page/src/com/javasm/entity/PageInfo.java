package com.javasm.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class PageInfo {
    private Integer page;
    private Integer pageSize;
    private Integer totalPage;


}
