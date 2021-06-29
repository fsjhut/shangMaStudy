package com.javasm.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * @className: MapConvertEntity
 * @description:   
 * @author SunHang
 * @createTime 2021/6/26 21:13
 */
public class MapConvertEntity {

    private static String nameFrefix = "set";

    public static Object mapConvertEntity(Object obj, Map<String, Object> map){
        //获取obj对象
        Class<?> clazz = obj.getClass();
        if(!map.isEmpty()){
            for (Map.Entry<String, Object> entry : map.entrySet()){
                String oldname = entry.getKey();
                Object value = entry.getValue();
                String key = UnderlineToHump(oldname);
                Field field = getField(clazz,key);
                if(field != null){

                    try {
                        Class<?> fieldType = field.getType();
                        value = convertValType(value, fieldType);
                        Method method = null;
                        //获取set方法名
                        String setMethodName = convertStr(key);
                        method = clazz.getMethod(setMethodName, field.getType());
                        if(field.isAccessible()){
                            field.setAccessible(true);
                        }
                        method.invoke(obj, value);
                        field.setAccessible(false);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

        }
        return obj;
    }

    /**
     * 将string字符串的首字母大写
     * @param str
     * @return
     */
    private static String convertStr(String str){
        String keyStr = nameFrefix.concat(str.substring(0,1).toUpperCase() + str.substring(1));
        return keyStr;
    }

    /**
     * @description 获取类的属性
     * @param clazz
     * @param fieldName
     * @return
     */
    private static Field getField(Class<?> clazz, String fieldName){

        //判断传入的是Object类型或者是null，直接返回空
        if(clazz == null || Object.class.getName().equals(clazz.getName())){
            return null;
        }

        Field[] fields = clazz.getDeclaredFields();
        for(Field field : fields){
            if(field.getName().equals(fieldName)){
                return field;
            }
        }

        Class<?> classUpper = clazz.getSuperclass();
        if(classUpper != null){
            return getField(classUpper,fieldName);
        }
        return null;
    }

    /**
     * @description 将object中的值按照类型转换为entity中的值
     * @param obj
     * @param fieldType
     * @return
     */
    private static Object convertValType(Object obj,Class<?> fieldType){

        Object retVal = null;
        if(Long.class.getName().equals(fieldType.getName()) || long.class.getName().equals(fieldType.getName())){
            retVal = Long.parseLong(obj.toString());
        }
        else if(Double.class.getName().equals(fieldType.getName()) || double.class.getName().equals(fieldType.getName())){
            retVal = Double.parseDouble(obj.toString());
        }
        else if(Integer.class.getName().equals(fieldType.getName()) || int.class.getName().equals(fieldType.getName())){
            retVal = Integer.parseInt(obj.toString());
        }
        else if (Float.class.getName().equals(fieldType.getName()) || float.class.getName().equals(fieldType.getName())){
            retVal = Float.parseFloat(obj.toString());
        }
        else if(String.class.getName().equals(fieldType.getName())){
            retVal = obj;
        }
        else if(Character.class.getName().equals(fieldType.getName()) || char.class.getName().equals(fieldType.getName())){
            retVal = obj;
        }
        else if (Date.class.getName().equals(fieldType.getName())){
            retVal = convertStrToDate(obj.toString());
        }
        return retVal;
    }

    /**
     * @description 将String类型数据转换为Date类型
     * @param str
     * @return
     */
    private static Date convertStrToDate(String str){

        Date date = null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        try {
            date = simpleDateFormat.parse(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }
    public static String UnderlineToHump(String para){
        StringBuilder result=new StringBuilder();
        String a[]=para.split("_");
        for(String s:a){
            if (!para.contains("_")) {
                result.append(s);
                continue;
            }
            if(result.length()==0){
                result.append(s.toLowerCase());
            }else{
                result.append(s.substring(0, 1).toUpperCase());
                result.append(s.substring(1).toLowerCase());
            }
        }
        return result.toString();
    }
}
