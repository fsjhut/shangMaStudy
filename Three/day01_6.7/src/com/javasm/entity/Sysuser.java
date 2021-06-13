package com.javasm.entity;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Sysuser {

  private Integer uid;
  private String uname;
  private String upwd;
  private String uphone;
  private String uwechat;
  private String uemail;
  private String createTime;
  private String updateTime;
  private String createBy;
  private Integer rid;
  private Sysrole sysrole;
}
