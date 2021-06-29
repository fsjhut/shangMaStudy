package com.javasm.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.javasm.dao.EnrollDao;
import com.javasm.dao.SchoolplanDao;
import com.javasm.entity.Enroll;


import net.sf.json.JsonConfig;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * @className: GetSchoolPlan
 * @description:   
 * @author SunHang
 * @createTime 2021/6/27 11:40
 */
public class GetSchoolPlan {
    private static ArrayList<String> errorList = new ArrayList<>();
    private static ArrayList<String> pathList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        // 先生成所有的url列表
        generateAllUrl(getAllSchoolId());
        for (String path : pathList) {
            JSONObject jsonData = getData(path);
            if(jsonData==null||jsonData.isEmpty()){
                continue;
            }
//            System.out.println(jsonData.toJSONString());

            JSON getItem = getValue("item",jsonData);
//            System.out.println(getItem.toJSONString());
//            List<HashMap<String,Object>> item = new ArrayList<>();
//            item = (List<HashMap<String,Object>>)JSONArray.parse(getItem.toJSONString());
//            System.out.println(item);
//            JSONArray objects = JSONArray.parseArray(getItem.toJSONString());
            List list = net.sf.json.JSONArray.toList(
                    net.sf.json.JSONArray.fromObject(getItem),new HashMap<String,Object>(),new JsonConfig());
//            System.out.println(list);
//            for (Object obj : list) {
//                addToSql((HashMap<String,Object>)obj);
//            }
            addBatchToSql(list);
//            for(HashMap<String,Object> mapList : item){
//                if(mapList==null||jsonData.isEmpty()){
//                    continue;
//                }
//                addToSql(mapList);
//            }
//            addBatchToSql(item);
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

    private static void addToSql(HashMap<String,Object> map){
        SqlSessionFactory factory = SSF.getFactory();
        SqlSession sqlSession = factory.openSession();
        SchoolplanDao mapper = sqlSession.getMapper(SchoolplanDao.class);
        // 将查询到的map传入
        int i = mapper.addObj(map);
        if(i!=1){
            errorList.add((String) map.get("school_id"));
            return;
        }
        sqlSession.commit();
        sqlSession.close();
    }

    private static void addBatchToSql(List<HashMap<String,Object>> mapList) throws IOException {
        SqlSessionFactory factory ;
        InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
        factory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = factory.openSession();
        SchoolplanDao mapper = sqlSession.getMapper(SchoolplanDao.class);
        // 将查询到的map传入
        mapper.batchAddObjs(mapList);
//        if(i!=1){
//            errorList.add((String) map.get("school_id"));
//            return;
//        }
        sqlSession.commit();
    }

//    private static Enroll setSchool(JSONObject jsonData){
//        Enroll school = new Enroll();
//
//        return school;
//    }

    private static List<String> getAllSchoolId(){
        SqlSessionFactory factory = SSF.getFactory();
        SqlSession sqlSession = factory.openSession();
        EnrollDao mapper = sqlSession.getMapper(EnrollDao.class);
        return mapper.selectAllSchoolIds();
    }

    private static void generateAllUrl(List<String> schools){
        // 查询所有有本科2批招生计划的学校id，将查询到的id加入list中，进行遍历
        for (String schoolId : schools) {
            StringBuilder urlStr = new StringBuilder();
            // 只查询5页的数据，一般学校在河南的二批招生专业小于50个。
            // 当查询到的数据为"" 时，结束这个学校的查询
            for (int j = 1; j < 10; j++) {
//                "https://static-data.eol.cn/www/2.0/schoolplanindex/2021/853/41/1/8/1.json"
                urlStr.append("https://static-data.eol.cn/www/2.0/schoolplanindex/2021/");
                urlStr.append(schoolId);
                urlStr.append("/41/1/8/");
                urlStr.append(String.valueOf(j));
                urlStr.append(".json");
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
