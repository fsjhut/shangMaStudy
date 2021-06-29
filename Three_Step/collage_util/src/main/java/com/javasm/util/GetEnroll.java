package com.javasm.util;
/**
 * @className: GetEnroll
 * @description:   
 * @author SunHang
 * @createTime 2021/6/26 19:44
 */

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.javasm.dao.EnrollDao;
import com.javasm.dao.SchoolDao;
import com.javasm.entity.Enroll;
import com.javasm.entity.School;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @className: GetMessage
 * @description:
 * @author SunHang
 * @createTime 2021/6/26 15:34
 */
public class GetEnroll {
    private static ArrayList<String> errorList = new ArrayList<>();
    private static ArrayList<String> pathList = new ArrayList<>();

    public static void main(String[] args) {
        // 先生成所有的url列表
        generateAllUrl();

        for (String path : pathList) {
            JSONObject jsonData = getData(path);
            if(jsonData==null||jsonData.isEmpty()){
                continue;
            }
            System.out.println(jsonData.toJSONString());

            JSON getItem = getValue("item",jsonData);
            System.out.println(getItem.toJSONString());
            List<HashMap<String,Object>> item = new ArrayList<>();
            item = (List<HashMap<String,Object>>)JSONArray.parse(getItem.toJSONString());
            for(Map<String,Object> mapList : item){
                Enroll enroll1 = new Enroll();
                Enroll enroll = (Enroll)MapConvertEntity.mapConvertEntity(enroll1, mapList);
                System.out.println(enroll);
                if(enroll==null||jsonData.isEmpty()){
                    continue;
                }
                addToSql(enroll);
            }
        }
        errorList.forEach(System.out::println);
    }


    private static JSONObject getData(String path){
        RestTemplate restTemplate = new RestTemplate();
        String context = restTemplate.getForObject(path, String.class);
        if ("\"\"".equals(context) ||context.length()==2){
            errorList.add(path);
            return null;
        }
//        System.out.println(context.length());
        JSONObject jsonAll = JSON.parseObject(context);
        return  (JSONObject)getValue("data", jsonAll);
    }

    private static void addToSql(Enroll enroll){
        SqlSessionFactory factory = SSF.getFactory();
        SqlSession sqlSession = factory.openSession();
        EnrollDao mapper = sqlSession.getMapper(EnrollDao.class);
        int i = mapper.addObj(enroll);
        if(i!=1){
            errorList.add(enroll.getSchoolId());
            return;
        }
        sqlSession.commit();
        sqlSession.close();


    }

//    private static Enroll setSchool(JSONObject jsonData){
//        Enroll school = new Enroll();
//
//        return school;
//    }

    private static void generateAllUrl(){
        for (int i = 2000; i < 4000; i++) {
            StringBuilder urlStr = new StringBuilder();
            for (int j = 2014; j < 2021; j++) {
                urlStr.append("https://static-data.eol.cn/www/2.0/schoolprovinceindex/");
                urlStr.append(String.valueOf(j));
                urlStr.append("/");
                urlStr.append(String.valueOf(i));
                urlStr.append("/41/1/1.json");
                pathList.add(urlStr.toString());
                urlStr.delete(0,urlStr.length());
            }
        }
    }

    private static JSON getValue(String key, JSONObject obj){
        Set<Map.Entry<String, Object>> entries = obj.entrySet();
        Iterator<Map.Entry<String, Object>> iterator = entries.iterator();
        Object value = null;
        while (iterator.hasNext()){
            Map.Entry<String, Object> next = iterator.next();
            if(key.equals(next.getKey())){
                value = next.getValue();
            }
        }
//        System.out.println(value);
        return (JSON) value;
    }
}
