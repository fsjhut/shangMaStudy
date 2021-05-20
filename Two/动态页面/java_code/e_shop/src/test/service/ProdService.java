package test.service;

import test.entity.Goods;

import java.util.List;

/**
 * @author SunHang
 * @className: ProdService
 * @description:
 * @createTime 2021/5/14 16:25
 */
public interface ProdService {
    // 从数据库中查询出指定的页码的数据
    List<Goods> getAllProduct(Integer page, Integer pageSize, Goods queryProd);

    // 计算出出所有的页码数
    Integer getTotalPage(Integer pageSize, Goods queryProd);

    Goods getProductById(String prodid);

    Integer insertProd(Goods insertProd);

    Integer editProd(Goods editProd);

    Integer delProd(String prodid);
}
