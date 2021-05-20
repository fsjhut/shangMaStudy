package test.test;

import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.GenerousBeanProcessor;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import test.entity.MyProduct;
import test.utils.DBUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @className: test3
 * @description:   
 * @author SunHang
 * @createTime 2021/5/19 9:36
 */
public class test3 {
    public static List<MyProduct> queryList(String sql, Object... params) throws Exception {
        return new QueryRunner(DBUtil.getDataSource()).query
                (sql,new BeanListHandler<>(MyProduct.class,new BasicRowProcessor(new GenerousBeanProcessor())),params);
    }

    public static void main(String[] args) throws Exception {
        ArrayList<String> strings = new ArrayList<>();
        String sql = "select p.prod_Id,p.prod_name,p.prod_price,p.prod_img,p.prod_desc " +
                "from tb_prod as p ";
        String str1 = "sm23242";
        String str2 = "%游戏%";
//        strings.add(str1);
//        strings.add(str2);
        System.out.println(strings.toArray());
        List<MyProduct> myProducts = queryList(sql, strings.toArray());
        System.out.println(myProducts);
    }
}
