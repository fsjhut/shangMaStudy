package com.javasm.entity;

import lombok.*;

/**
 * @author:sunhang
 * @className: Suggestion
 * @description:
 * @date: 2021-06-02 16:17
 * @version:0.1
 * @since: 1.8
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Suggestion {
    private String uid;
    private String troubleList;
    private String suggestion;
    private String contact;
    private Character platform;
}
