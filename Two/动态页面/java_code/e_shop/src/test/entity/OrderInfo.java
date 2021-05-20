package test.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @className: OrderInfo
 * @description:   
 * @author SunHang
 * @createTime 2021/5/19 18:55
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderInfo {
    private String id;
    private Integer goodsId;
    private String orderId;
    private String goodsName;
    private BigDecimal goodsPrice;
    private BigDecimal totalMoney;
    private Integer goodsCount;
}
