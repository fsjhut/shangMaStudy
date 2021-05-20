package test.service.impl;


import test.dao.ProdDao;
import test.dao.impl.ProdDaoImpl;
import test.entity.Goods;
import test.service.ProdService;

import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

/**
 * @author SunHang
 * @className: ProdServiceImpl
 * @description:
 * @createTime 2021/5/14 16:25
 */
public class ProdServiceImpl implements ProdService {
    private ProdDao prodDao = new ProdDaoImpl();
    //    private Integer allProductNum;
    @Override
    public List<Goods> getAllProduct(Integer page, Integer pageSize, Goods queryProd) {
        try {
            return prodDao.getAllProduct(page, pageSize, queryProd);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Integer getTotalPage(Integer pageSize, Goods queryProd) {
        // 查询 所有 的数据记录
        Integer allProductNum = null;
        try {
            allProductNum = prodDao.getAllProductNum(queryProd);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Integer totalPage;
        Objects.requireNonNull(allProductNum);
        totalPage = allProductNum % pageSize > 0 ? (allProductNum / pageSize) + 1 : allProductNum / pageSize;
        return totalPage;
    }

    @Override
    public Goods getProductById(String goodsId) {
        try {
            return prodDao.getProductById(goodsId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Integer insertProd(Goods insertProd) {
        try {
            return prodDao.insertProd(insertProd);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Integer editProd(Goods editProd) {
        try {
            return prodDao.editProd(editProd);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Integer delProd(String goodsId) {
        try {
            return prodDao.delProd(goodsId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
