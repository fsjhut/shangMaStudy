package com.javasm.plugin;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

import java.util.Properties;

/**
 * @className: MyFirstPlugin
 * @description:   
 * @author SunHang
 * @createTime 2021/6/13 16:15
 */
// 完成了插件的签名：告诉Mybatis当前插件是用来拦截哪个对象的哪个方法
@Intercepts(
        {
                @Signature(type = StatementHandler.class,
                        method = "parameterize",
                        args = java.sql.Statement.class)
        }
)
public class MyFirstPlugin implements Interceptor {
    /**
     *intercept:拦截方法
     *          拦截目标对象的目标方法的执行
     */
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        System.out.println("MyFirstPlugin的intercept方法----"+invocation.getMethod());
        // 可以对sql进行改造，添加新的数据
        Object target = invocation.getTarget();
        // 拿到目标对象的源数据
        MetaObject metaObject = SystemMetaObject.forObject(target);
        Object value = metaObject.getValue("parameterHandler.parameterObject");
        System.out.println("-------------------------");
        System.out.println("sql参数运行的数据是" + value);
        // 修改拿到的参数的值
        metaObject.setValue("parameterHandler.parameterObject",2);
        // 执行目标方法
        Object proceed = invocation.proceed();

        // 返回执行后的返回值
        return proceed;
    }

    /**
     * 包装目标对象，为目标对象创建一个代理对象
     *
     */
    @Override
    public Object plugin(Object target) {
        System.out.println("MyFirstPlugin的plugin方法----"+target);
        // mybatis为了使用方便提供了一个包装的方法wrap来使用当前的
        // Interceptor包装我们的目标对象
        Object wrap = Plugin.wrap(target, this);
        // 返回为当前target创建的包装对象
        return wrap;
    }

    /**
     * 将注册插件时的property属性设置进去
     * @param properties
     */
    @Override
    public void setProperties(Properties properties) {
        System.out.println("MyFirstPlugin的setProperties方法----");
        System.out.println("插件的配置的信息" +properties);
    }
}
