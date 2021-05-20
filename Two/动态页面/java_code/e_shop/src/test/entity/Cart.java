package test.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @className: Cart
 * @description:   
 * @author SunHang
 * @createTime 2021/5/19 19:00
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cart {
    private String goodsId;
    private Integer userId;
    private Integer buyNum;
}
