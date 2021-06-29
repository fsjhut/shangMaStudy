# day12_6_21 redis数据库

### 1. Nodql数据库

mysql是关系性数据库，强调的是数据的安全性，可靠性，一致性。

对于超大数据量的查询，效率较低。mysql是根据索引进行查询。

不适合进行超大数据量的使用。---------->分库分表中间件

针对**高并发**下的快速响应，需要引入nosql（非关系性数据库）基于内存进行操作，响应速度快

非关系型，分布式数据存储。

nosql数据库针对不同的应用场景有不同的产品解决方案，

**redis**：k-v内存数据库，用来做缓存，提高响应速度

**hbase**: 列式数据库，超大规模数据的存储，做大数据开发。

**mongodb**：文档数据库，bson文档(json对象)，适合字段需要随意扩展，适合数据分析，爬虫行业。和mysql非常像，mysql能做到的mongodb都可以做到。

* **Neo4j**：是一个高性能的,`NOSQL`图形数据库，它将结构化数据存储在网络上而不是表中。它是一个**嵌入式的**、**基于磁盘的**、具备**完全的事务**特性的`Java`持久化引擎，但是它将结构化数据存储在网络(从数学角度叫做图)上而不是表中。

### 2. redis缓存数据库的使用场景

 如果启动mybatis缓存，占用的是服务器的内存，为了tomcat的性能，一般不会开启mybatis缓存。

redis是占用的专门服务器的内存。

耗时操作，io操作，服务器一般都是设计多线程

对于瞬时操作服务器都是设计为单线程，降低空间消耗。

redis的特性：

* 每秒钟可以处理11万次读操作
* redis自身是基于内存操作，为了提高数据的安全性，做了数据持久化工作
* redis是C语言设计的，单线程设计模型，因此所有的操作指令都是原子性，不存在多线程并发数据安全问题
* redis有丰富的数据类型，key:String, vues:5种数据类型。

使用场景：

* 临时数据：session会话，登录时验证码数据，redis可以设置有效时间
* 高频热点数据：用户信息，排名前10的主播信息。，数据查询效率高，并发优秀。
* 常量数据：不改变的数据，字典项
* 计数器：数据库主键的生成，秒杀活动，利用redis的原子性特性。
* 共享数据

redis带来的问题 

* mysql与redis的一致性问题
  * 同步修改mysql与redis数据强一致
  * 修改mysql，把redis中数据删除（使用频繁）
  * 在向redis中保存数据时，设置数据的时效性，当过了有效期后自动加载新数据到redis（使用频繁）---延迟
* 由于使用了redis降低了mysql的访问压力，mysql数据库服务器的配置降低。
  * 由于数据在同一个时刻大量失效，用户的高并发访问失效数据，同时进入mysql查询数据，缓存被击穿，造成mysql的雪崩。
  * 在设置数据有效期，设置浮动时间，逐步的进行失效。

### 3. 在windows下安装redis

redis.windows.conf 的配置文件

![image-20210621132246190](https://raw.githubusercontent.com/fsjhut/image-hosting/master/md_img/image-20210621132246190.png)

```
port 6379  redis服务器的端口号
databases 16 默认生成的数据库的数量
save 900 1 
save 300 10
save 60 10000 
dbfilename dump.rdb rdb持久化文件名称
dir ./ 文件存储目录
requirepass root 配置redis的密码
appendOnly no 是否开启aof持久化
appendfilename "appendonly6379.aof" aof持久化文件名
auto-aof-rewrite-percentage 100 aof持久化策略
```

redis-service.exe

![image-20210621132230435](https://raw.githubusercontent.com/fsjhut/image-hosting/master/md_img/image-20210621132230435.png)

进入redis安装程序下的路径，redis.window.conf 启动服务器,如果在保存数据时，服务器挂了，则会启动失败，需要进行修复。

* 启动服务器

```
进入redis安装程序的cmd窗口:启动redis服务器
redis-service.exe redis.windows.conf 
```

* 后台启动服务器

```
进入redis安装程序的cmd窗口:启动redis服务器
redis-server.exe --service-install redis.window-service.confg
```

* 启动客户端redis-cli.exe

```
redis-cli.exe -h 127.0.0.1 -p 6379  -a root
```

* 修复持久化文件的错误

```
用来修复格式错误的aof持久化文件.
redis-check-aof.exe --fix aof文件名
------------------------------------
用来修复格式错误的rdb持久化文件.
redis-check-dump.exe --fix rdb文件名
```

* 关闭服务器

```
//卸载命令------->后台启动服务器的情况下的
redis-server.exe --service-uninstall
```

* 两种持久化的区别

```
rdb持久化(数据)：设定指定时间内有多少数据的改变会触发redis持久化到磁盘。

aof持久化(指令)：每1秒把当前时间发生的操作指令保存到aof文件中，当文件达到指定文件大小后，对aof进行压缩重写.
```

### 4. 学习redis的操作指令(重要)

针对redis的value可以有5种数据类型。

* String：计数器，临时数据

  ```xml
  set:默认会覆盖旧值 ex：设置过期时间秒，px:设置过期时间为毫秒
  get 
  incr：每次加1  
  decr：每次减1
  incrby num 10 :加上指定的值
  decrby num 5: 减去指定的值
  getset：设置新值，并返回旧值---->没有线程安全问题，原子性操作
  setex：设置超时的时间
  setnx: 如果原来的值存在，则不做任何事情，如果不存在，则进行操作----------->可以做到分布式锁的概念。
  ```

* hash：能够按照field获取value数据，系统用户的集合。不可以根据索引取值

  ```xml
  hset:域不存在则返回1，域存在则覆盖，返回0
  hsetnx:域不存在则返回1，域存在则不做任何操作，返回0
  hget:
  hexists:域存在则返回1，域不存在则返回0
  hdel:
  hgetall:
  hincrby:
  hkeys:
  hlen:
  hvlas:
  hmset:
  hmget:
  ```

* list：存储集合数据，可重复，有序。（手机客户端接口的前端一般可以用来做遍历）

  ```xml
  lpush:从左边插入数据
  lpop:从左边取出数据
  lrange:lrange al -2 -1 第一个数要比第二个数小（lrange al 0 -1）--->可以取出所有的元素----->包头包尾
  lindex:lindex al -1 可以用正向索引，也可以用反向索引
  llen:返回长度
  linsert:在哪个索引位置插入数据
  lrem greet count mor count>0从头到尾的移除的数量，<0 从尾到头的数量|count| =0全部移除
  ltrim:只保量指定范围的数据，其他的删除                                          
  ```

* set(不常用),存储集合数据,数据不可重复,切无序.适合做集合交并差运算.

  ```xml
  sadd,smembers,sdiff,sinter,sunion
  ```

* sortedSet做数据排名(主播粉丝数排名;阅卷成绩排名)(不常用)

  ```
  zadd
  zcount: 返回成绩区间内的成员数量
  zincrby:
  zrange:返回成绩的升排列的排名区间内的成员
  zrevrange:返回成绩降序排列的排名区间内的成员
  zrangebyScore:返回成绩升序排列的成绩区间内的成员
  zrevrangeByScore:返回成绩降序排列的成绩区间内的成员
  zrank:返回成绩升序排列后的某个成员的排名
  zrerank:返回成绩降序排列后的某个成员的排名
  zscore:返回某个成员的成绩值
  ```

  key的相关操作指令

  ```
  keys,expire ttl ,exists del type rename move dbsize
  sort : 对数字进行排序
sort --- alpha 对字母进行排序
  limit；限制排序后返回的数据数量
  by：可以按照其他的进行排序
  flushdb：清除数据库中的所有的key
  flushall:清除整个数据库中所有key
  select index： 切换到指定的数据库
  expire：给指定的key设置过期时间
  ttl：返回指定key的剩余存活时间
  persist key：移除存活时间的限制
  pexpire:给指定key设置过期时间单位毫秒
  PEXPIREAT
  pexpireat key: 设置过期时间为一个时间戳
  pttl:以毫秒的形式显示过期时间
  
  ```
  
  

### 5. redis与spring的整合

jedis和commuit的jar包

```java
Jedis j = new Jedis("127.0.0.1",6379);
j.auth("root");
j.hset()
  
----------------------------
redis连接池
JedisPoolConfig config = new JedisPoolConfig()
config.setMinIdle(5);  设置初始的连接数量
JedisPool pool = new JedisPool(config,"127.0.0.1",6379,3000,"root")3000:最大的连接时长，当时间超过了3s钟，则退出连接。
Jedis resource = pool.getResource();
----------------------------------------
集群的两个特性：高可用，高扩展。响应式扩容
客户端分片集群方案：已经淘汰的技术
集群：
  JedisSharedconfig
一个集群包含了16384个哈希槽
```



### 6. 在项目中使用redis

redis配置文件

redis.properties配置文件

```properties
jedis.minIdle=5
jedis.host=127.0.0.1
jedis.port=6379
jedis.timeout=3000
jedis.pwd=root
```



切记把JedisPool对象注册到**spring父容器**中.

切记加入ignore-unresolvable="true"属性，在加载properties中，会自动扫描所有的${jedis.host}，因此会出现异常，ignore-unresolvable可以设置允许存在未解析的元素。

```xml
<context:property-placeholder location="classpath:redis.properties" ignore-unresolvable="true"/>
    <bean class="redis.clients.jedis.JedisPoolConfig" id="jedisPoolConfig">
        <property name="minIdle" value="${jedis.minIdle}"/>
    </bean>
    <bean class="redis.clients.jedis.JedisPool">
        <constructor-arg index="0" ref="jedisPoolConfig"/>
        <constructor-arg index="1" value="${jedis.host}"/>
        <constructor-arg index="2" value="${jedis.port}"/>
        <constructor-arg index="3" value="${jedis.timeout}"/>
        <constructor-arg index="4" value="${jedis.pwd}"/>
    </bean>
```

```xml
一般都是给用户用的，因此接口接口都是需要用的
```

* redis连接的单纯使用

```java
public void test3_jedis(){
  // 指定连接地址host和端口号
  Jedsi j = new Jedis("127.0.0.1",6379);
  // 设定登录的密码
  j.auth("root");
  String key = "goods:" ;//key值中如果有:则代表则分组，将goods全部都归位一类
  for(int i=0;i<1000;i++){
            j.set(key+i,"v"+i);
        }
   String s = j.get(key + 100);
   System.out.println(s);
  // j.close() 关闭
   j.close();
}
```

* redis的连接池的使用（常用）

```java
public void test2_jedisPool(){
  JedisPoolConfig config = new JedisPoolConfig();
  // 设置连接池中的初始数量
  config.setMinIdle(5);
  // 单例对象(连接池对象)
  JedisPool pool = new JedisPool(config,"127.0.0.1",6379,3000,"root");
  // 从数据库中获取Jedis对象
  Jedis resource = pool.getResource();
  String s = resoure.get("goods:100");
  // 归还对象到连接池中
  resource.close();
}
```

* redis的集群使用

```java
public void test1_jedis(){
  JedisPoolConfig config = new JedisPoolConfig();
  config.setMinIdle(5);
  List<JedisShardInfo> infos = new ArrayList<>();
  JedisShardInfo info1 = new JedisShardInfo("127.0.0.1",6379);
  info1.setPassword("root");
  infos.add(info1);
   JedisShardInfo info2= new JedisShardInfo("127.0.0.1",6360);
  info2.setPassword("root");
  infos.add(info2);
  //初始化连接池(管理了16384个哈希槽)
  ShardedJedisPool pool= new ShardedJedisPool(config,infos);
  ShardedJedis resource = pool.getResource();
  for(int i=0;i<1000;i++){
    resource.set("a"+i,"v"+i);//  a0.hashcode()%16384=5000
  }
  resource.close();
}
```



### 7. redis的应用

