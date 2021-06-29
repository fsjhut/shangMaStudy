package com.javasm;

import org.junit.Test;
import redis.clients.jedis.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @className: JedisTest
 * @description:   
 * @author SunHang
 * @createTime 2021/6/21 19:32
 */
public class JedisTest {
    //jedis的集群使用
    @Test
    public void test1_jedis(){
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMinIdle(5);
        //多台redis服务器的连接信息
        List<JedisShardInfo> infos = new ArrayList<>();
        JedisShardInfo info1= new JedisShardInfo("127.0.0.1",6379);
        info1.setPassword("root");
        infos.add(info1);
        JedisShardInfo info2= new JedisShardInfo("127.0.0.1",6360);
        info2.setPassword("root");
        infos.add(info2);
        JedisShardInfo info3= new JedisShardInfo("127.0.0.1",6360);
        info3.setPassword("root");
        infos.add(info3);

        //初始化连接池(管理了16384个哈希槽)
        ShardedJedisPool pool= new ShardedJedisPool(config,infos);

        ShardedJedis resource = pool.getResource();

        for(int i=0;i<1000;i++){
            resource.set("a"+i,"v"+i);//  a0.hashcode()%16384=5000
        }

        resource.close();
    }
    //单台redis服务器使用方式如下:
    @Test
    public void test2_JedisPool(){
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMinIdle(5);
        //单例对象
        JedisPool pool = new JedisPool(config,"127.0.0.1",6379,3000,"root");
        //链接对象
        Jedis resource = pool.getResource();
        String s = resource.get("goods:100");
        System.out.println(s);
        resource.close();
    }

    //无连接池使用.了解
    @Test
    public void test3_jedis(){
        Jedis j = new Jedis("127.0.0.1",6379);
        j.auth("root");
        String key="goods:";//组
        for(int i=0;i<1000;i++){
            j.set(key+i,"v"+i);
        }
        String s = j.get(key + 100);
        System.out.println(s);
        j.close();
    }
}
