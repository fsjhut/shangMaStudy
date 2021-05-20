package test.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @className: Goods
 * @description:   
 * @author SunHang
 * @createTime 2021/5/19 18:42
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Goods {
    private String id;
    private String name;
    private BigDecimal price;
    private String imageSrc;
    private Integer stockNum;
    private Float discount;
    private Integer type;
    private Byte status;
    private String desc;
}
