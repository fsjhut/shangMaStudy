## day11 log4j日志组件

### 复习SSM框架

#### springMVC:

```java
1.前端控制器DispathcerServlet:init(tomcat启动时加载，初始化容器) service(处理用户的请求)
2.使用springMVC的技术点
  2.1 如何做url映射:RequestMapping GetMapping,PostMapping,PutMapping,DeleteMapping
  2.2 如果接受前端k=v的参数 request.getParameter()(任何一种请求都可以发k=v的数据),接口方法添加对应的形参(简单类型String,Date,实体对象)
  2.3 如何接受前端post，put，delete 请求的json参数。request.getInputStream()接受到输入流自字符串;接口方法添加复杂对象形参（实体对象，Map）形参使用RequestBody注解。
  2.4 如何接受url变量，http://localhost:8080/user/fyt/12:进行url映射时，通过(变量名)，接口方法添加简单类型的形参，通过PathValiabler注解指定路径变量名@PathValiable("变量名")

	2.5 同步开发中服务器如何返回前端视图：接口方法返回ModelAndView对象
  2.6 异步开发中服务器如何返回前端json字符串，处理器类使用ResController注解，接口方法返回值类型ReponseEntity对象。
  以上必须会-------------------------
  2.7 静态资源处理<mvc:default-servlet-handler>
  2.8 全局统一异常处理：@RestControllerAdvice+＠ExceptionHandler
  2.9 文件上传下载 CommonsMultipartResolver + MulipartFile
  3.0 拦截器 HandlerInterceptor-->preHandle---<mvc:interceptors>
  3.1 CorsFilter CorsFilter+DelegatingFIlterProxy
```

### SSM(学会自己整理思路)

```java
1. 在web.xml中配置ContextLoaderListener监听器，指定监听器加载的spring.xml文件(排除Controller注解的扫描).
2. 在web.xml中配置DispatcherServlet前端控制器，指定加载的springMVC.xml(限定只扫描Controller)
3. 完善springmvc.xml的使用，在springMVC.xml中开启mvc注解的识别<mvc:annotation-driven>
4. 创建dao.xml，同时把dao.xml文件通过import标签引入spring.xml，注册DruidDataSource对象，完善Mybatis的使用，注册SqlsessionFactoryBean对象，注册MapperScannerConfigure(dao的代理对象，给dao接口创建代理对象)
5. 注册DataSourceTransactionManager对象(dataSource),开启事务注解的识别<tx:annotation-driver> +　@Transactional
```

#### 需要知道的工具类

SpringUtils

```java
为了拿到容器的引用，便于在static方法或者子线程中获取容器中的bean对象。(如何在未注册到容器的类中引用容器中的bean)
ApplicationContextAware---->setApplicationContext
```

ServletUtils

简化代码开发，获取servlet对象的代码

ServletRequestAttributes(requst,response)+RequestContextHolder.getRequestAttribute()

### 1. 日志的作用

用来记录程序运行变量，收集程序，运行数据的一种组件

开发环境中：取代sout来输出变量，调试程序的代码

生产环境中：用来记录用户的访问行为,为数据分析做收集工作(枯燥)。用来记录程序运行过程中的异常行为，为应用程序的开发人员处理bug提供依据。

### 2.日志的分类

debug日志：开发中记录的变量

info日志：运行中的用户的访问行为日志

warn日志：警告日志，非正常的访问行为，没有报异常 

error日志：运行中的异常信息

### 3.常用的日志组件

可以认为是日志门面的具体实现组件

apache:log4j：一般公司内的老项目用这个 

log4j2：新项目使用

logback：

* 添加日志的jar包
* 添加日志的配置

```properties
#全局日志级别配置
							全局日志级别，日志输出位置1 日志输出位置2
log4j.rootLogger=info.console,logfile,errorfile,errorfile

log4j:appender.CONSOLE=org.apache.log4j.ConsoleAppender

layout:PatternLayout:自定义日志格式
```



### 4. log4j的使用

* 添加日志的jar包
* 添加日志的配置

```xml
############ERROR	WARM	INFO	DEBUG#####################
log4j.rootLogger=INFO,CONSOLE,logfile,errfile

############ CONSOLE OutPut ##############
#ConsoleAppender	FileAppender	DailyRollingFileAppender	RollingFileAppender	WriterAppender
log4j.appender.CONSOLE=org.apache.log4j.ConsoleAppender
#HTMLLayout		PatternLayout	SimpleLayout	TTCCLayout
log4j.appender.CONSOLE.layout=org.apache.log4j.PatternLayout
log4j.appender.CONSOLE.layout.ConversionPattern=%d %p [%c.%M] - %m%n

############ Default Log Output ###########
log4j.appender.logfile=org.apache.log4j.RollingFileAppender
log4j.appender.logfile.Append=true
log4j.appender.logfile.Threshold=INFO
log4j.appender.logfile.File=D:/logs/info.log
log4j.appender.logfile.MaxFileSize=51200KB
log4j.appender.logfile.MaxBackupIndex=5
log4j.appender.logfile.layout=org.apache.log4j.PatternLayout
log4j.appender.logfile.layout.ConversionPattern=%d{yyyy-MM-dd HH:mm:ss} [%c]-[%p] %m%n

############### Custom Err Output #################
log4j.appender.errfile=org.apache.log4j.RollingFileAppender
log4j.appender.errfile.Append=true
log4j.appender.errfile.Threshold=ERROR
log4j.appender.errfile.File=D:/logs/error.log
log4j.appender.errfile.MaxFileSize=51200KB
log4j.appender.errfile.MaxBackupIndex=5
log4j.appender.errfile.layout=org.apache.log4j.PatternLayout
log4j.appender.errfile.layout.ConversionPattern=%d{yyyy-MM-dd HH:mm:ss} [%c]-[%p] %m%n

 ############### Log4j SQL Output #################
log4j.logger.org.springframework=ERROR
```

#全局日志级别配置
log4j.rootLogger=日志级别,日志输出位置1,输出2,输出3
log4j.appender.输出位置=输出方式,输出文件,输出格式
log4j.logger.包名=日志级别

使用日志:

```
private Logger l  = LogManager.getLogger(this.getClass());
l.debug(a);
l.info("admin访问了method1");
l.error("除0");
```

### 5. log4j2的使用

- 添加log4j2的3个核心包
- 添加log4j2.xml

```
<appenders>:定义日志输出方式,输出文件,输出格式
<logger>:定义日志级别,并引用日志输出位置.
```

- log4j2在logback的市场压力下,相比于log4j,支持异步日志.log4j2的异步日志是基于disruptor异步组件.

### 4. 日志门面

一般中间件或者框架中都依赖于日志门面（日志接口）

依赖于抽象，不依赖于具体

commons-logging

slf4j：

一般中间件或框架中都依赖于日志门面(日志接口).

commons-logging

slf4j

- 添加slf4j.jar;log4j2-slf4j-impl.jar桥接包.
- 在类中定义日志对象

```
private org.slf4j.Logger l = LoggerFactory.getLogger(this.getClass());
```



