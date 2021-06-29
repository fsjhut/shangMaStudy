**SSM整合**

首先 建立好项目基本结构后 在resources 下 创建 几个.xml文件和.properties文件 备用

spring-dao.xml                父容器的一部分      如果名字看的不舒服 可以按老师的方式起名为 dao.xml

spring-service.xml      	 父容器                  																				 spring.xml

spring-controller.xml      子容器																								   springmvc.xml

mybatis-config.xml          mybatis配置文件

jdbc.properties        数据库连接相关配置

cors.xml                     跨域相关配置



**1 spring + springmvc**

配置springmvc第一步 是在web.xml文件中 配置DispatcherServlet 来拦截请求

此时所有请求都由会被springmvc前端控制器DispatcherServlet所捕获 已经替代了原本servlet默认的请求处理机制 所以会导致静态资源无法访问 后面会解决此问题

并且 此时contextConfigLocation所定义的xml文件（spring-controller.xml）被DispatcherServlet所加载 并创建出spring ioc 子容器 子容器又会持有父容器  下面会配置父容器

```xml
<!--识别自己的容器中Controller或RestController的bean对象中的springmvc注解 -->
<servlet>
    <servlet-name>dispathcerServlet</servlet-name>
    <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
    <init-param>
      <!--contextConfigLocation参数定义了要装入的 Spring 配置文件 如果没有指定的话，默认会去/WEB-INF/下加载applicationContext.xml-->
        <param-name>contextConfigLocation</param-name>
        <param-value>classpath:spring-controller.xml</param-value>
    </init-param>
    <load-on-startup>1</load-on-startup>
</servlet>

<servlet-mapping>
    <servlet-name>dispathcerServlet</servlet-name>
    <url-pattern>/</url-pattern>
</servlet-mapping>
```

然后我们要配置出spring ioc父容器

ContextLoaderListener 继承自ContextLoader 实现了ServletContextListener接口 

在启动web容器（tomcat）时 会读取contextConfigLocation定义的xml文件（spring-service.xml）创建出父容器放在ServletContext中以供使用

```xml
<context-param>
    <param-name>contextConfigLocation</param-name>
    <param-value>classpath:spring-service.xml</param-value>
</context-param>

<listener>
    <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
</listener>
```

然后 springmvc是与控制层相关的 也就是controller层 所以我们要开始编写spring-controller

***在spring-controller中*** 

控制层相关类 要注册在spring子容器 

所以开启包扫描  扫描所有包下的@controler注解 将其注册进子容器

```xml
<!--禁用默认识别的注解 只识别@controller 注解-->
<context:component-scan base-package="com.lixiangyu" use-default-filters="false">
    <context:include-filter type="annotation" expression="org.springframework.stereotype.Controller"/>
</context:component-scan>
<!--启用注解驱动 代替了处理器映射器HandlerMapping 与处理器适配器HandlerAdapter 会自动将扫描到的注解标记的组件注册到工厂中处理请求  以使得访问路径与方法的匹配可以通过注解配置-->
<mvc:annotation-driven/>
```

```xml
<!--处理静态资源 当DispatcherServlet遇到来自客户端的不能处理的请求时，则会使用Tomcat的Servlet的方法去处理该请求。
也就是让静态资源如html,css,js,images可以访问-->
<mvc:default-servlet-handler/>
<!--配置jsp 显示ViewResolver视图解析器 -->
<bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
    <property name="viewClass" value="org.springframework.web.servlet.view.JstlView"/>
    <property name="prefix" value="/WEB-INF/jsp/"/>
    <property name="suffix" value=".jsp"/>
</bean>
<!--文件上传  指定编码-->
<bean id="multipartResolver" class="org.springframework.web.multipart.commons.CommonsMultipartResolver">
    <property name="defaultEncoding" value="UTF-8"/>
</bean>
```

***在spring-service中*** 

其他要注册进spring容器的类 要注册在spring父容器中

```xml
<!--spring相关配置    排除可以识别的注解  除controller层外bean会注册在父容器-->
<context:component-scan base-package="com.lixiangyu">
    <context:exclude-filter type="annotation" expression="org.springframework.stereotype.Controller"/>
</context:component-scan>
```

引入 spring-dao      spring-dao和 spring-service 其实都是父容器 这样分开写 比较直观 容易理清逻辑

```xml
<import resource="classpath:spring-dao.xml"/>
```

引入cors 跨域配置 

```xml
<import resource="classpath:cors.xml"/>
```

cors跨域配置的编写

直接复制就完事了 都是固定的

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="corsFilter" class="org.springframework.web.filter.CorsFilter">
        <constructor-arg index="0">
            <bean class="org.springframework.web.cors.UrlBasedCorsConfigurationSource">
                <property name="corsConfigurations">
                    <map>
                        <entry key="/**">
                            <bean class="org.springframework.web.cors.CorsConfiguration">
                                <property name="allowCredentials" value="true"/>
                                <property name="allowedMethods">
                                    <list>
                                        <value>GET</value>
                                        <value>POST</value>
                                        <value>HEAD</value>
                                        <value>PUT</value>
                                        <value>DELETE</value>
                                        <value>OPTIONS</value>
                                    </list>
                                </property>
                                <property name="allowedHeaders" value="*"/>
                                <property name="allowedOrigins" value="http://localhost:8088"/>
                            </bean>
                        </entry>
                    </map>
                </property>
            </bean>
        </constructor-arg>
    </bean>
</beans>
```

然后在web.xml文件中配置过滤器代理对象 此过滤器代理对象的doFilter会从父容器中获取我们指定的过滤器对象 所以这也是上面我们要把过滤器对象注入到父容器的原因 

```xml
<filter>
    <filter-name>delegatingFilterProxy</filter-name>
    <filter-class>org.springframework.web.filter.DelegatingFilterProxy</filter-class>
    <init-param>
        <param-name>targetBeanName</param-name>
        <param-value>corsFilter</param-value>
    </init-param>
</filter>
<filter-mapping>
    <filter-name>delegatingFilterProxy</filter-name>
    <url-pattern>/*</url-pattern>
</filter-mapping>
```



这样 spring 与 springmvc就整合好了 这里主要做的工作就是 要把controller层的对象交给spring子容器来管理  其他层的对象交给spring父容器来管理 因为controller层要依赖于service层嘛



**2 spring + mybatis**

首先mybatis是与持久层相关的 也就是dao层 所以我们要写spring-dao的配置

在spring-dao中

想要连接数据库 得先把dataSourse注册进spring容器吧  这里我们使用的是阿里的德鲁伊数据库连接池

除了连接数据库必备的老四样以外 其他属性可以选配

```xml
<bean id="dataSource" class="com.alibaba.druid.pool.DruidDataSource" init-method="init" destroy-method="close">
    <property name="url" value="${jdbc.url}"/>
    <property name="driverClassName" value="${jdbc.driver}"/>
    <property name="username" value="${jdbc.username}"/>
    <property name="password" value="${jdbc.password}"/>
    <property name="initialSize" value="${jdbc.initSize}"/>
</bean>
```

这里value值可以写死也可以写在properties中 我们选择写在properties中  则需要引入jdbc.properties

```xml
<context:property-placeholder location="classpath:jdbc.properties"/>
```

那么properties中写什么要看你在dataSource中配置了什么属性 这里只是简单配了一下 我的数据库是8.0+的版本所以url和5.+版本的同学参数稍有不同    5.+版本的同学把自己之前那个properties文件直接拿过来就好了

```properties
jdbc.url=jdbc:mysql://localhost:3306/ssmbuild?useUnicode=true&;characterEncoding=utf-8&;useSSL=false&;serverTimezone = GMT
jdbc.driver=com.mysql.cj.jdbc.Driver
jdbc.username=root
jdbc.password=19980821
jdbc.initSize=4
```

然后回想一下 mybatis3大核心对象 最开始我们使用mybatis的时候要先用SqlSessionFactoryBuilder解析mybatis配置文件 来获得会话工厂对象 SqlSessionFactory   再使用其的openSession 方法来获得 sqlsession对象   才可以用sqlSession来进行数据库的操作 这样每次要执行重复操作很麻烦 所以要把sqlSessionFactory 这个全局唯一的单例对象 注册到spring容器中 方便我们的使用

那么接下来就是注册sqlSessionFactory

此对象有两个属性是必须注入的 

1 dataSource  数据库连接池配置

2 映射文件位置 这里用通配符的方式批量指定映射文件 就相当于以前我们写完dao接口对应的mapper文件后要在mybatis配置文件中指定 

以上两个属性必须注入

然后是选择性注入的属性 

包别名 不配置就得在需要用到的地方输入全路径名 我感觉也不是很麻烦 右键复制引用即可

引入mybatis配置文件  有些设置无法集成到spring配置文件中  只好以这种间接的方式配置

```xml
<bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
    <!--注入属性值-->
    <!--连接池-->
    <property name="dataSource" ref="dataSource"/>
    <!--Resource资源路径对象 mapper映射文件的位置-->
    <property name="mapperLocations" value="classpath:mapper/*/*.xml"/>
    <!--包别名-->
    <property name="typeAliasesPackage" value="com.lixiangyu"/>
    <!--可省略configLocation   解析mybatis-config.xml配置文件-->
    <property name="configLocation" value="classpath:mybatis-config.xml"/>
    <!--插件-->
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

因为dao已经没有实现类了 所以我们需要为dao层的接口创建代理对象以供service层使用

所以

```xml
<!--把指定包下的所有的接口创建代理对象注册容器-->
<bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
    <property name="basePackage" value="com.lixiangyu.*.dao"/>
</bean>
```

接下来是事务相关配置 主要配置声明式事务 比较常用  配置式事务就不配了

注册事务管理器对象  id必须是transactionManager 它是spring中为我们提供好的事务管理器对象
默认使用的事务管理器对象就是transactionManager 所以id不要改 不然后面要另配置要使用的事务管理器的名字

```xml
<bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
    <!--        要依赖于dataSource 因为要用其打开连接关闭连接  所以要注入它-->
    <property name="dataSource" ref="dataSource"/>
</bean>
```

开启事务注解的识别,注解是@Transactional 会把所有带有此注解的方法织入事务控制 

默认使用的事务管理器对象是transactionManager
在上面注册事务管理器对象id如果没有改就不用另配置了 所以为了省事 注册事务管理器对象时 一定不要改id

```xml
<tx:annotation-driven/>
```

然后写上面已经引入的mybatis配置文件 

因为大部分配置都已经整合到spring中 所以只有少量内容需要设置

```xml
<configuration>
    <settings>
        <!--开启日志-->
        <setting name="logImpl" value="STDOUT_LOGGING"/>
        <!-- 驼峰映射-->
        <setting name="mapUnderscoreToCamelCase" value="true"/>
    </settings>
</configuration>
```



应该是没有遗漏东西 那么到此就配置完成了。



