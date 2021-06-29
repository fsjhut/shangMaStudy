## SSM整合的代码分析

tomcat的启动顺序

* 监听器
* 过滤器
* 拦截器
* Servlet

### tomcat知识回顾

![image-20210619165729288](https://raw.githubusercontent.com/fsjhut/image-hosting/master/md_img/image-20210619165729288.png)

El 表达式的主要作用为从域对象或参数中取值并输出到页面中。

JSTL的使用，el表达式取值，jstl可以完成逻辑控制

* set：设置指定范围内的变量值`<c:set var= "example/>"`
* out：计算表达式并将结果输出显示`<c:out value="${example}"/>`
* remove：删除指定范围内的变量`<c:remove var= "example" scope="session"/>`
* if：进行条件判断
* forEach：遍历集合中的元素`<c:forEach items="${listEitity }" var="myentity">`

**常用的会话跟踪技术：**

* URL方式：需要保存的信息直接追加在URL后
* 隐藏域的方式，可以使用表单中的隐藏域来保存相关信息
* Session：将状态信息保存到服务器的会话对象中
* Cookie方式，将状态信息保存到客户端中，服务器可以获取到客户端的相关信息并进行分析。

实现Servlet的三种方式，一个实现，两个继承

* 实现Servlet接口
* 继承GenericServlet抽象类，重写service()方法
* 继承HttpServlet抽象类，HttpServlet继承于GenericServlet,重写doGet() doPost()方法

load-on-startup：配置加载的顺序，如果为正(0)，代表在项目启动中就可以加载，正数的值越小则代表加载的优先级越高，如果为负数，则代表启动时不会被加载，在访问时才会被加载。

第一次访问该Servlet对象时，服务器将创建一个Servlet类的对象，并调用doXXX方法生成响应，多个客户端访问同一个Servlet时，不再创建新的对象，而是共用一个servlet对象，可以说，==Servlet是多线程单实例的==

==多线程访问单实例，会不会造成线程安全问题？==

每个线程之间，栈是独立的，运行方法时，会压入栈帧，所以运行方法时线程间不会互相影响。
因为单实例，所以如果servlet 中有成员变量，那么所有线程都会访问到同一个实例的成员变量，会造成线程安全问题。所以使用servlet 时，**尽量不要建立成员变量**。

**Servlet 四大域对象**

域对象中的统一的方法setAttribute(String key,Object value)和getAttribute(String key)

◼ Request

* 一个用户可有多个
* 每次请求都会产生一个
* 请求结束对象消失
* 建议用于页面间值的传递

◼ Session

* 一个用户一个
* 每一个浏览器都会产生一个
* 会话过期或者关闭浏览器对象消失
* 建议存放一些用户信息，不要把过多的信息存放在session 里

◼ ServletContext（application）

* 全局只有一个
* 是一个全局的储存信息的空间，服务器开始就存在，服务器关闭才释放。
* 为了节省空间，提高效率，只存放少量的重要信息

◼ PageContext

* page域

**请求转发和重定向的区别**

响应重定向通过response 对象调用，让浏览器向重定向的地址重新发送一次请求response.sendRedirect("error.jsp");

请求转发通过request 对象调用，把请求对象和响应对象与要跳转的地址共享request.getRequestDispatcher("showIP.jsp").forward(request, response);

![image-20210619173433018](https://raw.githubusercontent.com/fsjhut/image-hosting/master/md_img/image-20210619173433018.png)

监听器是javaweb组件中提供的一种机制，可以用来监控域对象的创建，销毁过程(在发生创建，销毁时可以执行自己的代码)以及域对象中属性的创建，替换，销毁。

监听web对象的创建与销毁的监听器

* ServletContextListener：服务器启动时生效，全局唯一
* HttpSessionListener：通过服务器访问游览器，且读取到session时，通过sessionId作为key，传递到后台后，可以在服务器的Map中找到对应的value值。
* ServletRequestListener： 

监听web对象属性的变化

* ServletContextAttributeListener
* HttpSessionAttributeListener
* ServletRequestAttributeListener
* ServletContext--------->ServletContextListener
  * 实现的方法contextinitialized()
  * contextDestroyed()

spring框架 中实现的是ServletContextListener接口监听器

![img](https://raw.githubusercontent.com/fsjhut/image-hosting/master/md_img/20190505202539263.jpg)

可以达到服务器启动时，可以自动执行该监听器**，加载spring框架**的配置文件。

监听器的应用

* 统计在线人数
* 加载初始化信息
* 统计网站的访问量
* 监控访问信息

各种类型的监听器的作用

* ServletContextListener 监听web应用的启动和关闭
* ServletContextAttributeListener 监听ServletContext范围内属性的改变
* ServletRequestListener 监听用户的请求
* ServletRequestAttributeListener监听ServletRequest范围内(request)请求内属性的变化
* HttpSessionListener监听用户的session的开始和结束 
* HttpSessionAttributeListener 监听HttpSession范围内Session内属性的变化 
* SpringMvc的监听器ContextLoaderListener(实现ServletContextListener)用于加载spring容器中的配置文件

### tomcat过滤器的使用

过滤器是 向web应用程序的请求和响应处理添加功能的web服务组件

```java
public class TestFilter implements Filter {
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
	filterChain.doFIlter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
```

实现servlet中的过滤器功能需要实现三个接口的方法

* init：过滤器的Init方法会在**服务器启动**的时候直接进行创建区别于servlet(默认是被访问的时候才进行创建)
* doFilter:当访问到filter-mapping中配置的地址时，doFilter方法被执行
* destory:服务器关闭时候，destory被执行

* servlet不可以配置两个相同的地址值
* filter的配置地址可以和servlet一样
  * 此时只有dofilter被执行，servlet未执行
  * 若servlet也想被执行则需要在dofilter中加上`filterChain.doFilter(servletRequest,servletResponse)`相当于请求转发，此时servlet才会被执行
* 两个过滤器可以配置为同一个访问地址，执行的顺序
  * 若是通过配置文件的方法进行配置，则根据配置文件的顺序(配置文件的加载顺序)
  * 若是通过注解的方式进行配置，则一般是按照名字进行过滤，一般编号靠前的优先执行。
* 可以使用通配符/*,让所有的请求都进入过滤器

过滤器的应用场景：

* 适合用于些公共层面的代码。
* 字符编码过滤器
* 权限控制------>细粒度，登录访问控制----->粗粒度
* 需要设置白名单和黑名单，一般先进行登录过滤器，再进行权限过滤器进行第二次校验

拦截器和过滤器的区别

* 拦截器是基于java的反射机制，而过滤器是基于函数的回调
* 拦截器不依赖于servlet容器，而过滤器依赖于servlet容器
* 拦截器只对action请求起作用，而过滤器则对几乎所有的请求都有效
* 拦截器可以访问action的上下文，值，堆栈里面的对象，而过滤器不可以
* 在action生命周期中，拦截器可以多次被调用，而过滤器只能在容器初始化时被调用一次
* 拦截器可以获取IOC容器中的各个bean，而过滤器不可以，在拦截器中可以调用业务逻辑

过滤器获取请求的知识 ：

![image-20210619112149419](https://raw.githubusercontent.com/fsjhut/image-hosting/master/md_img/image-20210619112149419.png)

filter在web.xml中的配置

```xml
<filter>
        <filter-name>delegatingFilterProxy</filter-name>
        <filter-class>org.springframework.web.filter.DelegatingFilterProxy</filter-class>
        <!--配置初始化参数-->
        <!--跨域对象-->
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



==Ajax的基础知识回顾==

 AJAX 指异步的JavaScript 及XML（Asynchronous JavaScript And XML）

模式：服务器接受到请求后将页面需要展示的数据传给游览器，游览器使用这些新的数据替换掉旧的页面数据。并非是全部替换，而是允许设置一段js 来读取返回的数据。
由这段可以自由编辑的js 内容决定返回的数据如何处理

请求方式：使用XMLHttpRequest对象发送请求

总结：ajax 是一种新的与后台交互模式，一定程度上需要后台部分的配合

JS执行过程中有四个线程：

* JS 执行引擎线程： 也称为JS 内核，负责解析执行Javascript 脚本程序的主线程
* 事件触发线程：归属于浏览器内核进程，不受JS 引擎线程控制。
* 定时器触发线程：主要控制计时器setInterval 和延时器setTimeout
* HTTP 异步请求线程：通过XMLHttpRequest 连接后，通过浏览器新开的一个线程，监控readyState 状态变更时，如果设置了该状态的回调函数，则将该状态的处理函数推进事件队列中，等待JS 引擎线程执行。

ajax 由js 编写，使用XMLHttpRequest 对象对数据收发进行封装，
发送ajax 请求时，ajax 会要求调用方（浏览器）开启新线程向服务器进行请求，并对响应的
结果进行反复读取，当读取到特定状态后，停止反复读取。读取过程中会把需要运行的js（回
调函数）添加入js 的执行队列（js 执行引擎为单线程），js 执行引擎按队列顺序执行。

原生ajax代码的步骤

⚫ 创建XMLHttpRequest 对象
⚫ 设置回调函数
⚫ 初始化XMLHttpRequest 组件（设置）
⚫ 发送请求

//jquery中ajax 调用过程

```javascript
$.ajax({
  url:"ajaxServlet",//地址
  type:"post",//请求类型
  data:{"uname":$("#username").val()}, //请求的参数 常用json 格式
  dataType:"text",//返回数据的类型
  success:function(data){//响应成功时的回调函数 data 表示返回的数据
  console.log(data);
  }
});
```

例子：使用ajax发送ajax请求

```javascript
$.ajax({
  url:"ajaxQueryUser",//地址
  type:"post",//请求类型
  data:mydata, //请求的参数 键值对字符串 json 格式
  dataType:"json",//返回数据的类型
  success:function(data){//响应成功时的回调函数
    //console.log(data.returnData);
    $("#mainData").html("");//清空之前的数据
    //遍历返回的数据，填入到页面
    $.each(data.returnData,function(i,d){
      var newdata = "<tr><td>"+d.uid+"</td><td>"+d.uname+"</td>"
      +"<td>"+d.age+"</td><td>"+d.uNickname+"</td>"
      +"<td>"+d.uaddr+"</td></tr>"
      $("#mainData").append(newdata);
    })
    //更新页数相关变量，更新页面显示页码
    page = data.pageInfo.page;
    pagesize = data.pageInfo.pageSize;
    totalpage = data.pageInfo.totalPage;
    //$("#myMsg").html(data);
    $("#showPage").html(page);
    $("#showSize").html(pagesize);
    $("#showTotal").html(totalpage);
    //重置按钮禁用状态
    initBtn();
  }
});
```

#### VUE基础知识回顾

vue的简单使用步骤

* 引入vue的js文件

* 在页面中创建根标签，让vue监控、

* 创建vue对象

  ```javascript
  var myvue = new Vue({
    el:"#maindiv",
    data:{
      myTitle:"xxx系统",
      userName:"小明"
    },
    method:{
      metest:function(){
        this.textval = ""
      },
      metest3(){
        this.textval = ""
      },
    }
    
  })
  myvue.$data.username = “小黑”
  // 通过.的方法获取对象，通过=符号，可以直接修改数据
  使用最多的是，myvue.$data.username ------>可以通过一个简化的语法糖，myvue.userName="小红"
  
  ```

* 通过参数设置 el: 指定监控的根标签

* 通过参数设置 data，创建数据模板

* 给数据模板中的数据，与页面创建关联

VUE的基础语法：

* vue的插值表达式中将所有的数据解析为文本，因此在变量中如果包含html元素，则还是按文本输出
*  v-html标签：如果内容有标签，则可以解析为html格式
* v-bind指令：v-bind建立两个属性之间的关联关系，一个放在div标签中，另一个放在data数据中key:value，在绑定时可以使用简化操作：，如果绑定的是class属性，则可以多个属性单独绑定
* v-if指令：控制元素的指令是否可见，vue是通过dom结构来控制是否存在，而不是通过控制display属性
* v-on:事件的触发v-on:click="mytest"，可以使用简化的写法@事件=“函数”
* v-model: 数据模板和用户输入的值可以进行双向绑定，任何一方数据的改变，都会导致另一方的变化，单选用数字 ，多选用[]
* v-for指令：遍历集合，在遍历过程中生成元素 v-for="遍历到的元素 in 遍历集合",
  * 准备好需要遍历的数据
  * v-for绑定页面需要循环生成的元素
  * 纯文本 {{}} 使用插值表达式， 元素属性：属性，使用属性绑定
  * 被循环的标签的子标签跟着一起循环生成 
* axios发送ajax请求
  * 发送post请求时可以使用json格式的数据。
  * 回调函数中，this的指向发生了改变，可以自己更改引用，或者可以改造为箭头函数。

VUE脚手架的使用

* 在vue脚手架中，都是单页面(index.html)应用
* vue的组件
  * import 导入组件
  * export 导出组件
* main.js  核心配置/入口文件  创建vue对象
* App.vue 根组件，创建好的vue对象，默认加载app组件，在根组件中加入<router-view></router-view>:让显示的其他组件也替换到app组件中。
* router：路由，替换需要显示的组件， /请求地址  ----组件
* index.js:路由的配置，配置请求地址与组件的关系。
* 

js中，可以在域外使用域内的变量（var）

* 因此，现在大多使用let来定义变量 （全局，函数内，块内）
* 如何在js中定义一个常量？使用const 来定义一个常量
* 可以使用新的方式来拼接字符串：(`我的变量：${temp}!!!`),该方式不要与el表达式一起写，要不然会混淆。

springMVC是通过servlet方式，拦截到所有的请求，创建一个WebApplicationContext对象和前端控制器对象DispatcherServlet，进行请求的控制

![image-20210618211756158](https://raw.githubusercontent.com/fsjhut/image-hosting/master/md_img/image-20210618211756158.png)



![image-20210618200803631](https://raw.githubusercontent.com/fsjhut/image-hosting/master/md_img/image-20210618200803631.png)



![image-20210618200947825](https://raw.githubusercontent.com/fsjhut/image-hosting/master/md_img/image-20210618200947825.png)



![image-20210618201148232](https://raw.githubusercontent.com/fsjhut/image-hosting/master/md_img/image-20210618201148232.png)

**框架执行流程（面试必问）** 
1、用户发送请求至前端控制器DispatcherServlet，有了DispactherServlet就减少其他组件的的耦合性
2、DispatcherServlet收到请求调用HandlerMapping处理器映射器，查找Handler可以根据XML配置，注解进行查找
3、处理器映射器根据请求url找到具体的处理器，生成处理器对象及处理器拦截器(如果有则生成)一并返回给DispatcherServlet。
4、DispatcherServlet通过HandlerAdapter处理器适配器调用处理器Handler
5、执行处理器(Controller，也叫后端控制器)。
6、Controller执行完成返回ModelAndView
7、HandlerAdapter将controller执行结果ModelAndView返回给DispatcherServlet， ModelAndView是springmvc的一个底层对象，包括 mode 和 view
8、DispatcherServlet将ModelAndView传给ViewReslover视图解析器，根据逻辑视图解析成真正的视图(jsp)
9、ViewReslover解析后返回具体View
10、DispatcherServlet对View进行渲染视图（即将模型数据填充至视图中），视图渲染将模型数据(ModelAndView)填充到request域
11、DispatcherServlet响应用户

![image-20210618201415062](https://raw.githubusercontent.com/fsjhut/image-hosting/master/md_img/image-20210618201415062.png)



前端控制器DispacherServlet 作用：接收请求，响应结果，相当于一个转发器，中央处理器

处理器映射器HandlerMapping作用：根据请求的URL来查找Handler(通过配置、注解方式)

处理器Handler 需要程序员来开发(注意：编写Handler时要按HandlerAdapter要求来写，这样Handler才能正确的去执行)

处理器适配器HandlerAdapter 作用：执行handler，怎么执行？按照特定的规格，就是HandlerAdapter要求的规则

视图解析器ViewResoler 作用：进行视图解析，根据逻辑视图解析成真正的视图(view)

视图View 是一个接口，实现类来支持不同的View类型(Jsp、Freemarker、Excel、Pdf .......) 需要程序员来开发JSP.


注解开发（@Controller,@RequestMapping,@ResponseBody。。。。） 
还有Spring的诸多注解，这两者是不需要整合的~
传参，接参（request）
基本配置
文件上传与下载 
Spring MVC中文件上传需要添加Apache Commons FileUpload相关的jar包,
基于该jar, Spring中提供了MultipartResolver实现类: CommonsMultipartResolver.
拦截器
其实最核心的还是SpringMVC的执行流程，各个点的作用得搞清楚。

![image-20210618201715722](https://raw.githubusercontent.com/fsjhut/image-hosting/master/md_img/image-20210618201715722.png)

第二步：加载我们的xml文件 
第三步：创建SqlSessionFactoryBuilder 
第四步：创建SqlSessionFactory 
第五步：调用openSession()，开启sqlSession 
第六步：getMapper()来获取我们的mapper（接口），mapper对应的映射文件，在加载mybatis.xml时就会加载 
第七步：使用我们自己的mapper和它对应的xml来完成我们和数据库交互。即增删改查。 
第八步：提交session，关闭session。

mybatis通过配置文件创建sqlsessionFactory，sqlsessionFactory根据配置文件，配置文件来源于两个方面:一个是xml，一个是Java中的注解，获取sqlSession。SQLSession包含了执行sql语句的所有方法，可以通过SQLSession直接运行映射的sql语句，完成对数据的增删改查和事物的提交工作，用完之后关闭SQLSession。
