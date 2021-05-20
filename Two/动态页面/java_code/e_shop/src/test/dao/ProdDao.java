package test.dao;

import test.entity.Goods;

import java.sql.SQLException;
import java.util.List;

/**
 * @author SunHang
 * @className: ProdDao
 * @description:
 * @createTime 2021/5/14 16:25
 */
public interface ProdDao {
    List<Goods> getAllProduct(Integer page, Integer pageSize, Goods queryProd) throws Exception;

    Integer getAllProductNum(Goods queryProd) throws Exception;

    Goods getProductById(String prodid) throws SQLException;

    Integer insertProd(Goods insertProd) throws SQLException;

    Integer editProd(Goods editProd) throws SQLException;

    Integer delProd(String prodid) throws SQLException;
}
