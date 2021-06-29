## day13_6_22 mavaen项目管理工具(重要)和JJWT

### 1.maven的作用

进行后端项目管理（与vue脚手架类似），包含了项目的创建。

* 创建项目
* 管理依赖项
* 编译项目
* 打包项目
* 部署项目

### 2. maven中的几个概念

**gradle**

maven中央仓库（服务器）管理了所有的maven资源(项目骨架,maven插件,jar包依赖)

maven企业私服：通过nexus搭建企业maven服务器，与maven中央仓库进行数据同步

maven客户端：需要下载安装到本地开发机，客户端可以配置maven私服镜像地址，可以配置本地仓库路径

maven资源坐标：groupid:artifactId version通过三个维度来确定一个资源的命名.

### 3. 安装maven客户端

- 解压maven客户端到本地硬盘,(不要中文路径)
- 配置本地仓库,配置镜像地址

```xml
<localRepository>D:\apache-maven-3.6.0\repository</localRepository>
<mirror>
		<id>nexus-javasm</id>
		<mirrorOf>central</mirrorOf>
		<name>Nexus javasm</name>
		<url>http://192.168.20.252:8081/repository/maven-public/</url>
	</mirror>
```

### 4. idea关联maven本地客户端

file-settings-maven:关联本地mavne客户端,关联到本地settings.xml;(只对当前项目生效)

file-otherSettings-maven:(对所有项目生效的mavne配置)

### 5. 创建maven项目，了解结构

![image-20210622191115554](https://raw.githubusercontent.com/fsjhut/image-hosting/master/md_img/image-20210622191115554.png)

* 骨架就是项目模板，不同的项目有不同的模板。
* java工程骨架：org.apache.maven.archetypes:maven-archetype-quickstart:
* web工程骨架:org.apache.maven.archetypes:maven-archetype-webapp

目录结构

* src/main/java:源码目录
* src/main/resources:资源配置目录
* src/main/webapp:web资源目录
* src/test/java:junit测试源码目录
* pom.xml:maven工程的核心配置文件

### 6. 修改maven的骨架错误，自定义骨架

* 骨架中缺少部分的文件夹，指定相关的文件夹类型

* web项目中的xml文件内容错误

* 因此需要将自己修改后的正确项目自定义为一个模板（骨架）。

* 确保文件夹中不为空。(为空的话，idea还是当作没有文件夹识别)

* 将其定义为一个骨架

  * 在pom文件中配置一个maven自定义骨架的插件

  ![image-20210623100443967](https://raw.githubusercontent.com/fsjhut/image-hosting/master/md_img/image-20210623100443967.png)

* 当安装完成插件后，在右侧的Plugins中，找到插件，从里面找到相关的命令。
* 执行archetype:create-from-project:调用插件创建骨架工程，
* 将骨架工程安装到本地仓库中，手工执行命令。打包为骨架的jar包，安装到本地仓库
* 使用命令，扫描本地的所有的骨架工程
* add archetype,进行java工程与web工程骨架的自定义。

### 7. 熟悉pom.xml文件

* 当前项目坐标信息：<groupid><artifactid><version>
* 当前项目打包方式：<packaging>jar|war|pom
* 当前项目插件配置<properties>maven-resources-plugin配置编码,maven-compiler-plugin的jdk版本
* 当前项目依赖jar包配置<dependencies>配置依赖jar包，类似lib文件夹
* 当前项目插件配置：<build>

**细节点：**

* 排除自动引入的依赖包

* ```xml
   <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-webmvc</artifactId>
        <version>5.3.8</version>
        <exclusions>
          <exclusion>
            <groupId>org.springframework</groupId>
            <artifactId>spring-jcl</artifactId>
          </exclusion>
        </exclusions>
      </dependency>
  ```

* scope：jar包的作用域compile|test|provided 默认是compile，例如package，当执行package命令时，将所有作用域为compile的jar包copy到target目录下。provided是编译的时候生效，不参与package打包指令。test：是只有执行test的时候才会生效的，不参与打包。maven官网有自动的给定了默认的scope

* ```xml
  scope:compile,provided,test,默认不写,表示是compile
  compile:表示当前依赖参与打包,当执行package命令时,从本地仓库把jar包copy到target目录下;
  provided:不参与package命令,不影响代码编译,一般来说都是servlet-api.jar
  test:不参与打包,只对test命令有效.
  ```

* 把包的版本信息统一提取到上面，可以方便管理，便于更改，不容易出现问题。

* ```xml
  <properties>
      <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
      <maven.compiler.source>1.8</maven.compiler.source>
      <maven.compiler.target>1.8</maven.compiler.target>
      <!--统一依赖项的版本-->
      <spring.version>5.3.8</spring.version>
    </properties>
  ```

* maven的resources插件只会copy resources文件夹中的配置文件到target目录，因此如果是其他地方的xml文件，则不会被识别。需要进行插件的配置，让其可以识别任何位置的xml配置文件。

* ```xml
  <!--对maven-resources-plugin插件对指定目录下的哪些文件做copy-->
      <resources>
        <resource>
          <directory>src/main/java</directory>
          <includes>
            <include>**/*.xml</include>
          </includes>
        </resource>
        <resource>
          <directory>src/main/resources</directory>
          <includes>
            <include>**/*</include>
          </includes>
        </resource>
      </resources>
  ```

### 8. 熟悉maven的常用命令

* clean:清理target目录
* compile：编译命令
* test：执行src/test 目录下的测试类的测试方法，一般不用test
* package：打包命令
* install：安装到jar包到本地仓库，供其他项目依赖
* deploy：安装jar包到远程maven仓库，供其他开发人员依赖。

### 9. ssm框架的maven框架

pom.xml文件

```xml
 <properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <maven.compiler.source>1.8</maven.compiler.source>
        <maven.compiler.target>1.8</maven.compiler.target>
        <spring.version>5.3.8</spring.version>
        <commonslogging.version>1.2</commonslogging.version>
        <aspectj.version>1.9.6</aspectj.version>
        <aopalliance.version>1.0</aopalliance.version>
        <cglib.version>3.3.0</cglib.version>
        <jackson.version>2.12.3</jackson.version>
        <fastjson.version>1.2.75</fastjson.version>
        <fileupload.verion>1.3.3</fileupload.verion>
        <beanutils.version>1.9.3</beanutils.version>
        <collections.version>3.2.1</collections.version>
        <mysql.version>5.1.47</mysql.version>
        <druid.version>1.1.23</druid.version>
        <mybatis.version>3.5.6</mybatis.version>
        <mybatis.spring.version>2.0.6</mybatis.spring.version>
        <pageHelper.version>5.2.0</pageHelper.version>
        <jsqlparser.version>3.2</jsqlparser.version>
        <log4j.version>2.12.1</log4j.version>
        <slf4j.version>1.7.25</slf4j.version>
        <disruptor.version>3.4.2</disruptor.version>
        <commons.pool2.version>2.6.2</commons.pool2.version>
        <jedis.version>3.3.0</jedis.version>
    </properties>

    <dependencies>
        <!--spring-core-->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-beans</artifactId>
            <version>${spring.version}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-core</artifactId>
            <version>${spring.version}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-context</artifactId>
            <version>${spring.version}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-expression</artifactId>
            <version>${spring.version}</version>
        </dependency>
        <!--common-loging-->
        <dependency>
            <groupId>commons-logging</groupId>
            <artifactId>commons-logging</artifactId>
            <version>${commonslogging.version}</version>
        </dependency>

        <!--aspectj-->
        <dependency>
            <groupId>org.aspectj</groupId>
            <artifactId>aspectjweaver</artifactId>
            <version>${aspectj.version}</version>
        </dependency>
        <dependency>
            <groupId>org.aspectj</groupId>
            <artifactId>aspectjrt</artifactId>
            <version>${aspectj.version}</version>
        </dependency>
        <dependency>
            <groupId>aopalliance</groupId>
            <artifactId>aopalliance</artifactId>
            <version>${aopalliance.version}</version>
        </dependency>
        <!--cglib-->
        <dependency>
            <groupId>cglib</groupId>
            <artifactId>cglib</artifactId>
            <version>${cglib.version}</version>
        </dependency>
        <!--spring-aop-->
        <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-aop</artifactId>
        <version>${spring.version}</version>
    </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-aspects</artifactId>
            <version>${spring.version}</version>
        </dependency>

        <!--springmvc-->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-web</artifactId>
            <version>${spring.version}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-webmvc</artifactId>
            <version>${spring.version}</version>
        </dependency>
        <!--jackson-->
        <dependency>
            <groupId>com.fasterxml.jackson.core</groupId>
            <artifactId>jackson-databind</artifactId>
            <version>${jackson.version}</version>
        </dependency>
        <dependency>
            <groupId>com.fasterxml.jackson.core</groupId>
            <artifactId>jackson-core</artifactId>
            <version>${jackson.version}</version>
        </dependency>
        <dependency>
            <groupId>com.fasterxml.jackson.core</groupId>
            <artifactId>jackson-annotations</artifactId>
            <version>${jackson.version}</version>
        </dependency>
        <!--fastjson-->
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>fastjson</artifactId>
            <version>${fastjson.version}</version>
        </dependency>
        <!--commons-fileupload;commons-io-->
        <dependency>
            <groupId>commons-fileupload</groupId>
            <artifactId>commons-fileupload</artifactId>
            <version>${fileupload.verion}</version>
        </dependency>
        <!--commons-beanUtils-->
        <dependency>
            <groupId>commons-beanutils</groupId>
            <artifactId>commons-beanutils</artifactId>
            <version>${beanutils.version}</version>
        </dependency>
        <dependency>
            <groupId>commons-collections</groupId>
            <artifactId>commons-collections</artifactId>
            <version>${collections.version}</version>
        </dependency>

        <!--mysql-->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>${mysql.version}</version>
        </dependency>

        <!--Druid-->
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>druid</artifactId>
            <version>${druid.version}</version>
        </dependency>

        <!--mybatis,mybatis-spring-->
        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis</artifactId>
            <version>${mybatis.version}</version>
        </dependency>
        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis-spring</artifactId>
            <version>${mybatis.spring.version}</version>
        </dependency>

        <!--pageHelper-->
        <dependency>
            <groupId>com.github.pagehelper</groupId>
            <artifactId>pagehelper</artifactId>
            <version>${pageHelper.version}</version>
        </dependency>
        <dependency>
            <groupId>com.github.jsqlparser</groupId>
            <artifactId>jsqlparser</artifactId>
            <version>${jsqlparser.version}</version>
        </dependency>
        <!--spring-jdbc;spring-tx-->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-jdbc</artifactId>
            <version>${spring.version}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-tx</artifactId>
            <version>${spring.version}</version>
        </dependency>
        <!--log4j2-->
        <dependency>
            <groupId>org.apache.logging.log4j</groupId>
            <artifactId>log4j-core</artifactId>
            <version>${log4j.version}</version>
        </dependency>
        <dependency>
            <groupId>org.apache.logging.log4j</groupId>
            <artifactId>log4j-web</artifactId>
            <version>${log4j.version}</version>
        </dependency>
        <dependency>
            <groupId>org.apache.logging.log4j</groupId>
            <artifactId>log4j-api</artifactId>
            <version>${log4j.version}</version>
        </dependency>
        <!--slf4j,log4j-slf4j-impl-->
        <!-- https://mvnrepository.com/artifact/org.apache.logging.log4j/log4j-slf4j-impl -->
        <dependency>
            <groupId>org.apache.logging.log4j</groupId>
            <artifactId>log4j-slf4j-impl</artifactId>
            <version>${log4j.version}</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.slf4j</groupId>
            <artifactId>slf4j-api</artifactId>
            <version>${slf4j.version}</version>
        </dependency>
        <!--disruptor-->
        <dependency>
            <groupId>com.lmax</groupId>
            <artifactId>disruptor</artifactId>
            <version>${disruptor.version}</version>
        </dependency>
        <!--jedis,commons-pool2-->
        <dependency>
            <groupId>redis.clients</groupId>
            <artifactId>jedis</artifactId>
            <version>${jedis.version}</version>
        </dependency>
        <dependency>
            <groupId>org.apache.commons</groupId>
            <artifactId>commons-pool2</artifactId>
            <version>${commons.pool2.version}</version>
        </dependency>
        <!--junit-->
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.11</version>
            <scope>test</scope>
        </dependency>
        <!--servelt-->
        <dependency>
            <groupId>javax.servlet</groupId>
            <artifactId>javax.servlet-api</artifactId>
            <version>4.0.1</version>
            <scope>provided</scope>
        </dependency>
    </dependencies>
```



### 10. 运行maven工程

* 部署本地的tomcat启动项目

* 使用maven的内嵌服务器插件（开发模式的时候使用），把tomcat或者jboss作为一个jar包，内嵌到项目中去，

  * tomcat的内嵌服务器插件，版本过低
  * jetty-maven-plugin(内嵌服务器插件)

* ssm框架中使用不多，jfinal极速开发框架中使用内嵌jetty

* ```xml
  <plugin>
          <groupId>org.eclipse.jetty</groupId>
          <artifactId>jetty-maven-plugin</artifactId>
          <version>9.4.40.v20210413</version>
            <configuration>
                <httpConnector>
                  <port>8080</port>
                </httpConnector>
              <webApp>
                <contextPath>/</contextPath>
              </webApp>
            </configuration>
  </plugin>
  ```

  

### 11. maven模块的继承

定义父工程，<packaging>pom，只保留该工程下的pom.xml文件

打包方式为pom，则代表打包为jar包后，里面只有一个pom.xml文件

```xml
<!--父工程管理依赖项,子工程不直接继承,需要手工引入,但不用指定版本,确保多个子module之间依赖版本一致-->
  <dependencyManagement>
    <dependencies>
      <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-beans</artifactId>
        <version>5.3.8</version>
      </dependency>
    </dependencies>
  </dependencyManagement>

<!--放在dependencies下的依赖,被所有子module自动继承-->
  <dependencies>
    <dependency>
      <groupId>com.alibaba</groupId>
      <artifactId>fastjson</artifactId>
      <version>1.2.75</version>
    </dependency>
    <dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>4.13</version>
    </dependency>
  </dependencies>
```

依赖与管理依赖的区别？dependencies与dependencyManagement的区别？

* 放到dependencies中的依赖都可以被子model继承。
* dependencyManagement中的管理依赖项，不会被子工程直接继承。子工程再指定依赖的时候，不用指定依赖的jar包的版本。------------>可以避免两个不同的model之间引入的依赖，出现不同的版本，出现了版本冲突。
* 因此父工程最重要的作用：统一管理依赖项的版本，子模块不用配置依赖项的版本。

mode的概念，工程下的子模块，在maven中才会有体现。

子model中也有一个pom工程，两个子model会自动继承父工程里面的pom文件内容。父工程中管理了所有的子model。

子工程的模块

### 12. maven子模块聚合工程的搭建

使用场景：

* 云课堂的应用：对于中小型应用来说，各个模块中重复性代码非常多，如何提高代码的复用性。------->引入maven的聚合工程
  * 后台系统：课程审核，课程分类，公司驻入审核，讲师管理，注册用户管理，后台管理用户，评论的管理，用户、讲师积分的管理。
  * 接口系统（接口和后台管理一般分开），用户注册，用户登录，课程发布，课程分类，发表评论，查看收藏课程。
  * 门户平网站的应用（前端开发）
  * android移动app（使用java+h5 适配问题）
* 将重复代码剔除为model，并变为jar包，可以被其他项目所依赖。
* 按照mvc-dao纵向对单个工程拆分为多个model，达到代码复用的目的。
* spring-clound（微服务--横向拆分）

### 13. jjwt组建

因为一台服务器处理的并发量有限因此使用多台服务器搭建集群用来处理高并发的应用场景，多服务器处理时，ngix将按照一定的规则将服务请求分发给某一台服务器，因此会产生一个用户登录后所保存的session信息对其他服务器不可见的问题，要解决此问题需要有以下两种处理方案。

第一种处理方法：spring+session+redis------------------->分布式集群 共享session，仍然使用session对象保存用户的登录信息，通过redis服务器统一管理用户的session信息。此时相当于session共享。

第二种：token令牌通行机制，登录用户信息服务器不再存储，而是在登录成功后，由服务器签发一个字符串（令牌），把令牌返回给前端，前端后续请求全部携带令牌到服务器，服务器检测令牌合法性。

**登录成功后**

* 生成一个字符串（个人信息，签发时间，签发机构，到期时间，防伪信息）
* 对字符串进行加密处理得到加密后的字符串{算法：aa}{个人信息，签发事件}{密文}
  * 字符串的信息：{算法：aa}.{个人信息，签发事件，到期时间...}.{密文}
* 把token字符串传输给客户端，客户端进行存储。
* 客户端请求携带token，服务器对token进行校验。

加密的算法：对称加密，非对称加密算法。

* 对称加密：原字符串：aa 密钥：bbcc 加密后：xxdfsewa-----可以用过加密后的和密钥解密
* 非对称加密：原字符串：aa 公钥：bbcc 私钥：cccc  加密后的：asdfasdf--->用于https中

**学习jjwt的目的**：为了对明文的token进行加密，得到有效防伪的token，同时可以解密校验token。

token的应用：登录校验，接口的过滤(安全)，有时效的url

jjwt组建的应用（为了安卓开发面向接口编程）

* 添加jjwt的环境，引入maven中jar包配置文件

* ```xml
  <dependency>
      <groupId>io.jsonwebtoken</groupId>
      <artifactId>jjwt-api</artifactId>
      <version>0.11.2</version>
  </dependency>
  <dependency>
      <groupId>io.jsonwebtoken</groupId>
      <artifactId>jjwt-impl</artifactId>
      <version>0.11.2</version>
      <scope>runtime</scope>
  </dependency>
  <dependency>
      <groupId>io.jsonwebtoken</groupId>
      <artifactId>jjwt-jackson</artifactId> <!-- or jjwt-gson if Gson is preferred -->
      <version>0.11.2</version>
      <scope>runtime</scope>
  </dependency>
  ```

* 应用案例。

token在登录以及登录校验中如何使用。

在对token的密文进行反向解析，与第二部分的明文进行比对，如果相同则代表通过，如果不同则代表已经过期了。

jjwt工具类的编写，了解token，使用token，使用jjwt工具编写token

```java
package com.javasm.commons.utils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author SunHang
 * @className: JJWTUtil
 * @description:
 * @createTime 2021/6/23 18:50
 */
public class JJWTUtil {
    private static final String CUSTOM_CLAIM = "uphone";
    private static final Long EXP_TIME = 60 * 1000L;
    private static final String KEYSTR = "U5FTZxEKTLG8gSmspf/kA4RgnHhr+mlA1w3LSPdprNY=";

    public static void main(String[] args) {
        System.out.println(generate("23242424"));
        String token = generate("23242424");
        Claims parse = parse(token);
        assert parse != null;
        System.out.println(getUhpone(parse));
        System.out.println(getIssuredAt(parse));

    }

    public static void getKey() {
        //Keys按照指定HS256算法生成密钥的工具类
        Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
        byte[] encoded = key.getEncoded();
        String encode = Encoders.BASE64.encode(encoded);
        System.out.println(encode);
    }
		
    // 生成token令牌的，jjwt:{header}.{body}.{密文}
    public static String generate(String uphone) {
        // 当前时间
        Date current = DateUtil.currentDate();
        // 过期时间
        Date exp = DateUtil.getNextDate(current, EXP_TIME);
        // 自定义签名
        Map<String, String> claims = new HashMap<>();
        claims.put(CUSTOM_CLAIM, uphone);
        // Keys:密钥工具类，按照指定算法生成密钥
        Key key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(KEYSTR));

        String jws = Jwts.builder()
                .setClaims(claims) // 自定义签名，放用户的标识,必须放标准签名之前
                .setIssuedAt(current) // 签发时间
                .setExpiration(exp) //过期时间
                .signWith(key)    // 指定密钥
                .compact();
        // jws是json字符串进行base64编码后的数据
        return jws;
    }
		// 解析密钥
    public static Claims parse(String token) {
        //在对token的密文进行反向解密,与第二部分明文进行比对,比对通过正常返回,不通过,报异常(不匹配或者过期则不通过)
        Jws<Claims> claimsJws = null;
        try {
            claimsJws = Jwts.parserBuilder().setSigningKey(KEYSTR).build().parseClaimsJws(token);
        } catch (Exception e) {
            return null;
        }
        return claimsJws.getBody();
    }

    public static Date getIssuredAt(Claims c) {
        return c.getIssuedAt();
    }

    public static String getUhpone(Claims c) {
        return c.get(CUSTOM_CLAIM, String.class);
    }
}
```

### 14. JJWT工具类的应用

* 登录成功后生成一个token,返回客户端

```java
登录成功!!redis中与mysql中都有用户登录信息. key:Keys.USERS_HASH,field:uname2 String token = JJWTUtil.generate(user.getUname());
HttpHeaders headers = new HttpHeaders();
headers.add("token",token);
return new ResponseEntity(suc(user),headers,HttpStatus.OK);
```

```xml
//在corsFilter对象中配置允许客户端收到响应头.
<property name="exposedHeaders">
    <list>
        <value>token</value>
    </list>
</property>
```

* 客户端收到token,并进行保存localStorage|cookie（关闭游览器还会保存）

```java
//在axios的响应拦截方法中,对token进行保存
let headers = response.headers;//响应头
	  //1.判断headers是否有token头部信息,有的话,获取并保存
	  let headerKeys = Object.keys(headers);//Object.values()
	  if(headerKeys.indexOf("token")>=0){
		  let token = headers['token'];
		  localStorage.setItem("token",token);
	  }
```

* 客户端提交axios或者ajax请求，携带token，与表单参数一起传递给服务器

  ```java
  //axios的请求拦截处,向请求头中添加token
  	let headers = config.headers;
  	let token = localStorage.getItem("token");
  	if(token!=null && token!=undefined){
  		headers['token']=token;
  	}
  ```

* 服务器拦截请求，对token进行校验，失败则返回到登录界面，成功则执行接口

* 有新的请求，则需要刷新token的有效期

```java
		//获取请求头中的token字符串
 		String token = request.getHeader("token");
        //如果为null,则未登录
        if(null==token)throw new MvcException(S.NO_LOGIN);
        //校验token
        Claims claims = JJWTUtil.parse(token);
        if(claims==null)throw new MvcException(S.NO_LOGIN);

        String uname = JJWTUtil.getUname(claims);//admin..获取完整对象
        String userStr = rs.hget(Keys.USERS_HASH, uname);
        Sysuser loginUser = JSON.parseObject(userStr,Sysuser.class);

        CurrentLoginUser.setLoginUser(loginUser);

        //刷新token
        String newToken = JJWTUtil.generate(uname);
        response.addHeader("token",newToken);
        return true;
```

登录成功----->redis和mysql中都有用户的登录信息。redis中保存的是hash表中

-------------->生成了一个token字符串。-------------->将token放在请求头中，返回前端。

ResponseEntity

前端中如何获取header中的信息。response中有header+data+config。

判断headers中是否有token头信息，有的话取出，并保存。

在跨域访问时，前端接受不到后端传递的响应头信息

