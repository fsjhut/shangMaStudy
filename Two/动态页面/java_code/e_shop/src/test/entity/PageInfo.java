package test.entity;

import lombok.*;

/**
 * @className: PageInfo
 * @description:   
 * @author SunHang
 * @createTime 2021/5/14 20:24
 */
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
