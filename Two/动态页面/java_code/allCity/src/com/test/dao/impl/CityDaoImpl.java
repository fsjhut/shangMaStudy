package com.test.dao.impl;

import com.test.entity.MyCity;

import java.util.List;

/**
 * @className: selectImp
 * @description:   
 * @author SunHang
 * @createTime 2021/5/22 10:12
 */
public class CityDaoImpl extends BaseDaoImpl<MyCity> {
    private String sql;
    public List<MyCity> queryByPid(Integer pid,Integer type) throws Exception {
        sql = "select id,`area_name` from tb_city where `pid`=? and type = ? ";
        System.out.println(sql);
        return queryList(sql,pid,type);
    }
    public Integer queryTypeByPid(Integer pid) throws Exception{
        sql = "select `type` from tb_city where `id`=? ";
        return Integer.parseInt(querySingleValue(sql, pid).toString());
    }
}
