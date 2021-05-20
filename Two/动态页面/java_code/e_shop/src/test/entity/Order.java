package test.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @className: Order
 * @description:   
 * @author SunHang
 * @createTime 2021/5/19 18:46
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private String id;
    private Integer userId;
    private BigDecimal totalMoney;
    private Byte status;
}
