package com.javasm.util;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.javasm.dao.SchoolDao;
import com.javasm.entity.School;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.web.client.RestTemplate;

import java.util.*;

/**
 * @className: GetMessage
 * @description:   
 * @author SunHang
 * @createTime 2021/6/26 15:34
 */
public class GetMessage {
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
            School school = setSchool(jsonData);
            addToSql(school);
        }
    }


    private static JSONObject getData(String path){
        RestTemplate restTemplate = new RestTemplate();
        String context = restTemplate.getForObject(path, String.class);
        if ("\"\"".equals(context) ||context.length()==2){
            return null;
        }
//        System.out.println(context.length());
        JSONObject jsonAll = JSONUtil.parseObj(context);
        return  (JSONObject)getValue("data", jsonAll);
    }

    private static void addToSql(School school){
        SqlSessionFactory factory = SSF.getFactory();
        SqlSession sqlSession = factory.openSession();
        SchoolDao mapper = sqlSession.getMapper(SchoolDao.class);
        int i = mapper.addObj(school);
        if(i!=1){
            errorList.add(school.getName());
            return;
        }
        sqlSession.commit();
        sqlSession.close();
    }

    private static School setSchool(JSONObject jsonData){
        School school = new School();
        school.setSchoolId(jsonData.getStr("school_id"));
        school.setName(jsonData.getStr("name"));
        school.setF211(jsonData.getStr("f211"));
        school.setF985(jsonData.getStr("f985"));
        school.setCodeEnroll(jsonData.getStr("code_enroll"));
        school.setBelong(jsonData.getStr("belong"));
        school.setCityId(jsonData.getStr("city_id"));
        school.setSchoolNatureName(jsonData.getStr("school_nature_name"));
        school.setCityName(jsonData.getStr("city_name"));
        school.setXiaoyuan(jsonData.getStr("xiaoyuan"));
        school.setAddress(jsonData.getStr("address"));
        school.setSchoolSite(jsonData.getStr("school_site"));
        school.setContent(jsonData.getStr("content"));
        return school;
    }

    private static void generateAllUrl(){
        for (int i = 2000; i < 4000; i++) {
            StringBuilder urlStr = new StringBuilder();
            urlStr.append("https://static-data.eol.cn/www/2.0/school/");
            urlStr.append(String.valueOf(i));
            urlStr.append("/info.json");
            pathList.add(urlStr.toString());
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
        return JSONUtil.parse(value);
    }
}
