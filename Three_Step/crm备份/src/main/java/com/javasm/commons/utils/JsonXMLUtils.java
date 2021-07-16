package com.javasm.commons.utils;

import com.alibaba.fastjson.JSON;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @className: JsonXMLUtils
 * @description:  对象转json，json转对象，map转json json转map
 * @author SunHang
 * @createTime 2021/6/30 19:10
 */
public class JsonXMLUtils {
    public static String obj2json(Object obj){
        return JSON.toJSONString(obj);
    }
    public static <T> T json2obj(String json,Class<T> clazz){
        return JSON.parseObject(json,clazz);
    }
    public static Map<String,Object> json2map(String json){
        return JSON.parseObject(json,Map.class);
    }
    public static <T,K> String map2json(Map<T,K> map){
        return JSON.toJSONString(map);
    }
    public static <T> T map2obj(Map<?,?>map,Class<T> clazz){
        return JSON.parseObject(map2json(map),clazz);
    }
    public static <T> List<T> listStr2listObj(String json, Class<T> clazz){
        List<T> listObj= new ArrayList<>();
        List objs = JSON.parseObject(json, List.class);
        for (Object obj : objs) {
            T t = map2obj(json2obj((String) obj,Map.class), clazz);
            listObj.add(t);
        }
        return listObj;
    }
    public static <T> List<T> listStr2listObj(ArrayList<Object> list, Class<T> clazz) throws InvocationTargetException, IllegalAccessException, InstantiationException {
        List<T> listObj= new ArrayList<>();
        for (Object obj : list) {
            T t1 = clazz.newInstance();
            BeanUtils.populate(t1, (Map<String, ? extends Object>) obj);
//            T t = map2obj((Map<?, ?>) obj, clazz);
            listObj.add(t1);
        }
        return listObj;
    }
}
