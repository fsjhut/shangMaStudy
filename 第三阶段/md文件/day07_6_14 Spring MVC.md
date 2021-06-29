## day07_6_14 Spring MVC

### 1. springMvc作用

springMvc是spring框架中的一个模块，简化servlet的开发，对servlet开发中繁琐的代码通过反射进行处理。

springmvc是控制层框架，职责是接受数据(kv,json,文件)，返回数据(视图，字节，文件)。

servlet开发：getParameter，一个servlet只能处理一个业务，功能单一，接受json数据繁琐。

get请求:

* 位置：参数在url后追加，http://域名?key=value&key=value
* 格式：?key=value&key=value
* 未加密

post请求：

* 位置：参数在http协议的请求体中
* 格式：key=value&key=value 或者{key:value,key=value}
* 可以加密 https协议对数据进行加密（收费）

### 2. 入门springMvc使用

入门案例

* 建立web项目

* 添加依赖包，spring的依赖包和springmvc的依赖包

  ![image-20210614200359414](https://raw.githubusercontent.com/fsjhut/image-hosting/master/md_img/image-20210614200359414.png)

  ```xml
  spring-core;spring-beans;spring-context;spring-expression;
  commons-loging;
  spring-aop;spring-aspect
  aspectj;
  cglib;
  spring-web;
  spring-webmvc
  ```

* 创建springmvc.xml仍然是spring风格的xml文件

  * 开启包扫描<context:component-scan base-package="">
  * 配置springmvc的核心注解识别，@RequestMapping，<bean class="">

  ```xml
  创建springmvc.xml,仍然是spring风格的xml文件.
  <!--识别@Controller,@Service,@Repository,@Component,Autowired,Resource-->
  <!--@Bean,@Value.@PostConstract,@PreDestroy,@Scope-->
  <context:component-scan base-package="com.javasm"></context:component-scan>
  
  <!--配置springmvc最核心注解的识别:@RequestMapping-->
  <!--处理器映射器-->
  <bean class="org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping"></bean>
  <!--处理器适配器-->
  <bean class="org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter"></bean>
  <!--视图解析器-->
  <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
    <property name="prefix" value="/page/"></property>
    <property name="suffix" value=".jsp"></property>
  </bean>
  ```

  ```xml
  在web.xml配置springmvc最核心的对象DispatherSerlvet
  <!--httpServlet中的方法:init,service,doget,dopost,destory-->
  <servlet>
    <servlet-name>dispatcherServlet</servlet-name>
    <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
    <!--初始化,init方法中解析-->
    <init-param>
      <param-name>contextConfigLocation</param-name>
      <param-value>classpath:springmvc.xml</param-value>
    </init-param>
    <!--更改servlet的实例化时间-->
    <load-on-startup>1</load-on-startup>
  </servlet>
  
  <!--所有请求都会进dispatcherServlet,jsp不进-->
  <servlet-mapping>
    <servlet-name>dispatcherServlet</servlet-name>
    <url-pattern>/</url-pattern>
  </servlet-mapping>
  ```

  ```xml
  必须配置<context:component-scan base-package="com.javasm"></context:component-scan>，用来识别基础的spring注解(Controller,Service,Repository,Component,Resource,Autowired等)。
  注意点2：一般HandlerMapping与HandlerAdapter不手工配置，使用<mvc:annotation-driven></mvc:annotation-driven>标签替代，作用一致。如下：
  ```

* 写控制层对象，并注册springmvc容器(使用@Controller)

```java
//springmvc对容器中使用Controller|RequestController的bean对象,会继续解析RequestMapping注解.
@Controller
public class HelloHandler {
  //形参使用包装类对象
  @RequestMapping("hellomvc")
  public String hello(String uname,Double udouble,Integer uint){
    System.out.println("hello springmvc!"+uname+"-"+udouble+"-"+uint);
    return "main";//视图名
  }
}
```

### 3.springmvc执行流程

![image-20210614114046049](https://raw.githubusercontent.com/fsjhut/image-hosting/master/md_img/image-20210614114046049.png)

* tomcat启动，DispachterServlet的init方法，webApplicationContext容器初始化，url映射
* 用户请求:http://localhost:8080/hellomvc：进入DispachterServlet的service方法，进行url的解析，得到请求uri:/hellomvc的字符串，通过处理器映射，找到对应的HandlerMethod处理器方法,返回DispathcerServlet
* 处理请求：DispatcherServlet调用处理器适配对象，执行处理器方法；
  * (HttpMessageConveter)获取前端的请求参数，进行转型，进行封装。
  * 执行处理器方法，传入封装的参数。
  * 得到处理器方法的返回值，把返回值再交给DispatcherServlet
* 结果处理：DispatcherServlet得到返回值ModelAndView对象后，调用jsp视图解析器对象，拼接完整的视图路径，进行视图的转发
* 视图渲染，jsp引擎负责生成静态的html字符串，通过输出流输出到前端。
* HttpMessageConveter:消息转换器，负责接受参数，格式参数，负责把返回值结果转json。

### 4. springmvc几个核心对象

* DispatcherServlet:springmvc的前端控制器对象，该对象中的init方法中初始化webApplicationContext对象
* RequestMappingHandlerMapping:springmvc的处理器映射器对象，在初始化容器时，解析Controller注解的bean对象中RequestMapping注解，进行url映射,将url字符串映射到一个处理器方法上。
  httpmvc--->HandlerMethod(SysuserHandler.hello(String uname,Double udouble,Integer uint);)
  使用servlet时：一个url字符串映射到一个方法中
* RequestMappingHandlerAdapter:springmvc的处理器适配器对象，负责执行处理器方法的
  * 获取前端的请求参数，进行转型，进行封装。
  * 执行处理器方法，传入封装的参数。
  * 得到处理器方法的返回值，把返回值再交给DispatcherServlet
* InternalResourceViewResolver:jsp视图解析器,配置视图统一的前缀路径与统一的后缀格式.
* HttpMessageConveter:消息转换器，负责接受参数，格式参数，负责把返回值结果转json。

### 5. kv数据接收(前端ajax常用,前端axios用不上)

直接加形参.

```
//如果接收k=v&k=v数据,Date类型采用DateTimeFormat指定格式
//如果接收k=v&k=v数据,如果形参时简单类型,则形参名与表单参数名一致;
//如果接收k=v&k=v数据,如果形参是复杂对象,则对象成员变量名与表单参数名一致;
//如果接收k=v&k=v数据,可以在形参加@RequestParam注解,指定参数默认值.
```

### 6. json数据接受

ajax异步请求：content-type:application/x-www-form-urlencoded  key=value

axios异步请求：content-type:application/json--------->{key:value,key:value}

原生servlet接受json数据，解析比较复杂，因此在前端都选择将其转为key=value



json工具类的相关方法：

Sysuser u = JSON.parseObject(s,Sysuser.class)

List<Sysuer> us = JSON.parseArray(s,Sysuser.class)

Map map = JSON.parseObject(s,Map.class)

springmvc内部依赖jackson组件进行json字符串转换

* 添加jackson的3个依赖包：jackson-core jackson-annotation jackson-databind
* 在方法的形参加@RequesetBody注解，表示接受json字符串，并转为相应类型的对象(实体，Map，List)
* 如果json字符串有日期字符串，后端使用Date或者LocalDate对象时，可以通过@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8") // 把字符串中的日期，转成对象，把对象中的Date转为json字符串时，日期格式

### 7 返回视图

处理器方法返回值使用ModelAndView对象,指定视图名.同时配置视图解析器对象.

### 8 返回json

方法1：处理器方法上或者处理器上加@ResponseBody

表示方法的返回值通过MappingJackson2HttpMessageConverter消息转换器对象， 把返回值转为json字符串，返回给前端，不再执行视图解析器对象，转发页面

方法2：处理器方法：返回值ReponseEntity(常用)

相比ResponseBody注解，该方法更加强大，可以灵活的制定响应头，响应体，状态行数据，一般应用文件下载，token传输

方法3：处理器类使用@RestController取代@Controller注解（常用）

该注解等价于@Controller+@ResponseBody注解

**注意：jackson组件可以通过@JsonInclude(JsonInclude.Include.NON_NULL) 注解指定非null序列化.**

### 9 限定请求方法（重要）

为了接口的安全，第一步限定接口的提交方式，get或者post或者put或者delete

方法一：@RequestMapping(path="add",method=RequestMethod.POST)

方法二：使用@GetMapping PostMapping,PutMapping DeleteMapping 进行url映射，限定请求方法

### 10. 处理器转发与重定向（不重要）

只有在同步开发中用到

方法返回值的视图名使用forward: 或者redirect: 开头，表示转发或者重定向到新的处理器方法

### 11. 数据乱码（不重要）

get请求:无乱码.

​	参数在url后面追加,tomcat7以上的版本url都支持中文.

post请求:

​	如果参数追加url后,无乱码;

​	如果参数放在请求体中,k=v格式数据中文有乱码;

​	json格式数据中文无乱码;

k=v格式数据中文有乱码，是因为tomcat内部对请求体和响应体中的数据,编码格式采用的ISO-8859-1西文编码.不支持中文.

json无乱码是因为MappingJackson2HttpMessageConverter消息转换器中吧json字符串转对象时,采用的是utf-8编码,支持中文.

总结:只有当请求体中的数据格式时k=v的时候才会有中文乱码.解决方式是配置编码过滤器

```xml
<filter>
  <filter-name>characterEncodingFilter</filter-name>
  <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
  <init-param>
    <param-name>encoding</param-name>
    <param-value>UTF-8</param-value>
  </init-param>
</filter>
<filter-mapping>
  <filter-name>characterEncodingFilter</filter-name>
  <url-pattern>/*</url-pattern>
</filter-mapping>
```

### 12获取servlet对象引用

HttpServletRequest:请求对象,瞬时状态.在处理器方法加入形参

HttpServletReponse:响应对象,瞬时状态.在处理器方法加入形参

HttpSession:用户会话对象,被所有request共享,在处理器方法加入形参

ServletContext:全局唯一的上下文对象,被所有request,session都共享.必须通过request或session对象来获取.

### 13 注解总结

* @RequestMapping 注解： 用在类上，进行url第一层映射
* @GetMapping @PostMapping 用来处理器方法上，进行url第二层映射
* @RequestParam注解，用在处理器方法的形参上,给k=v格式的简单类型数据默认值.只能用在简单类型上.
* @RequestBody注解,用在处理器方法的形参上,用来获取json格式的数据,只能用在复杂对象上(实体,map,list)
* @ReponseBody注解,用在类或方法上,表示处理器方法的返回值走json转换器转字符串返回前端;


ReponseEntity对象,用在处理器方法返回值类型,表示处理器方法的返回值走json转换器转字符串返回前端,该对象可以指定响应头,响应体

* @RestController注解,用在类上,表示本类中处理器方法的返回值走json转换器转字符串返回前端;
* @DateTimeFormat注解,用在Date或LocalDate类型的变量上,指定前端传递日期字符串格式.前提是参数格式k=v
* @JsonFormat注解,用在Date或LocalDate类型的变量上,指定前端传递日期字符串格式.前提是参数格式{k:v}
* @JsonInclude注解,用在类上,指定非null字段才进行序列化json字符串.

BeanUtils工具包,用来把Map中的数据分装到实体对象中.

springmvc的核心对象与执行流程:
