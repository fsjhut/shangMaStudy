package test.dao.impl;

import test.dao.ProdDao;
import test.entity.MyProduct;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author SunHang
 * @className: ProdDaoImplt
 * @description:
 * @createTime 2021/5/14 16:25
 */
public class ProdDaoImpl extends BaseDaoImpl<MyProduct> implements ProdDao {
    private String sql;

    @Override
    public List<MyProduct> getAllProduct(Integer page, Integer pageSize, MyProduct queryProd) throws Exception {
        // 变量的定义
        List<MyProduct> prodList;
        List paramList = new ArrayList();
        sql = "select p.prod_Id,p.prod_name,p.prod_price,p.prod_img,p.prod_desc from tb_prod as p ";
        // 需要满足用户的查询功能
        //      1. 用户可以根据Id进行查找
        //      2. 用户可以根据name查找 模糊查询
        //      3. 根据Id和name进行查找
        // 需要进行字符串的拼接  queryProd中有前端传递过来的数据，id、name
        Boolean isFirst = true;
//        System.out.println(queryProd.getProdId());
//        System.out.println(queryProd.getProdName());
        if (queryProd.getProdId() != null && (!"".equals(queryProd.getProdId()))) {
            // 说明用户有输入getProdId
            // 判断是否是第一次进入拼接
            isFirst = false;
            // 拼接数据
            sql += " where  p.prod_Id = ? ";
            paramList.add(queryProd.getProdId());
        }
        if (queryProd.getProdName() != null && (!"".equals(queryProd.getProdName()))) {
            // 说明用户有输入Name
            // 判断是否是第一次进入拼接
            if (isFirst) {
                sql += " where ";
//                isFirst = false;
            } else {
                sql += " and ";
            }
            // 拼接数据
            sql += " p.prod_name like ?";
            paramList.add("%" + queryProd.getProdName() + "%");
        }
        System.out.println(page);
        System.out.println((page - 1) * pageSize);
        sql += " order by p.prod_price " + " limit  " + (page - 1) * pageSize + "," + pageSize;
        System.out.println(sql);
//        System.out.println(paramList.get(0));
        // 将参数传递给？中
        if (paramList.size() == 0) {
            prodList = queryList(sql);
        } else if (paramList.size() == 1) {
            prodList = queryList(sql, paramList.get(0));
        } else {
            prodList = queryList(sql, paramList.get(0), paramList.get(1));
        }
        return prodList;
    }

    @Override
    public Integer getAllProductNum(MyProduct queryProd) throws Exception {
        Integer totalNum;
        List paramList = new ArrayList();
        sql = "select count(0) as totalnum from tb_prod tp ";
        //where  tp.prod_id = 'dq010001'  and  tp.prod_name like '%游戏%'
        //用户在商品编号框填入了值
        Boolean isWhere = true;
        if (queryProd.getProdId() != null && !"".equals(queryProd.getProdId())) {
            isWhere = false;
            sql += " where tp.prod_id = ? ";
            paramList.add(queryProd.getProdId());
        }

        if (queryProd.getProdName() != null && !"".equals(queryProd.getProdName())) {
            if (isWhere) {
                sql += " where ";
            } else {
                sql += " and ";
            }
            sql += " tp.prod_name like ? ";
            paramList.add("%" + queryProd.getProdName() + "%");
        }
        System.out.println(sql);
        totalNum = Integer.parseInt(querySingleValue(sql, paramList.toArray()).toString());
        return totalNum;
    }

    @Override
    public MyProduct getProductById(String prodid) throws SQLException {
        sql = "select p.prod_Id,p.prod_name,p.prod_price,p.prod_img,p.prod_desc " +
                "from tb_prod as p where p.prod_Id = ? ";
        return queryOne(sql, prodid);
    }

    @Override
    public Integer insertProd(MyProduct insertProd) throws SQLException {
        sql = "insert INTO tb_prod(prod_id,prod_name,prod_price,prod_img,prod_desc) VALUES (?,?,?,?,?)";
        return update(sql,insertProd.getProdId(),insertProd.getProdName(),insertProd.getProdPrice(),
                            insertProd.getProdImg(), insertProd.getProdDesc());
    }

    @Override
    public Integer editProd(MyProduct editProd) throws SQLException {
        sql = "update tb_prod set prod_name = ?,prod_price = ?,prod_img = ?,prod_desc = ? where prod_id = ?";
        return update(sql,editProd.getProdName(),editProd.getProdPrice(),
                editProd.getProdImg(), editProd.getProdDesc(),editProd.getProdId());
    }

    @Override
    public Integer delProd(String prodid) throws SQLException {
        sql = "delete from tb_prod where   prod_id = ? ";
        return update(sql,prodid);
    }
}
