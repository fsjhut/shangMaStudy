## day10_SSM整合补充

### 1. CorsFilter跨域请求过滤器对象注册

通过阅读DelegatingFilterProxy中的doFilter方法，查看内部是从那个容器中获取到CorsFilter

内部是从父容器中getBean(targetBeanName,Filter.class) 得到真正的CorsFilter跨域过滤器对象

* CorsFilter应该注册到spring父容器中

### 2. Spring中常用的接口

ApplicationContextAware接口： 把容器中的引用暴露出去的一种方式

InitializingBean接口：指定初始化方法

### 3. ServletRequestAttributes 以及RequestContextHolder

ServletRequestAttributes:当有用户请求时，DispatcherServlet中的processRequest方法处理该请求，该方法内把request,response对象封装到ServletRequestAttributes对象

* RequestAttributes r = new ServletRequestAttributes(request,response)
* RequestContextHolder.setRequestAttributes(r);//把封装对象保存到线程变量中.

```java
public static ServletRequestAttributes getRequestAttributes(){
        ServletRequestAttributes requestAttributes =  (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        return requestAttributes;
}
```

### 4. 抽取公共的代码

抽取BaseDao,BaseService,BaseServiceImpl,BaseHandler,BaseEntity

编辑easycode插件的模板:

entity:

```java
##引入宏定义
$!define

##使用宏定义设置回调（保存位置与文件后缀）
#save("/entity", ".java")

##使用宏定义设置包后缀
#setPackageSuffix("entity")

##使用全局变量实现默认包导入
$!autoImport
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.javasm.commons.base.BaseEntity;
##使用宏定义实现类注释信息
#tableComment("实体类")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class $!{tableInfo.name} extends BaseEntity  implements Serializable {
    private static final long serialVersionUID = $!tool.serial();
#foreach($column in $tableInfo.fullColumn)
    #if(${column.comment})/**
    * ${column.comment}
    */#end

    private $!{tool.getClsNameByFullName($column.type)} $!{column.name};
#end

#foreach($column in $tableInfo.fullColumn)
##使用宏定义实现get,set方法
#getSetMethod($column)
#end

}
```



dao接口:

```java
##定义初始变量
#set($tableName = $tool.append($tableInfo.name, "Dao"))
##设置回调
$!callback.setFileName($tool.append($tableName, ".java"))
$!callback.setSavePath($tool.append($tableInfo.savePath, "/dao"))

##拿到主键
#if(!$tableInfo.pkColumn.isEmpty())
    #set($pk = $tableInfo.pkColumn.get(0))
#end

#if($tableInfo.savePackageName)package $!{tableInfo.savePackageName}.#{end}dao;

import $!{tableInfo.savePackageName}.entity.$!{tableInfo.name};
import org.apache.ibatis.annotations.Param;
import java.util.List;
import com.javasm.commons.base.BaseDao;

public interface $!{tableName} extends BaseDao<$!{tableInfo.name}> {

}

```

service接口:

```java
##定义初始变量
#set($tableName = $tool.append($tableInfo.name, "Service"))
##设置回调
$!callback.setFileName($tool.append($tableName, ".java"))
$!callback.setSavePath($tool.append($tableInfo.savePath, "/service"))

##拿到主键
#if(!$tableInfo.pkColumn.isEmpty())
    #set($pk = $tableInfo.pkColumn.get(0))
#end

#if($tableInfo.savePackageName)package $!{tableInfo.savePackageName}.#{end}service;

import $!{tableInfo.savePackageName}.entity.$!{tableInfo.name};
import java.util.List;
import com.javasm.commons.base.BaseService;

public interface $!{tableName}  extends BaseService<$!{tableInfo.name}> {

}
```

servcieImpl实现类:

```java
##定义初始变量
#set($tableName = $tool.append($tableInfo.name, "ServiceImpl"))
##设置回调
$!callback.setFileName($tool.append($tableName, ".java"))
$!callback.setSavePath($tool.append($tableInfo.savePath, "/service/impl"))

##拿到主键
#if(!$tableInfo.pkColumn.isEmpty())
    #set($pk = $tableInfo.pkColumn.get(0))
#end

#if($tableInfo.savePackageName)package $!{tableInfo.savePackageName}.#{end}service.impl;

import $!{tableInfo.savePackageName}.entity.$!{tableInfo.name};
import $!{tableInfo.savePackageName}.dao.$!{tableInfo.name}Dao;
import $!{tableInfo.savePackageName}.service.$!{tableInfo.name}Service;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import com.javasm.commons.base.BaseServiceImpl;

@Service("$!tool.firstLowerCase($!{tableInfo.name})Service")
public class $!{tableName}  extends BaseServiceImpl<$!{tableInfo.name}Dao,$!{tableInfo.name}> implements $!{tableInfo.name}Service {
    
}
```

controller:

```java
##定义初始变量
#set($tableName = $tool.append($tableInfo.name, "Handler"))
##设置回调
$!callback.setFileName($tool.append($tableName, ".java"))
$!callback.setSavePath($tool.append($tableInfo.savePath, "/handler"))
##拿到主键
#if(!$tableInfo.pkColumn.isEmpty())
    #set($pk = $tableInfo.pkColumn.get(0))
#end

#if($tableInfo.savePackageName)package $!{tableInfo.savePackageName}.#{end}handler;

import $!{tableInfo.savePackageName}.entity.$!{tableInfo.name};
import $!{tableInfo.savePackageName}.service.$!{tableInfo.name}Service;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import com.javasm.commons.base.BaseHandler;
import com.javasm.commons.entity.AxiosResult;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("$!tool.firstLowerCase($tableInfo.name)")
public class $!{tableName} extends BaseHandler{
   
    @Resource
    private $!{tableInfo.name}Service $!tool.firstLowerCase($tableInfo.name)Service;

    @GetMapping("{id}")
    public AxiosResult selectById(@PathVariable("id") String id){
        $!{tableInfo.name} obj = this.$!{tool.firstLowerCase($tableInfo.name)}Service.selectById(id);
        return suc(obj);
    }
    
   @GetMapping("list")
    public AxiosResult selectList($!{tableInfo.name} obj){
        startPage();
        List<$!{tableInfo.name}> list = this.$!{tool.firstLowerCase($tableInfo.name)}Service.selectList(obj);
        return toTableDatas(list);
    }
    
    @PostMapping
    public AxiosResult add(@RequestBody $!{tableInfo.name} obj){
        boolean r = this.$!{tool.firstLowerCase($tableInfo.name)}Service.add(obj);
        return result(r);
    }
    
    @PutMapping
    public AxiosResult update(@RequestBody $!{tableInfo.name} obj){
        boolean r = this.$!{tool.firstLowerCase($tableInfo.name)}Service.updateById(obj);
        return result(r);
    }
    
     @DeleteMapping("{ids}")
    public AxiosResult delById(@PathVariable("ids")String ids){
        String[] split = ids.split(",");
        boolean r = this.$!{tool.firstLowerCase($tableInfo.name)}Service.delByIds(Arrays.asList(split));
        return result(r);
    }
    
    

}
```

mapper.xml

```java
##引入mybatis支持
$!mybatisSupport

##设置保存名称与保存位置
$!callback.setFileName($tool.append($!{tableInfo.name}, "Dao.xml"))
$!callback.setSavePath($tool.append($modulePath, "/src/main/resources/mapper"))

##拿到主键
#if(!$tableInfo.pkColumn.isEmpty())
    #set($pk = $tableInfo.pkColumn.get(0))
#end

<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="$!{tableInfo.savePackageName}.dao.$!{tableInfo.name}Dao">

    <resultMap type="$!{tableInfo.savePackageName}.entity.$!{tableInfo.name}" id="$!{tableInfo.name}Map">
#foreach($column in $tableInfo.fullColumn)
        <result property="$!column.name" column="$!column.obj.name" jdbcType="$!column.ext.jdbcType"/>
#end
    </resultMap>

    <select id="selectById" resultMap="$!{tableInfo.name}Map">
        select
          #allSqlColumn()

        from $!{tableInfo.obj.parent.name}.$!tableInfo.obj.name
        where $!pk.obj.name = #{$!pk.name}
    </select>

    
    <select id="selectList" resultMap="$!{tableInfo.name}Map">
        select
          #allSqlColumn()

        from $!{tableInfo.obj.parent.name}.$!tableInfo.obj.name
        <where>
#foreach($column in $tableInfo.fullColumn)
            <if test="$!column.name != null#if($column.type.equals("java.lang.String")) and $!column.name != ''#end">
                and $!column.obj.name = #{$!column.name}
            </if>
#end
        </where>
    </select>

    <insert id="add" keyProperty="$!pk.name" useGeneratedKeys="true">
        insert into $!{tableInfo.obj.parent.name}.$!{tableInfo.obj.name}(#foreach($column in $tableInfo.otherColumn)$!column.obj.name#if($velocityHasNext), #end#end)
        values (#foreach($column in $tableInfo.otherColumn)#{$!{column.name}}#if($velocityHasNext), #end#end)
    </insert>

    <update id="updateById">
        update $!{tableInfo.obj.parent.name}.$!{tableInfo.obj.name}
        <set>
#foreach($column in $tableInfo.otherColumn)
            <if test="$!column.name != null#if($column.type.equals("java.lang.String")) and $!column.name != ''#end">
                $!column.obj.name = #{$!column.name},
            </if>
#end
        </set>
        where $!pk.obj.name = #{$!pk.name}
    </update>

    <delete id="delById">
        delete from $!{tableInfo.obj.parent.name}.$!{tableInfo.obj.name} where $!pk.obj.name = #{$!pk.name}
    </delete>

  <delete id="delByIds">
        delete from $!{tableInfo.obj.parent.name}.$!{tableInfo.obj.name} where $!pk.obj.name in
        <foreach collection="list" open="(" close=")" item="id" separator=",">
            #{id}
        </foreach>
    </delete>
 </mapper>

```

