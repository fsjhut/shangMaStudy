## day09_6_16_springSSM整合

### 1.springmvc与spring的整合

#### mvc结构示意图

![image-20210616132839805](https://raw.githubusercontent.com/fsjhut/image-hosting/master/md_img/image-20210616132839805.png)

![image-20210616130721939](https://raw.githubusercontent.com/fsjhut/image-hosting/master/md_img/image-20210616130721939.png)

* 添加spring核心包,springMVC核心包，数据库包，文件上传包，json包

* 配置xml配置文件，了解DispatcherServlet的init方法内部加载指定的xml，创建

* ![image-20210616105745884](https://raw.githubusercontent.com/fsjhut/image-hosting/master/md_img/image-20210616105745884.png)

* tomcat基础知识

  * ![image-20210616103550663](https://raw.githubusercontent.com/fsjhut/image-hosting/master/md_img/image-20210616103550663.png)

  * **启动tomcat时，创建ServletContext对象，执行ServletContextListener 监听器的contextInit方法，传入ServletContext。该对象是一个 全局唯一的单例对象，用来存储数据。**

  * 当用户首次通过客户端，连接tomcat服务去器发起请求时，tomcat检测到这个用户是新用户，创建HttpSession对象，里面有（Sessionid，map,servletContext）,执行HttpSessionListener监听器，请求结束时，把业务数据转为json字符串返回前端，同时在cookie中添加sessionid字符串返回前端

  * 前端把sessionid字符串保存到客户端的游览器的cookie域中。

    * listener：监听器，**监听特定对象的创建** ，当某个事件发生时执行对应的监听器方法（**ServletContextListener** contextInit|contextDestroy） 

      HttpSessionListener：可以做异地登录

      HttpServletRequestListener:

  * filter：过滤器，过滤用户每一次请求url（安全性的工作），都走doFilter方法

* ![image-20210616111910787](https://raw.githubusercontent.com/fsjhut/image-hosting/master/md_img/image-20210616111910787.png)



了解DispathcerServlet的init方法，内部加载指定的xml，创建了WebApplicationContext对象

```java
WebApplicationContext parent = servletContext.getAttribute("WebApplicationContext.ROOT");//监听器中创建的容器

WebApplicationContext wac = new XmlWebApplicationContext();
wac.setParent(parent);//持有了另外一个parent容器对象(监听器中的web)
wac.setConfigLocation("classpath:springmvc.xml");//指定xml配置文件目录
wac.setServletContext(servletContext);
wac.refresh();//加载xml文件,初始化容器对象
```

了解ContextLoaderListener监听器内的contextInitialized方法创建了WebApplicationContext容器对象

```java
WebApplicationContext wac = new XMLWebApplicationContext()
wac.setServletContext(servletContext);
wac.setConfigLocation("classpath:spring.xml");
wac.refresh();
servletContext.setAttribute("WebApplicationContext.ROOT", wac);
```

子容器能调用父容器中的bean;父不能调子.

进行aop织入的时候,一定分清楚要织入的目标对象是哪个容器的

- 在web.xml配置ContextLoaderListener

```xml
 <context-param>
        <param-name>contextConfigLocation</param-name>
        <param-value>classpath:spring.xml</param-value>
    </context-param>

    <listener>
        <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
    </listener>
```

spring.xml

```xml
  <!--spring相关配置-->
    <context:component-scan base-package="com.javasm">
        <context:exclude-filter type="annotation" expression="org.springframework.stereotype.Controller"></context:exclude-filter>
    </context:component-scan>
```



- 在web.xml配置DispatcherServlet

```xml
<!--识别自己的容器中Controller或RestController的bean对象中的springmvc注解 -->
    <servlet>
        <servlet-name>dispathcerSevlet</servlet-name>
        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
        <init-param>
            <param-name>contextConfigLocation</param-name>
            <param-value>classpath:springmvc.xml</param-value>
        </init-param>
        <load-on-startup>1</load-on-startup>
    </servlet>

    <servlet-mapping>
        <servlet-name>dispathcerSevlet</servlet-name>
        <url-pattern>/</url-pattern>
    </servlet-mapping>
```

springmvc.xml

```xml
 <!--mvc相关配置-->
    <context:component-scan base-package="com.javasm" use-default-filters="false">
        <context:include-filter type="annotation" expression="org.springframework.stereotype.Controller"></context:include-filter>
    </context:component-scan>

    <mvc:annotation-driven></mvc:annotation-driven>

    <mvc:default-servlet-handler></mvc:default-servlet-handler>

    <bean id="multipartResolver" class="org.springframework.web.multipart.commons.CommonsMultipartResolver">
        <property name="defaultEncoding" value="UTF-8"></property>
    </bean>
```

### 2.mybatis与spring的整合

mybatis的几个核心对象：SqlSessionFactoryBuilder构建器对象，用来加载xml文件创建出Factory

​	SqlSessionFactory全局唯一的单例对象

​	SqlSession会话对象，用来操作数据库，瞬时对象

​	getMapper方法得到的Dao接口代理对象：代理对象，一直存在

* 添加DruidDataSource，mysql驱动包
* 添加Mybatis的核心包，添加整合包mybatis-spring整合包
* 添加spring-jdbc包,spring-tx包.整合mybaits进行事务控制.
* 配置DruidDataSource连接池对象到spring父容器

```xml
<!--mybatis整合的相关配置-->
    <context:property-placeholder location="classpath:jdbc.properties"></context:property-placeholder>

    <bean id="dataSource" class="com.alibaba.druid.pool.DruidDataSource" init-method="init" destroy-method="close">
        <property name="url" value="${jdbc.url}"></property>
        <property name="driverClassName" value="${jdbc.driver}"></property>
        <property name="username" value="${jdbc.username}"></property>
        <property name="password" value="${jdbc.password}"></property>
        <property name="initialSize" value="${jdbc.initSize}"></property>
    </bean>
```

* 创建Configuration,创建sqlSessionFactory，并注册该对象到spring父容器中

  ```xml
  <!--创建Configuration,创建SqlSessionFactory-->
      <bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
          <property name="dataSource" ref="dataSource"></property>
          <property name="mapperLocations" value="classpath:mapper/*/*.xml"></property><!--Resource资源路径对象-->
          <property name="typeAliasesPackage" value="com.javasm"></property>
          <!--可省略configLocation-->
          <property name="configLocation" value="classpath:mybatis-config.xml"></property>
          <property name="plugins">
              <array>
                  <!--获取线程变量中的分页对象,该插件需要指定分页参数合理化配置-->
                  <bean class="com.github.pagehelper.PageInterceptor">
                      <property name="properties">
                          <value>reasonable=true</value>
                      </property>
                  </bean>
              </array>
          </property>
      </bean>
  ```

* 注册dao接口代理对象到spring父容器中

```xml
 <!--把指定包下的所有的接口创建代理对象注册容器,包名一定要指定dao层-->
    <bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
        <property name="basePackage" value="com.javasm.*.dao"></property>
    </bean>
```

### 3.使用spring的事务服务

spring的事务使用方式有声明式事务，编程式事务（不用）

注册事务管理器对象到spring容器

创建Configuration,创建SqlSessionFactory的过程

```java
SqlSessionFactoryBean implements InitializingBean{
  private SqlSessionFactory f;
  afterPropertiesSet{
    Configuration config = new Configuration();
    XmlConfiguration cb = new XmlConfigBuilder("classpath:mybatis.xml",config);
    // 解析配置文件 
    cb.parse();
    // 解析映射文件
    for(Resource r:"classpath:mapper/*/*.xml"){
      XmlMapperBuilder mb = new XmlMapperBuilder("sysUser_mapper.xml",config);
      mb.parse()
    }
    config.setEnvirments(dataSource);
    // 解析别名文件
    config.regiTypeAlis("com.javasm")
    f = new DefaultSqlSessionFactory(config)
  }
}
```



```xml
  <bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
        <property name="dataSource" ref="dataSource"></property>
    </bean>
```

声明式事务

注解式：<tx:annotation-driven>

配置式：两层的筛选过程，先对符合条件全部添加事务，然后再根据细则（方法名）进行筛选，都满足条件则事务生效。缺点：对符合命名规则的，全部都开启事务，因此很少使用这种方式进行事务的配置

```xml
<!--显示的定义事务通知-->
    <tx:advice id="txAdvice">
        <tx:attributes>
            <tx:method name="add*" propagation="REQUIRED"  rollback-for="java.lang.Exception"/>
            <tx:method name="insert*" propagation="REQUIRED"  rollback-for="java.lang.Exception"/>
            <tx:method name="save*" propagation="REQUIRED"  rollback-for="java.lang.Exception"/>
            <tx:method name="update*" propagation="REQUIRED"  rollback-for="java.lang.Exception"></tx:method>
            <tx:method name="edit*" propagation="REQUIRED"  rollback-for="java.lang.Exception"></tx:method>
            <tx:method name="del*" propagation="REQUIRED"  rollback-for="java.lang.Exception"></tx:method>
            <tx:method name="select*" propagation="SUPPORTS"  rollback-for="java.lang.Exception"></tx:method>
            <tx:method name="query*" propagation="SUPPORTS"  rollback-for="java.lang.Exception"></tx:method>
            <tx:method name="get*" propagation="SUPPORTS"  rollback-for="java.lang.Exception"></tx:method>
        </tx:attributes>
    </tx:advice>

    <!--把txAdvice事务通知织入到servicePointcut切入点-->
    <aop:config>
        <aop:pointcut id="servicePointcut" expression="execution(* com.javasm.*.service.impl.*.*(..))"></aop:pointcut>
        <aop:advisor advice-ref="txAdvice" pointcut-ref="servicePointcut"></aop:advisor>
    </aop:config>
```

**事务的回滚操作：**是否对所有的异常生效------->只对runtimeException异常进行回滚操作，因此建议对受检异常都需要自己进行捕获处理，如果不想处理则指定rooback-for=Exception

### 4.使用mybatis的分页插件

利用mybatis的插件，进行拦截器的配置

* 添加pageHelper分页插件的两个jar包，pageHelper.jar jsqlparser.jar
* 把分页插件PageIneterceptor配置到SqlSessionFactory对象中

```xml
<!--创建Configuration,创建SqlSessionFactory-->
    <bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
        <property name="dataSource" ref="dataSource"></property>
        <property name="mapperLocations" value="classpath:mapper/*/*.xml"></property><!--Resource资源路径对象-->
        <property name="typeAliasesPackage" value="com.javasm"></property>
        <!--可省略configLocation-->
        <property name="configLocation" value="classpath:mybatis-config.xml"></property>
        <property name="plugins">
            <array>
                <!--获取线程变量中的分页对象,该插件需要指定分页参数合理化配置-->
                <bean class="com.github.pagehelper.PageInterceptor">
                    <property name="properties">
                        <value>reasonable=true</value>
                    </property>
                </bean>
            </array>
        </property>
    </bean>
```

* 在查询列表之前，启用分页（在线程变量中保存了分页参数Page）

* 注意：因为该插件拦截了sql语句的执行，因此每次调用startPage()只能使用一次，尽量在需要使用的地方进行startPage使用

* ```java
  @GetMapping("list")
  public PageInfo selectList(Sysuser u, @RequestParam(defaultValue = "1") Integer pageNum,@RequestParam(defaultValue = "2") Integer pageSize){
    PageHelper.startPage(pageNum,pageSize);//启用分页,配置分页参数到线程变量
    List<Sysuser> sysusers = userService.selectList(u);//分页拦截器使用了线程变量中的分页参数后,把线程变量中的分页数据移出.
    return new PageInfo(sysusers);//获取分页数据,total,list,pageNum,pageSize
  }
  ```

**理解+记忆**

将ssm框架整合完毕，自己配置两次完整的ssm框架，必须自己手动配置

项目整合，进行单表的查询。

* 添加pageHelper分页插件的jar包

