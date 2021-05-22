package com.test.service.impl;

import com.test.dao.impl.CityDaoImpl;
import com.test.entity.MyCity;

import java.util.ArrayList;
import java.util.List;

/**
 * @className: CityService
 * @description:   
 * @author SunHang
 * @createTime 2021/5/22 10:12
 */
public class CityService {
    public List<MyCity> selectByPid(Integer pid){
        CityDaoImpl cityDao = new CityDaoImpl();
        try {
            Integer type = cityDao.queryTypeByPid(pid);
            List<MyCity> myCities = cityDao.queryByPid(pid, type+1);
            System.out.println(myCities);
            return myCities;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
