package test.dao;

import java.sql.SQLException;
import java.util.List;

/**
 * @author SunHang
 * @className: BaseDao
 * @description: 对通用的增删改查 进行抽取
 *               1. 使用数据库连接池
 *               2. 使用queryRunner进行查询对象的自动封装
 *               3. 配置数据库的连接文件
 * @createTime 2021/5/17 17:31
 */
public interface BaseDao <T>{
    /**
     * 执行update，delete,insert语句
     *
     * @param sql
     *            要执行的sql语句
     * @param params
     *            执行的sql语句的参数
     * @return 如果语句执行成功返回true<br/>
     *         如果执行失败返回false
     * @throws SQLException
     */
    int update(String sql, Object... params) throws SQLException;

    /**
     * 执行查询语句，只返回第一个记录
     *
     * @param sql
     *            要执行的sql语句
     * @param params
     *            执行的sql语句的参数
     * @return 返回查询对象的具体实例 <br/>
     *         如果查询的数据不存在，则返回null<br/>
     *         查询失败也返回null
     * @throws SQLException
     */
    T queryOne(String sql, Object... params) throws SQLException;

    /**
     * 执行查询语句，返回查询后的对象实例集合
     *
     * @param sql
     *            要执行的sql语句
     * @param params
     *            sql语句的参数
     * @return 返回的是查找到的对象集合<br/>
     *         查询失败返回null
     * @throws Exception
     */
    List<T> queryList(String sql, Object... params) throws Exception;

    /**
     * 执行批量操作
     *
     * @param sql
     *            要执行的sql语句
     * @param params
     *            参数
     * @return 返回每个语句修改的数量
     * @throws Exception
     */
    int[] batch(String sql, Object[][] params) throws Exception;

    /**
     * 查询只有一个返回值的语句
     *
     * @param sql
     * @param params
     * @return
     * @throws Exception
     */
    Object querySingleValue(String sql, Object... params) throws Exception;

}
