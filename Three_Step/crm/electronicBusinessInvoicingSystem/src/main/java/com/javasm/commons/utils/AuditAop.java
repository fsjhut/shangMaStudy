package com.javasm.commons.utils;

import com.alibaba.fastjson.JSON;
import com.javasm.commons.entity.AxiosResult;
import com.javasm.commons.entity.S;
import com.javasm.commons.exception.MvcException;
import com.javasm.sys.dao.VerDao;
import com.javasm.sys.entity.Ver;
import com.javasm.sys.service.VerService;
import org.apache.commons.beanutils.BeanUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName AuditAop.java
 * @Description TODO
 * @createTime 2021年07月04日 16:04:00
 */

@Aspect
@Component
public class AuditAop {

    @Resource
    private VerService verService;

    @Pointcut("@annotation(com.javasm.commons.annotation.AuditLogs)")
    public void pc() {
    }


    @Transactional
    @Around("pc()")
    public Object writeAuditLog(ProceedingJoinPoint jp) throws Throwable {

        //  当前登录人 + 当前时间
        String name = CurrentLoginUser.getUname();
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = format.format(date);
        Integer timeStamp = (int) date.getTime();


        Object[] args = jp.getArgs();
        Map map = (Map) args[0];

        Integer verifyStatus = (Integer) map.get("verifyStatus");
        String tableName = (String) map.get("verifyTable");
        String verifyTableId = (String) map.get("verifyTableId");


        if (verifyStatus == null || "".equals(verifyStatus) || tableName == null || "".equals(tableName)) {
            String proceed = (String) jp.proceed(new Object[]{map});
            if ("false".equals(proceed)) return new AxiosResult(S.ERROR);
            return new AxiosResult(S.SUC);
        }


        //  根据不同的状态码执行不同的操作
        //  当 verifyStatus==0 时，执行添加 add 操作（申请表添加）设置 create_by（创建人） create_time（创建时间）
        if (verifyStatus == 0) {
            map.put("createBy", name);
            map.put("createTime", time);

            map.put("verifyId", 1000);
            map.put("applicant", name);

            map.put("verifyPerson", "待审核");

        } else {
            map.put("updateBy", name);
            map.put("updateTime", time);

            map.put("verifyId", 2000);
            map.put("applicant", (String) map.get("createBy"));
            map.put("verifyPerson", name);
        }

        map.put("verifyTime", time);

        String[] split = tableName.split("_");
        String beanUpperName = Arrays.asList(split).stream()
                .map(o -> o.substring(0, 1).toUpperCase() + o.substring(1))
                .collect(Collectors.joining());

        String beanName = "com.javasm.sys.entity." + beanUpperName;

        //  前端传入的 申请参数对象+申请记录参数对象
        Ver verParameter = new Ver();
        Class<?> eneity = Class.forName(beanName);
        Object object = eneity.newInstance();


        if ("GoodsPriceAdjustment".equals(beanUpperName) && verifyStatus == 0) {
            map.put("priceAdjustmentId", timeStamp);
        }

        BeanUtils.populate(verParameter, map);
        BeanUtils.populate(object, map);

        Map objParameter = JSON.parseObject(JSON.toJSONString(object), Map.class);

        if (verifyStatus == 0) {

            if ("GoodsPriceAdjustment".equals(beanUpperName)) {
                jp.proceed(new Object[]{objParameter});
                verParameter.setVerifyTableId(timeStamp.toString());
            } else {
                Integer result = (Integer) jp.proceed(new Object[]{objParameter});
                verParameter.setVerifyTableId(result.toString());
            }
            //  新增审核记录

            boolean res1 = verService.add(verParameter);
            if (res1) return new AxiosResult(S.SUC);
            return new AxiosResult(S.ERROR);


            //  当 verifyStatus != 0 时，执行修改操作，修改申请表，添加审核记录
        } else {

            if ("GoodsPriceAdjustment".equals(beanUpperName)) {
                jp.proceed(new Object[]{objParameter});
                verParameter.setVerifyTableId((String) map.get("verifyTableId"));
            } else {
                jp.proceed(new Object[]{objParameter});
            }
            String createBy = (String) map.get("createBy");
            verParameter.setApplicant(createBy);
            boolean res2 = verService.add(verParameter);
            if (res2) return new AxiosResult(S.SUC);
            return new AxiosResult(S.ERROR);


        }


    }

}