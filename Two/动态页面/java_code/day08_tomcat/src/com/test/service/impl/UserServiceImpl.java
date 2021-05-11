package com.test.service.impl;

import com.test.entity.MyUser;
import com.test.dao.UserDao;
import com.test.dao.impl.UserDaoImpl;
import com.test.service.UserService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author SunHang
 * @className: UserServiceImpl
 * @description:
 * @createTime 2021/5/8 15:36
 */
public class UserServiceImpl implements UserService {
//    public int insertUser(User insertUser) {
//        UserDao ud = new UserDaoImpl();
//        //业务逻辑
//        insertUser.setPhone("(+86)"+insertUser.getPhone());
//        return ud.insertUser(insertUser);
//    }

    @Override
    public int insertUser(String name, String password,
                          String phone, String email, String gender,
                          String birth, String prov, String city, String county,
                          String areaDetail, String resume, String comment) {
        /*
         * 业务逻辑
         *
         * 1.得到的数据 与最终操作的数据不同(格式  数据内容不同)
         * 2.组织和调用不同的dao  最小数据操作粒度
         * */
        UserDao userDao = new UserDaoImpl();
        //业务逻辑
//        insertUser.setPhone("(+86)"+insertUser.getPhone());
//        return ud.insertUser(insertUser);
        String format = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        Date birthDate = null;
        String newGender = null;
        if ("1".equals(gender)) {
            newGender = "女";
        } else if ("0".equals(gender)) {
            newGender = "男";
        } else if ("2".equals(gender)) {
            newGender = "保密";
        }
        // birth 由字符串转为date  2021-05-11
        try {
            birthDate = simpleDateFormat.parse(birth);
        } catch (ParseException e) {
            e.printStackTrace();
        }
//        System.out.println(birthDate);
//        MyUser user1 = new MyUser("sim");
//        System.out.println(user1);
        MyUser user = new MyUser(name, password, phone, email, newGender, birthDate, prov,
                city, county, areaDetail, resume, comment);
        return userDao.insertUser(user);
    }
}
