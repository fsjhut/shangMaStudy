## SSM框架的整合

### 1.服务器的三层架构

![image-20210616175601668](https://raw.githubusercontent.com/fsjhut/image-hosting/master/md_img/image-20210616175601668.png)

什么是框架？

它是软件开发中的一套解决方案，不同的框架解决不同的问题，框架封装了很多细节，可以使开发者使用极简的方式实现功能，大大提高了开发的效率

三层架构：

* 表现层：用来展示数据
* 业务层：处理业务需求
* 持久层：和数据库进行交互

持久层的技术解决方案：

​	JDBC技术（规范）：Connection PreparedStatement ResultSet

​	Spring的JdbcTemplate（工具类）：Spring中对jdbc的简单封装

​	Apache的DBUtils（工具类）：和Spring的JdbcTemplate很类似

### 2、springMVC简介

springMVC是一种基于java的实现MVC设计模式的请求驱动类型的轻量级WEB框架。

特点：通过一套注解，可以让一个java类成为处理请求的控制器，无需实现任何接口，同时支持RESTful编程风格的请求。

![image-20210616183612820](https://raw.githubusercontent.com/fsjhut/image-hosting/master/md_img/image-20210616183612820.png)

优势：清晰的角色划分

* springMVC是基于方法设计的

* 前端控制器DispathcerServlet
* 请求到处理器映射HandlerMapping
* 处理器适配器HandlerAdapter
* 视图解析器ViewResolver
* 处理器或页面控制器Controller
* 验证器Validator
* 命令对象Command(请求参数绑定的对象就叫做命令对象)
* 表单对象Form Object（提供表单展示和提交的对象）

### 搭建整合环境

* 整合说明（怎么简单怎么来）：SSM整合可以使用多种方式，一般采用XML+注解的方式
* 整合的思路：**spring是基础，用spring去整合其他的框架**	
  * 先搭建整合的环境
  * 先把Spring配置环境搭建完成
  * 使用Spring整合SpringMVC框架
  * 使用Spring整合MyBatis框架

spring配置的搭建

* 开启注解的扫描

* ```xml
  <!--开启包扫描，只处理service和dao。不扫描controller包下的文件-->
  <context:component-scan base-package="com.javasm">
    <context:exclude-filter type="annotation" expression="org.springframework.stereotype.Controller"/>
  </context:component-scan>
  ```

springMVC配置的搭建

* 在tomcat的xml文件中配置前端控制器（DispathcerServlet）

```xml
<!--配置前端控制器-->
<servlet>
  <servlet-name>dispatcherServlet</servlet-name>
  <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
  <!--加载springmvc.xml配置文件-->
  <init-param>
    <param-name>contextConfigLocation</param-name>
    <param-value>classpath:springmvc.xml</param-value>
  </init-param>
  <load-on-startup>1</load-on-startup>
</servlet>
<servlet-mapping>
  <servlet-name>dispatcherServlet</servlet-name>
  <url-pattern>/</url-pattern>
</servlet-mapping>
```

* 解决中文乱码的过滤器

```xml
<!--配置解决中文乱码的过滤器-->
<filter>
  <filter-name>characterEncodingFilter</filter-name>
  <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
  <!--配置初始化参数-->
  <init-param>
    <param-name>encoding</param-name>
    <param-value>UTF-8</param-value>
  </init-param>
</filter>
<filter-mapping>
  <filter-name>characterEncodingFilter</filter-name>
  <url-pattern>/</url-pattern>
</filter-mapping>
```

* springmvc文件的配置

  * 开启注解扫描（只配置Controller的注解）

  ```xml
  <context:component-scan base-package="com.javasm">
    <context:include-filter type="annotation" expression="org.springframework.stereotype.Controller"/>
  </context:component-scan>
  ```
  * 配置视图解析器对象

  ```xml
  <!--配置视图解析器对象-->
  <bean id="internalResourceViewResolver" class="org.springframework.web.servlet.view.InternalResourceViewResolver">
    <property name="prefix" value="/pages/"/>
    <property name="suffix" value=".jsp"/>
  </bean>
  ```

  * 过滤静态资源

  ```xml
  <!--过滤静态资源-->
  <mvc:resources mapping="/css/**" location="/pages/css/"></mvc:resources>
  <mvc:resources mapping="/imgs/**" location="/pages/imgs/"></mvc:resources>
  <mvc:resources mapping="/js/**" location="/pages/js/"></mvc:resources>
  ```

  * 开启springMVC注解的支持

  ```xml
  <!--开启mvc注解驱动的支持-->
  <mvc:annotation-driven></mvc:annotation-driven>
  ```

* spring和springMVC的整合，整合的目的是：在控制层可以调用业务层的代码，而spring的配置文件在tomcat服务器中是未生效的状态，因此需要先将spring.xml配置进去

![image-20210616202815128](https://raw.githubusercontent.com/fsjhut/image-hosting/master/md_img/image-20210616202815128.png)

```xml
<!--配置spring的监听器,默认只加载web-inf目录下的applicationContext.xml文件-->
<listener>
  <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
</listener>
<!--设置加载spring.xml配置文件的路径-->
<context-param>
  <param-name>contextConfigLocation</param-name>
  <param-value>classpath:spring.xml</param-value>
</context-param>
```

* 搭建mybatis框架的配置环境

```xml
<configuration>
    <!--配置数据库连接properties文件的路径-->
    <properties resource="jdbc.properties"/>
    <!--常用setting的配置-->
    <settings>
        <!--开启日志 stdout_loggin：代表将日志文件输出到控制台中-->
        <setting name="logImpl" value="STDOUT_LOGGING"/>
        <!--开启驼峰命名映射-->
        <setting name="mapUnderscoreToCamelCase" value="true"/>
    </settings>
    <!--配置别名-->
    <typeAliases>
        <!--在创建Configuration对象,对指定包下的所有的类,做别名映射,把类名小写作为别名,映射文件中的resultType忽略大小写-->
        <package name="com.javasm"/>
        <!--对单个的类使用别名-->
        <!--<typeAlias type="com.javasm.sys.entity.SysUser" alias="sysuser"></typeAlias>-->
    </typeAliases>

    <!--配置数据库环境-->
    <environments default="dev">
        <!--在一个项目中可能有多个分库分表操作，后续有专门的mycat中间件做分库操作-->
        <!--第一个数据库环境-->
        <environment id="dev">
            <transactionManager type="JDBC"/>
            <dataSource type="POOLED">
                <property name="driver" value="${jdbc.driver}"/>
                <property name="url" value="${jdbc.url}"/>
                <property name="username" value="${jdbc.username}"/>
                <property name="password" value="${jdbc.password}"/>
            </dataSource>
        </environment>
    </environments>

    <!--引入映射文件-->
    <mappers>
        <!--<mapper class="com.javasm.goods.dao.GoodsDao"></mapper>-->
        <!--配置包，代表可以在该包下的所有文件都生效-->
        <package name="com.javasm.goods.dao"/>
    </mappers>
</configuration>
```

* spring和mybatis的整合

**思路:** 如何将GoodsDao对象注入容器中，因为GoodsDao是一个接口，因此是需要将生成的代理对象注册到spring容器中。

* 配置连接池
* 配置SqlSessionFactory工厂
* 配置接口所在的包
* 配置Spring框架的声明式事务管理

```xml
<!--配置和mybatis的整合-->
<!--配置连接池-->
<context:property-placeholder location="classpath:jdbc.properties"></context:property-placeholder>
<bean id="dataSource" class="com.alibaba.druid.pool.DruidDataSource" init-method="init" destroy-method="close">
  <property name="url" value="${jdbc.url}"></property>
  <property name="driverClassName" value="${jdbc.driver}"></property>
  <property name="username" value="${jdbc.username}"></property>
  <property name="password" value="${jdbc.password}"></property>
  <property name="initialSize" value="${jdbc.initSize}"></property>
</bean>
<!--配置SqlSessionFactory工厂-->
<bean id="sqlSessionFactoryBean" class="org.mybatis.spring.SqlSessionFactoryBean">
  <property name="dataSource" ref="dataSource"></property>
</bean>
<!--配置接口所在的包-->
<bean id="transactionManager" class="org.mybatis.spring.mapper.MapperScannerConfigurer">
  <property name="basePackage" value="com.javasm.*.dao"></property>
</bean>
<!--配置Spring框架的声明式事务管理-->
<!--配置事务管理-->
<bean id="dataSourceTransactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
  <property name="dataSource" ref="dataSource"></property>
</bean>
<!--配置事务注解的识别-->
<tx:annotation-driven></tx:annotation-driven>
<!--配置事务的通知-->
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
<!--配置AOP的增强-->
<!--把txAdvice事务通知织入到servicePointcut切入点-->
<!--返回值，包名，类名，方法名，形参列表-->
<aop:config>
  <aop:pointcut id="servicePointcut" expression="execution(* com.javasm.*.service.impl.*.*(..))"></aop:pointcut>
  <aop:advisor advice-ref="txAdvice" pointcut-ref="servicePointcut"></aop:advisor>
</aop:config>

```

### 整合总结

tomcat的配置文件web.xml的配置

* 配置监听器listener,该监听器中的初始化参数为spring的配置文件
* 配置过滤器，过滤器参数为跨域配置的配置文件
* 配置DispatcherServlet,通过servlet配置springmvc的配置文件
* 配置springmvc的servlet的映射规则(servlet-mappin)

spring的配置文件

* 导入dao文件，加载最核心的对象SqlSessionFactory对象
  * 加载jdbc.properties的配置文件
  * 配置数据库连接池对象
  * mapper.xml文件的加载
  * 配置包的别名---->实体类中可以通过类名，不用通过全类名
  * mybatis配置文件的引入
    * 配置相关的设置信息，例如日志的设置
  * 配置插件，例如分页插件的配置
  * 配置dao接口的代理对象(哪些文件需要创建代理对象)
  * 配置事务管理器对象(该对象依赖于datasources对象)
  * 配置事务的注解驱动
* 配置wac需要扫描的包(父容器需要识别的注解)，不包含Controller注解
* 导入跨域对象的配置
  * 跨域对象过滤器的配置
  * 设置允许的请求头
  * 设置允许的请求路径

springMVC的配置

* 配置wac需要扫描的包和指定的注解(子容器需要识别的注解Controller)
* 配置springMVC注解的识别驱动
* 加载默认的静态资源（默认加载tomcat的配置文件中的default）
* 配置文件上传/下载和指定文件的默认编码格式“UTF-8”
* 配置jsp显示ViewResolver（视图解析器）

