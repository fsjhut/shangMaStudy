package test.dao.impl;

import test.dao.ProdDao;
import test.entity.Goods;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author SunHang
 * @className: ProdDaoImplt
 * @description:
 * @createTime 2021/5/14 16:25
 */
public class ProdDaoImpl extends BaseDaoImpl<Goods> implements ProdDao {
    private String sql;

    @Override
    public List<Goods> getAllProduct(Integer page, Integer pageSize, Goods queryGoods) throws Exception {
        // 变量的定义
        List<Goods> prodList;
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
        if (queryGoods.getId() != null && (!"".equals(queryGoods.getId()))) {
            // 说明用户有输入getProdId
            // 判断是否是第一次进入拼接
            isFirst = false;
            // 拼接数据
            sql += " where  p.prod_Id = ? ";
            paramList.add(queryGoods.getId());
        }
        if (queryGoods.getName() != null && (!"".equals(queryGoods.getName()))) {
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
            paramList.add("%" + queryGoods.getName() + "%");
        }
        System.out.println(page);
        System.out.println((page - 1) * pageSize);
        sql += " order by p.prod_price " + " limit  " + (page - 1) * pageSize + "," + pageSize;
        System.out.println(sql);
//        System.out.println(paramList.get(0));
        // 将参数传递给？中
        prodList = queryList(sql, paramList.toArray());
        return prodList;
    }

    @Override
    public Integer getAllProductNum(Goods queryGoods) throws Exception {
        Integer totalNum;
        List paramList = new ArrayList();
        sql = "select count(0) as totalnum from tb_prod tp ";
        //where  tp.prod_id = 'dq010001'  and  tp.prod_name like '%游戏%'
        //用户在商品编号框填入了值
        Boolean isWhere = true;
        if (queryGoods.getId() != null && !"".equals(queryGoods.getId())) {
            isWhere = false;
            sql += " where tp.prod_id = ? ";
            paramList.add(queryGoods.getId());
        }
        if (queryGoods.getName() != null && !"".equals(queryGoods.getName())) {
            if (isWhere) {
                sql += " where ";
            } else {
                sql += " and ";
            }
            sql += " tp.prod_name like ? ";
            paramList.add("%" + queryGoods.getName() + "%");
        }
        System.out.println(sql);
        totalNum = Integer.parseInt(querySingleValue(sql, paramList.toArray()).toString());
        return totalNum;
    }

    @Override
    public Goods getProductById(String prodid) throws SQLException {
        sql = "select p.prod_Id,p.prod_name,p.prod_price,p.prod_img,p.prod_desc " +
                "from tb_prod as p where p.prod_Id = ? ";
        return queryOne(sql, prodid);
    }

    @Override
    public Integer insertProd(Goods insertGoods) throws SQLException {
        sql = "insert INTO tb_prod(id,`name`,`price`,img_src,`desc`,stock_num,`status`) VALUES (?,?,?,?,?,?,?)";
        return update(sql,insertGoods.getId(),insertGoods.getName(),insertGoods.getPrice(),
                      insertGoods.getImageSrc(), insertGoods.getDesc(),insertGoods.getStockNum(),
                      insertGoods.getStatus());
    }

    @Override
    public Integer editProd(Goods editGoods) throws SQLException {
        sql = "update tb_goods set `name` = ?,price = ?,img_src = ?,`desc` = ? where id = ?";
        return update(sql,editGoods.getName(),editGoods.getPrice(),
                editGoods.getImageSrc(), editGoods.getDesc(),editGoods.getId());
    }

    @Override
    public Integer delProd(String goodsId) throws SQLException {
        sql = "delete from tb_goods where id = ? ";
        return update(sql,goodsId);
    }
}
