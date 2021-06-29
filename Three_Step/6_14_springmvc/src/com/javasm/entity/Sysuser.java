package com.javasm.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @className: Sysuser
 * @description:   
 * @author SunHang
 * @createTime 2021/6/14 14:39
 */
@Setter
@Getter
@ToString
public class Sysuser {
    private Integer uid;
    private String uname;
    private String upwd;
    private String uphone;
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date ubirthday;
    private String createTime;
}
