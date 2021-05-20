package test.entity;

import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class User{
//    private static final long serialVersionUID = ;

    private Integer id;
    private String name;
    private String password;
    private Integer role;
    private String phone;
    private String imageSrc;
    private String email;
    private Character gender;
    private Date birth;
    private String provCode;
    private String cityCode;
    private String countyCode;
    private String addrDetail;
    private Date lastTime;
    private BigDecimal balance;
    private Integer score;
    private String desc;
}
