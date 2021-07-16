package com.javasm.sys.service.impl;

import com.javasm.common.Keys;
import com.javasm.sys.dao.SysuserDao;
import com.javasm.sys.entity.Sysuser;
import com.javasm.sys.service.SysuserService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service("sysuserService")
public class SysuserServiceImpl implements SysuserService {
    @Resource
    private SysuserDao ud;

    @Resource
    private ThreadPoolTaskExecutor taskExecutor;


//    @Resource
//    private RedisTemplate<String, Object> rt;
    //String类型的操作对象
//        ValueOperations<Object, Object> objectObjectValueOperations = rt.opsForValue();
//        ListOperations<Object, Object> objectObjectListOperations = rt.opsForList();
//        HashOperations<Object, Object, Object> objectObjectObjectHashOperations = rt.opsForHash();
//        SetOperations<Object, Object> objectObjectSetOperations = rt.opsForSet();
//        ZSetOperations<Object, Object> objectObjectZSetOperations = rt.opsForZSet();

//    @Override
//    public Sysuser selectByUphone(String uphone) {
//        HashOperations<String, Object, Object> ho = rt.opsForHash();
//        Object o = ho.get(Keys.USERS_HASH, uphone);//把字符串ObjectInputStream反序列化为对象
//        if(o==null){
//            Sysuser u = new Sysuser();
//            u.setUphone(uphone);
//            List<Sysuser> sysusers = ud.selectList(u);
//            if(sysusers.size()==1){
//                Sysuser sysuser = sysusers.get(0);
//                ho.put(Keys.USERS_HASH,uphone,sysuser);//field:uphone,value:sysuser对象.底层ObjectOutputStream把sysuser对象序列化字符串
//                return sysuser;
//            }
//        }
//        return (Sysuser)o;
//    }

    //在执行方法之前,先判断condition条件,为true,则查询缓存users:123123,找到则返回;找不到则执行方法,方法完成后,执行unless判断,为true的话,则不插入缓存
    @Cacheable(cacheNames = "users",key = "#uphone",condition = "#uphone!=null",unless = "#result==null")
    @Override
    public Sysuser selectByUphone(String uphone) {
        Sysuser u = new Sysuser();
        u.setUphone(uphone);
        List<Sysuser> sysusers = ud.selectList(u);
        if (sysusers.size() == 1) {
            Sysuser sysuser = sysusers.get(0);
            return sysuser;
        }
//        "com.javasm.sys.handler.SysuserHandler" com.javasm.sys.handler.UserActiveHandler
//        com.javasm.sys.handler.SysuserHandler
        return null;
    }

    //用在删除与修改方法上
    @CacheEvict(cacheNames = "users",key = "#u.uphone")
    @Override
    public void updateUserByPhone(Sysuser u) {
        ud.updateByPhone(u);
    }

//    @Override
//    public void sendValicode(String uphone) {
//        System.out.println("主线程"+Thread.currentThread().getName());
//
//        taskExecutor.execute(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("异步发短信:"+Thread.currentThread().getName());
//            }
//        });
//    }

    //需要把异步的代码单独提取到一个方法中.com/javasm/sys/service/impl/SysuserServiceImpl.java:78
//    com.javasm.sys.service.impl.SysuserServiceImpl.sendValicode
    @Async
    @Override
    public void sendValicode(String uphone) {
        System.out.println("异步发短信:"+Thread.currentThread().getName());
    }
}
