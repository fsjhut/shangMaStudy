package com.javasm.sys.service.impl;

import com.alibaba.fastjson.JSON;
import com.javasm.base.BaseServiceImpl;
import com.javasm.commons.cache.Keys;
import com.javasm.commons.cache.RedisService;
import com.javasm.commons.entity.S;
import com.javasm.sys.dao.SysuserDao;
import com.javasm.sys.entity.Sysuser;
import com.javasm.sys.service.SysuserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("sysuserService")
public class SysuserServiceImpl extends BaseServiceImpl<SysuserDao, Sysuser> implements SysuserService {

    @Resource
    private RedisService rs;

    @Override
    public Sysuser selectByUname(String uname) {

        // 先根据用户名查询redis中的数据，如果没有则查询mysql
        // 如果mysql中查询到了结果，则把结果保存到redis中
        // 思考？用户数据该如何保存在redis数据库中呢？集合，还是列表呢
        // tomcat 启动时如何将所有的字典数据放入缓存呢。
        String result = rs.hget(Keys.USERS_HASH, uname);
        if (result != null) {
            //TODO 将字符串中数据返回
            return JSON.parseObject(result, Sysuser.class);
        }
        Sysuser u = new Sysuser();
        u.setUname(uname);
        List<Sysuser> sysusers = super.selectList(u);
        if (sysusers.size() != 0) {
            Sysuser sysuser = sysusers.get(0);
            rs.hset(Keys.USERS_HASH, uname, JSON.toJSONString(sysuser));
            return sysuser;
        }
        return null;


    }

    @Override
    public boolean comparePwd(String upwd, String upwd1) {
        if (upwd == null || upwd1 == null) {
            return false;
        }
        return upwd.equals(upwd1);
    }

    @Override
    public void sendValicode(String uphone, String s) {
        // TODO:发送短信

        // 服务器存储值，5分钟有效时间
        String key = Keys.CODE_STRING + uphone;
        rs.setex(key, 5 * 60, s);
        System.out.println(s);
    }

    @Override
    public Boolean compareValiecode(String uphone, String code) {
        String key = Keys.CODE_STRING + uphone;
        String serverCode = rs.get(key);
        if (serverCode == null) {
            return false;
        }
        // 移除服务器中的验证码，一个验证码只可以登录一次
        rs.del(key);
        return serverCode.equals(code);
    }

    // 先在redis中查找，如果查询不到再在服务器中查找，并放入redis中
    @Override
    public Sysuser selectUserByPhone(String uphone) {
        String result = rs.hget(Keys.USERS_HASH, uphone);
        if (result != null) {
            //TODO 将字符串中数据返回
            return JSON.parseObject(result, Sysuser.class);
        }
        Sysuser sysuser = new Sysuser();
        sysuser.setUphone(uphone);
        List<Sysuser> sysusers = super.selectList(sysuser);
        if (sysusers.size() == 1) {
            Sysuser sysuser2 = sysusers.get(0);
            rs.hset(Keys.USERS_HASH, uphone, JSON.toJSONString(sysuser2));
            return sysuser;
        }
        return null;
    }

    // 自动注册，前端完善信息
    @Override
    public Sysuser registUser(String uphone) {
        // 返回一个前端页面，让用户完善信息
        Sysuser sysuser = new Sysuser();
        sysuser.setUphone(uphone);
        if (super.add(sysuser)) {
            return sysuser;
        }
        return null;

    }

    @Override
    public List<Sysuser> selectUserAndDeptList(Sysuser obj) {
        return dao.selectUserAndDept(obj);
    }
}
