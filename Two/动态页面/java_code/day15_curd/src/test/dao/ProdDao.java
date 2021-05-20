package test.dao;

import test.entity.MyProduct;

import java.sql.SQLException;
import java.util.List;

/**
 * @author SunHang
 * @className: ProdDao
 * @description:
 * @createTime 2021/5/14 16:25
 */
public interface ProdDao {
    List<MyProduct> getAllProduct(Integer page, Integer pageSize, MyProduct queryProd) throws Exception;

    Integer getAllProductNum(MyProduct queryProd) throws Exception;

    MyProduct getProductById(String prodid) throws SQLException;

    Integer insertProd(MyProduct insertProd) throws SQLException;

    Integer editProd(MyProduct editProd) throws SQLException;

    Integer delProd(String prodid) throws SQLException;
}
