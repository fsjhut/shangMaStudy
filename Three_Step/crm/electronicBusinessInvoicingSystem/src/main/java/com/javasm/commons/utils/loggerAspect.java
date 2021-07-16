package com.javasm.commons.utils;

import com.javasm.commons.annotation.LoggerInfo;
import com.javasm.commons.entity.AxiosResult;
import com.javasm.commons.entity.S;
import com.javasm.commons.exception.MvcException;
import com.javasm.sys.entity.Log;
import com.javasm.sys.service.LogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

//日志切面类

@Controller
@Aspect
public class loggerAspect {


    @Resource
    private LogService service;

    @Pointcut("@annotation(com.javasm.commons.annotation.LoggerInfo)")
    public void pc() {
    }

    @Around("pc()")
    public Object aroundAdvice(ProceedingJoinPoint jp) {
        //jp对象能够得到所有的连接点信息
        Object result = null;

        //声明对象，保存日志信息
        Log log = new Log();

        try {
            //通过request对象获取访问的主机名称和ip地址
            HttpServletRequest request = ServletUtil.getRequest();
            //ip地址
            result = jp.proceed();//Object result = method.invoke(target,args)

            //访问模块
            String methodName = jp.getSignature().getName();

            String name = jp.getTarget().getClass().getName();
            //System.out.println("name==" + name);
            Class<?> targetClass = Class.forName(name);
            Method[] methods = targetClass.getMethods();
            AxiosResult a = (AxiosResult) result;
            for (Method method : methods) {
                //判断方法名是否一样
                if (method.getName().equals(methodName)) {
                    String uname = CurrentLoginUser.getUname();
                    uname = uname == null ? "空" : uname;
                    //获取日志信息
                    log.setAccessuser(uname); //访问用户名
                    log.setOperatingTime(DateUtil.getYMDHMS()); //时间
                    log.setIpAddress(request.getRemoteAddr());//ip
                    log.setPort(Integer.toString(request.getRemotePort())); //端口号
                    log.setAccessmodule(method.getAnnotation(LoggerInfo.class).operModul()); //访问模块
                    log.setAccesstype(method.getAnnotation(LoggerInfo.class).operType()); //访问类型
                    log.setOperatingcontents(method.getAnnotation(LoggerInfo.class).operDesc()); //访问内容
                    log.setOperatingresult(a.getMsg());//操作结果
                }
            }

            System.out.println("log====>>>>>" + log);
            logInfo(log);
            //System.out.println("result=="+result);


        } catch (Throwable e) {
            //throwable.printStackTrace();
            throw new MvcException(S.ERROR);
        } finally {
            //System.out.println("最终通知");
        }
        return result;

    }


    private void logInfo(Log log) {
        boolean add = service.add(log);

    }


}
