package test.dao.impl;

import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.GenerousBeanProcessor;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import test.dao.BaseDao;
import test.utils.DBUtil;

import java.lang.reflect.ParameterizedType;
import java.sql.SQLException;
import java.util.List;

/**
 * @className: BaseDaoImpl
 * @description:   
 * @author SunHang
 * @createTime 2021/5/17 17:38
 */
public class BaseDaoImpl<T> implements BaseDao<T> {
    /**
     * DBUtils操作数据库需要使用的类
     */
    /**
     * 保存BaseDaoImpl类的泛型对象class类型
     */
    protected Class<T> type;

    @SuppressWarnings("unchecked")
    public BaseDaoImpl() {
        // 创建一个QueryRunner对象实例
        // 获取父类中带有泛型的父类的class类型
        ParameterizedType supperClass = (ParameterizedType) getClass().getGenericSuperclass();
        // 获取泛型中的具体的类型的class
        type = (Class<T>) supperClass.getActualTypeArguments()[0];
    }

    @Override
    public int update(String sql, Object... params) throws SQLException {
        return new QueryRunner(DBUtil.getDataSource()).update(sql,params);
    }

    @Override
    public T queryOne(String sql, Object... params) throws SQLException {
        return new QueryRunner(DBUtil.getDataSource()).query
                (sql,new BeanHandler<>(type,new BasicRowProcessor(new GenerousBeanProcessor())),params);
    }

    @Override
    public List<T> queryList(String sql, Object... params) throws Exception {
        return new QueryRunner(DBUtil.getDataSource()).query
                (sql,new BeanListHandler<>(type,new BasicRowProcessor(new GenerousBeanProcessor())),params);
    }

    @Override
    public int[] batch(String sql, Object[][] params) throws Exception {
        return new QueryRunner(DBUtil.getDataSource()).batch(sql,params);
    }

    @Override
    public Object querySingleValue(String sql, Object... params) throws Exception {
        return new QueryRunner(DBUtil.getDataSource()).query(sql,new ScalarHandler(),params);
    }
}
