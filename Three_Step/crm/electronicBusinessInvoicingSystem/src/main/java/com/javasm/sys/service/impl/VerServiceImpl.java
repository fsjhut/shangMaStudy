package com.javasm.sys.service.impl;

import com.javasm.commons.entity.S;
import com.javasm.commons.exception.MvcException;
import com.javasm.commons.utils.CurrentLoginUser;
import com.javasm.commons.utils.DateUtil;
import com.javasm.commons.utils.SpringUtil;
import com.javasm.sys.dao.VerDao;
import com.javasm.sys.entity.Ver;
import com.javasm.sys.service.VerService;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Service;
import com.javasm.commons.base.BaseServiceImpl;
import org.springframework.transaction.annotation.Transactional;

import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;
import java.util.stream.Collectors;

@Service("verService")
public class VerServiceImpl extends BaseServiceImpl<VerDao, Ver> implements VerService {

    @Transactional
    @Override
    public boolean adds(Map map) throws Exception {

        String verifyTableId = (String) map.get("verifyTableId");
        Integer verifyId = (Integer) map.get("verifyId");
        Integer verifyStatus = (Integer) map.get("verifyStatus");
        //  当审核状态未赋值时，抛出自定异常
        if (verifyStatus == null) {
            throw new MvcException(S.ERROR);
        }

        //  当前登录人 + 当前时间
        Integer ujob = CurrentLoginUser.getLoginUser().getUjob();
        String name = CurrentLoginUser.getUname();
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = format.format(date);


        //  根据不同的状态码执行不同的操作
        //  当 verifyStatus==0 时，执行添加 add 操作（申请表添加）设置 create_by（创建人） create_time（创建时间）
        if ((verifyStatus == 0|| (ujob == 2 && verifyStatus == 1))&&(verifyTableId==null||"".equals(verifyTableId))) {
            map.put("createBy", name);
            map.put("createTime", time);

            map.put("verifyId", 1000);
            map.put("applicant", name);

            map.put("verifyPerson", "");


        } else {
            map.put("updateBy", name);
            map.put("updateTime", time);

            map.put("verifyId", 2000);
            map.put("applicant", (String) map.get("createBy"));
            map.put("verifyPerson", name);

        }

        map.put("verifyTime", time);


        String tableName = (String) map.get("verifyTable");
        String[] split = tableName.split("_");
        String beanUpperName = Arrays.asList(split).stream()
                .map(o -> o.substring(0, 1).toUpperCase() + o.substring(1))
                .collect(Collectors.joining());

        String beanName = "com.javasm.sys.entity." + beanUpperName;

        //  获取service在容器中的ID ，获取serviceImpl中指定方法
        String serviceName = beanUpperName.substring(0, 1).toLowerCase() + beanUpperName.substring(1) + "Service";
        Object serviceBean = SpringUtil.getBean(serviceName);

        //  前端传入的 申请参数对象+申请记录参数对象
        Ver verParameter = new Ver();
        Class<?> eneity = Class.forName(beanName);
        Object objParameter = eneity.newInstance();


        //  获取申请记录表 sercice层的 ADD 和 UPDATE 方法

        Method adds = serviceBean.getClass().getMethod("adds", eneity);
        Method update = serviceBean.getClass().getMethod("updateById", Object.class);


        BeanUtils.populate(verParameter, map);
        BeanUtils.populate(objParameter, map);


        //  审核状态，字典数据，0：未审核，1：通过，2：未通过


        //  执行添加审核记录  设置 verifyTime（记录添加时间） verifyStatus（当前审核状态） verifyTableId（申请表新增记录唯一ID），
        if ((((verifyStatus == 0|| (ujob == 2 && verifyStatus == 1))&&(map.get("verifyTableId")==null))||(verifyStatus == 0&&ujob != 2)||(ujob == 1 && verifyStatus == 5))&&verifyId!=2000) {

            //  新增申请记录,返回自增ID
            Integer result = (Integer) adds.invoke(serviceBean, objParameter);
            verParameter.setVerifyTableId(result.toString());
            boolean res1 = this.add(verParameter);
            return res1;
            //  当 verifyStatus!=0时，执行修改操作，修改申请表
        } else {
            update.invoke(serviceBean, objParameter);
            boolean res2 = this.add(verParameter);
            return res2;
        }
    }
    @Override
    public boolean add(Map map) {


        return false;
    }

    @Transactional
    @Override
    public boolean auditMultistage(Map map) throws Exception {
        Integer verifyStatus = (Integer) map.get("verifyStatus");
        String tableName = (String) map.get("verifyTable");
        String verifyTableId = (String) map.get("verifyTableId");
        //  当审核状态未赋值时，抛出自定异常
        if (verifyStatus == null || "".equals(verifyStatus) || tableName == null || "".equals(tableName)) {
            throw new MvcException(S.ERROR);
        }

        //  更新操作前端未传 verifyTableId 异常
        if (verifyStatus != 0 && (verifyTableId == null || "".equals(verifyTableId))) {
            throw new MvcException(S.ERROR);
        }

        //  当前登录人 + 当前时间
        String name = CurrentLoginUser.getUname();
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = format.format(date);
        Integer timeStamp = (int) date.getTime();


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

        //  获取service在容器中的ID ，获取serviceImpl中指定方法
        String serviceName = beanUpperName.substring(0, 1).toLowerCase() + beanUpperName.substring(1) + "Dao";
        Object serviceBean = SpringUtil.getBean(serviceName);


        //  获取申请记录表 dao 层的 ADD 和 UPDATE 方法
        Method add = serviceBean.getClass().getMethod("add", Object.class);
        Method update = serviceBean.getClass().getMethod("updateById", Object.class);


        //  前端传入的 申请参数对象+申请记录参数对象
        Ver verParameter = new Ver();
        Class<?> eneity = Class.forName(beanName);
        Object objParameter = eneity.newInstance();

        if ("GoodsPriceAdjustment".equals(beanUpperName) && verifyStatus == 0) {
            map.put("priceAdjustmentId", timeStamp);
        }

        BeanUtils.populate(verParameter, map);
        BeanUtils.populate(objParameter, map);


        //  审核状态，字典数据，0：未审核，1：二次审核通过，2：驳回 5：一次审核通过


        //  执行添加审核记录  设置 verifyTime（记录添加时间） verifyStatus（当前审核状态） verifyTableId（申请表新增记录唯一ID），
        if (verifyStatus == 0) {
            if ("GoodsPriceAdjustment".equals(beanUpperName)) {
                add.invoke(serviceBean, objParameter);
                verParameter.setVerifyTableId(timeStamp.toString());
            } else {
                Integer result = (Integer) add.invoke(serviceBean, objParameter);
                verParameter.setVerifyTableId(result.toString());
            }
            //  新增审核记录
            boolean res1 = this.add(verParameter);
            return res1;
            //  当 verifyStatus != 0 时，执行修改操作，修改申请表，添加审核记录
        } else {

            update.invoke(serviceBean, objParameter);
            boolean res2 = this.add(verParameter);
            return res2;
        }
    }
}
