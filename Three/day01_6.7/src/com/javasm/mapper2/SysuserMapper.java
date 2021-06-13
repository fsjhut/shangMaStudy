package com.javasm.mapper2;

import com.javasm.entity.Sysuser;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author SunHang
 * @className: SysuserMapper
 * @description:
 * @createTime 2021/6/7 20:19
 */
public interface SysuserMapper {
    Sysuser selectById(int uid);
    List<Sysuser> selectUsers();
    List<Sysuser> selectUsers2(Map<String,String> u);
    // @Param,可以设置封装为map后的key的值，若不设置则自动为0，1等
    List<Sysuser> login(@Param("uname2") String uname, @Param("upwd2") String upwd);

    int addUser(Sysuser u);
    int updateUser(Sysuser u);
    int del(int uid);
    // 第一种查询方法，手动连表查询
    Sysuser selectUserById(int uid);
    // 第二种查询的方法，进行sql语句的联合查询
    Sysuser selectUserAndRoleById(int uid);
    // 第三种查询方法，利用mybatis进行自动两次查询
    Sysuser selectUserAndRoleById2(int uid);

    List<Sysuser> selectUsersAndRole();
}
