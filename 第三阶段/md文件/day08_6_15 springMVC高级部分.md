# day08_6_15 springMVC高级部分

### 1 resturl(重要)

| 传统url           | 参数             | rest风格url | 请求方式 | 参数            |
| ----------------- | ---------------- | ----------- | -------- | --------------- |
| /user/queryById   | ?uid=1           | /user/1?k=v | get      | 属于url的一部分 |
| /user/adderUser   | 请求体json或者kv | /user       | post     | 请求体或者kv    |
| /user/updateUser  | 请求体json或者kv | /user       | put      | 请求体json或kv  |
| /user/delUserById | ?id=1            | /user/1     | delete   | 属于url的一部分 |

springmvc是支持rest风格的url

* ```java
  @GetMapping("{uid}") //user/1
  public AxiosResult qeueryById(@PathVariable("uid") Integer id){
    
  }
  ```

* 

* rest风格的url，路径变量不适合太多，一般控制在3个以下

* 查询数据：get请求，可以接受路径变量，可以接受?k=v变量

* 添加数据：post请求，可以接受路径变量可以接收url上的kv变量,可以接收请求体的json数据,可以接收请求体的kv数据

* 修改数据：put请求,接收路径变量,接收?k=v,接收请求体json,不能接收请求体的k=v的数据

* 删除数据：delete请求,接收路径变量,接收?k=v,接收请求体json,不能接收请求体中的k=v数据

是一个特殊的url写法，简洁的url路径，url路径参数

tomcat只对post请求体的内容key-value 进行自动解析

不支持put请求的请求体中的key-value数据进行解析，需要自己手动解析。

如果前端提交数据的格式是json，后端对于路径变量，对于k=v，可以随便接受到，

如果前端提交数据是k=v,且数据在请求体中，提交方式是put+delte时，后端接受不到数据，后端需要配置**过滤器**

**如何在后端进行过滤器的配置**

判断请求如果是put、delete的话，对请求体中的数据做转换处理成Map，把参数保存到request对象中

```xml
<filter>
	<filter-name>formContentFilter</filter-name>
  <filter-class>org.springframework.web.filter.FormContentFilter</filter-class>
</filter>
<filter-mappin>
	<filter-name>formContentFilter</filter-name>
  <url-pattern>/*</url-pattern>
</filter-mappin>
```

总结：

如果前端提交的数据是json格式，后端对于路径变量，对于?k=v，对于json都是随便接受的。

如果前端提交的数据是k=v+数据在请求体+提交方式是put或者delete，后端需要配置过滤器

### 2. 静态资源处理

对于前后端分离开发的项目，此项不常用

对于前后端未分离的项目，需要进行配置文件，一般常用方法2

在springmvc环境下，静态资源无法直接访问，因为tomcat下的DefaultServlet被DispatcherServlet进行了路径的覆盖，所以无法找到因此需要重新配置

方法1：配置defaultServlet的静态配置 

<servlet-Mapping>

​	<servlet-name>default</servlet-name>

​	<url-pattern>*.html</url-pattern>

​	<url-pattern>*.jpg</ur-pattern>

​	<url-pattern>*.css</ur-pattern>

</servlet-Mapping>

**方法2：**

```xml
<mvc:default-servlet-handler default-servlet-name="default">
springmvc对于静态资源通过名字 叫default 的servlet来进行处理 
```

**方法3：**官方推荐使用的，对静态资源做映射，配置较为复杂。

```xml
mapping是映射路径，location是文件路径
<mvc:resources mapping="/s/**" location="/static/">\</mvc:resources>
<mvc:resources mapping="/static/**" location="/static/"></mvc:resources>
<mvc:resources mapping="/page/**" location="/page/"></mvc:resources>
```

###  3. 异常处理（重要）

dao层和service层的异常抛给控制层,控制层框架进行异常处理。

**springmvc的局部异常处理**，使用注解@ExceptionHandler(Exception.class)，注解对一个类中的所有方法进行异常处理。

**缺陷**：适用面太窄，只适用于当前的异常处理，不适用于其他类。

**优点**:能够对不同的异常分别做处理.

```java
@ExceptionHandler(Exception.class)
public AxiosResult doExceptoion(Exception e){
  System.out.println(e.getMessage())
   //异常需要记录文件，保存在服务器的文件中，开发人员定时的维护异常的记录文件，进行异常的处理
  return AxiosResult.error();
}
// 不同的异常用不同的方法进行处理，类似于catch的处理方式
// 该方法对ArithmeticException异常进行处理
@ExceptionHandler(ArithmeticException.class)
public AxiosResult doExceptoion(Exception e){
  System.out.println(e.getMessage());
  return AxiosResult.error();
}
```

**springmvc的全局异常处理**

解析异常的方法中，可以用在同步开发和异步开发中

优点：所有处理器类全部都生效

缺陷：所有类型的异常都进入该方法，无法对不同的异常做不同的处理方案。

```java
@Component // 需要注册进容器中
public class GlobalExceptionHandler implements HandlerExceptionResolver {
    //解析异常的方法,同步开发中使用,异常开发也可以使用.
    @Override
    public ModelAndView resolveException(HttpServletRequest req, HttpServletResponse resp, Object o, Exception e) {
        System.out.println(e.getMessage());
        resp.setCharacterEncoding("UTF-8");
        PrintWriter writer = null;
        try {
            writer = resp.getWriter();
            AxiosResult error = AxiosResult.error();
            writer.print(JSON.toJSONString(error));
            writer.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return null;
    }
}
```

**使用controllerAdvice注解实现的全局统一异常处理(重要，常用的)**

@RestControllerAdvice----------->@Component + @ControllerAdvice +@ResponseBody::回复的数据转为json

```java
@RestControllerAdvice
public class MvcExceptionHandler {
    //defalut异常处理
     @ExceptionHandler(Exception.class)
    public AxiosResult doDefaultException(Exception e){
         //TODO 记录异常
        e.printStackTrace();//向控制台打印堆栈错误信息
        return AxiosResult.error();
    }

    //该方法对ArithmeticException处理
    @ExceptionHandler(ArithmeticException.class)
    public AxiosResult doArithmeticException(Exception e){
       e.printStackTrace();
        //TODO 异常需要记录文件,保存在服务器文件上,开发人员定时的拿到异常文件
        return AxiosResult.error(S.DIV_ZERO);
    }

    @ExceptionHandler(MvcException.class)
    public AxiosResult doMvcException(MvcException e){
         e.printStackTrace();
         //TODO 记录异常
         return AxiosResult.error(e.getS());
    }
}
```

### 4. 文件上传下载

springmvc中的文件下载，基于commons-fileupload组件

* 添加commons-fileupload.jar commons-io.jar

* 配置文件解析器对象，该对象对请求头Content-type:multipart/form-data 的请求进行文件解析。

  ```xml
  // id必须是multipartResolver，不能写其他的，要不然识别不了
  <bean id="multipartResolver" class="CommonsMultipartResolver">
    // 对中文名字的支持
  <property name="defaultEncoding" value="UTF-8"></property>
    // 限定文件的大小
  <property name="maxUploadSize" value="5000000"></property>
   // 内存存储文件的最大大小，比较快
  <property name="maxInMemorySize" value="1000000"></property>
    // 建立一个临时文件在磁盘中，比较慢，当已经完成了上传，临时文件清空
  <property name="uploadTempDir" value="/upload/tmp"></property>
  </bean>
  ```

  ```java
  @RestController
  public class FileHandler{
    @PostMapping("uploda")
    //MultipartFile即CommonsMultipartFileResolver文件解析器对象解析文件数据，得到MultipartFile对象
    public AxiosResult doUploadFile(MultipartFile jl){
      //文件内容，字节数据，适合小文件
    	byte[] bytes = jl.getBytes();
      // 文件内容，输入流，适合大文件的存储 没啥用
      InputStream in = jl.getInputStream();
      String fileName = jl.getOriginalFilename();
      long size = jl.getSize(); // 文件大小
      
        // 存文件
      String realPath = req.getServletContext().getRealPaht("/");
      String path = "/upload/"+fileName;
      // 原生的输出流写数据的过程
      IOUtils.write(bytes,new FileOutputStream(new File(realPath,path)));
      // 将数据封装为map，传给前端，封装的数据尽量完整
      Map<String,Object> result = new HashMap<>();
      result.put("path",path);
      result.put("realName",originalFilename);
      result.put("uploadTime",System.currentTimeMillis());
      result.put("size",size);
      return AxiosResult.suc(result);
    }
    
    @GetMapping("down")
    public ResponseEntity doDownload(String path，req){
      // 下载文件(同步下载)
      // 1.利用a标签的href=""
      // 2. 使用button按钮中的onclick=""
  		String realPath = req.getServletContext().getRealPath("/");
      File f = new File(realPath,path);
      String fileName = f.getName();
      byte[] bytes = FileUtils.readFileToByteArray(f);
      HttpHeaders headers = new HttpHeaders();
      // 设置一个响应头
      headers.add("Content-Disposition","attachment;filename="+URLEncoder.encode(filename,"UTF-8"));
      new ResponseEntity(bytes,headers,HttpStatus.OK);
    }
  }
  ```

### 5. 拦截器interceptor

****

拦截器是框架中的一种概念，类似于Filter，低于Filter。如果有多个拦截器则按照配置的顺序进行往下执行多个拦截器

![image-20210615202000835](https://raw.githubusercontent.com/fsjhut/image-hosting/master/md_img/image-20210615202000835.png)

* 定义拦截器

![image-20210615202456642](https://raw.githubusercontent.com/fsjhut/image-hosting/master/md_img/image-20210615202456642.png)

```java
public class LoginInterceptor implements HandlerInterceptor {
    //前拦截
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        HandlerMethod m = (HandlerMethod)handler;
//        Object bean = m.getBean();//handler类的bean对象
//        Method method = m.getMethod();//处理器方法
        HttpSession session = request.getSession();
        Object loginuser = session.getAttribute("loginuser");
      // 表示未登录的状态，因此需要抛出自定义异常
        if(loginuser==null)
            throw new MvcException(S.NO_LOGIN);//返回给前端数据
        return true;
    }
}
```

* 配置拦截器

```xml
<mvc:interceptors>
  <mvc:interceptor>
    <mvc:mapping path="/**"/>
    // 忽略路径
    <mvc:exclude-mapping path="/user/login"></mvc:exclude-mapping>
    <mvc:exclude-mapping path="/upload/**"></mvc:exclude-mapping>
    <bean class="com.javasm.commons.interceptor.LoginInterceptor"></bean>
  </mvc:interceptor>
</mvc:interceptors>
```

### 6. springmvc的跨域处理

****

跨域：在前端分离的情况下，由于协议 ，端口不同，违反了游览器的同源保护策略，不允许请求

需要在服务器端响应的时候带上跨域的响应头，表示这是一个安全的请求。

方案1：在处理器类或者方法上加上@CorsOrigin(origins="http://localhost:8088",allowedHeaders="*",mehods="{RequestMethod.GET}",allowCredentials="true")注解，不建议使用，适用面较小，加在方法上代表该方法的地址允许跨域，加在class上代表该类所有的方法都可以跨域 allowCredentials:允许携带cookie

方案2：配置mvc:cors 不建议使用，与自定义拦截器结合使用时，容易出问题。

```xml
<!--该配置进行跨域,是基于一个springmvc内置的跨域拦截器对象进行响应头设置.而且该拦截器是最后一个执行
因此单一使用没有问题，如果和自定义的拦截器一起使用则会出现问题（自定义拦截器先生效，故无法返回真正的异常信息）-->
    <mvc:cors>
        <mvc:mapping path="/**"  //全部路径都可以设置跨域请求
                     allow-credentials="true"
                     allowed-origins="http://localhost:8088"
                     allowed-headers="*"
                     allowed-methods="*"/>
    </mvc:cors>
```

方法3：使用CorsFilter与DelegatingFilterProxy两者结合基于**过滤器**进行跨域，相当于配置了一个过滤器，该过滤器配置在resources文件夹中，因为配置文件太过复杂，因此不能配置在web.xml中，配置在单独的xml文件中，注册到spring容器中（通过构造器注入的方式配置初始化参数，内部bean注入）。然后在web.xml中配置生效

![image-20210615210503283](https://raw.githubusercontent.com/fsjhut/image-hosting/master/md_img/image-20210615210503283.png)

```xml
<!--跨域过滤器对象注册到spring容器-->
    <bean id="corsFilter" class="org.springframework.web.filter.CorsFilter">
        <constructor-arg name="configSource">
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
```

```xml
<!--相当与一个代理对象
执行请求过滤,拦截到请求后,去容器中获取id为corsFilter的对象,执行真正的跨域配置-->
<filter>
  <filter-name>myCorsFilter</filter-name>
  <filter-class>org.springframework.web.filter.DelegatingFilterProxy</filter-class>
  <init-param>
    <param-name>targetBeanName</param-name>
    <param-value>corsFilter</param-value>
  </init-param>
</filter>
<filter-mapping>
  <filter-name>myCorsFilter</filter-name>
  <url-pattern>/*</url-pattern>
</filter-mapping>
```

### 7 登录用户状态管理

采用服务端保存客户端的会话状态，安全可靠

缺点：应用服务器搭建集群时，在多个服务器之间需要解决sessiono共享，解决方案：spring-session



####  服务端签发token机制

   服务端不保存会话状态信息，当用户登陆，服务端生成token字符串，返回客户端保存localStorage或cookie。每次请求都携带token信息在请求头中，发送服务端，服务端校验是否合法请求。

​    依赖组件：auto0或jjwt，两者都可以用来生成token。

​    缺点：token过长，效率低；服务端无法控制token强制失效，安全性稍低；需要自己实现token刷新。

![image-20210615211219217](https://raw.githubusercontent.com/fsjhut/image-hosting/master/md_img/image-20210615211219217.png)

==总结重点掌握内容：==

rest风格url：getMapping,postMapping,PutMapping,DeleteMapping+@PathValiable

全局统一异常处理：@RestControllerAdvice +＠ExceptionHandler

文件上传下载：CommonsMultipartFileResolver+ MuiltipartFile

拦截器：HandlerInterceptor----->preHandle

跨域过滤器：CorsFilter

