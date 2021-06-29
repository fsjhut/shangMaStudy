package com.javasm.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.javasm.dao.EnrollDao;
import com.javasm.dao.SpecialDao;
import com.javasm.entity.Enroll;
import net.sf.json.JsonConfig;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.*;

/**
 * @author SunHang
 * @className: GetSpecialize
 * @description:
 * @createTime 2021/6/27 22:16
 */
public class GetSpecialize2 {
    private static ArrayList<String> errorList = new ArrayList<>();
    private static ArrayList<String> pathList = new ArrayList<>();

    public static ArrayList<String> getErrorList() {
        return errorList;
    }

    public static ArrayList<String> getPathList() {
        return pathList;
    }

    public static boolean mainFunc(String path) {
        GetSpecialize2 getSpecialize = new GetSpecialize2();
        // 先生成所有的url列表
//        getSpecialize.generateAllUrl(min,max);
//        HashMap<String,Object> score_year = new HashMap<>();

        JSONObject jsonData = getSpecialize.getData(path);

        if (jsonData == null || jsonData.isEmpty()) {
            errorList.add(path);
            return false;
        }
        if ("\"\"".equals(jsonData.toString()) || jsonData.toString().length() == 2) {
            errorList.add(path);
            return false;
        }
//        System.out.println(jsonData.toJSONString());

        JSON getItem = getSpecialize.getValue("item", jsonData);
        List list = net.sf.json.JSONArray.toList(
                net.sf.json.JSONArray.fromObject(getItem), new HashMap<String, Object>(), new JsonConfig());
        String substring = path.substring(54, 58);
//            score_year.put("score_year",substring);
        // 将list中的所有数据都加一个字段
        ListIterator listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            HashMap next = (HashMap<String, Object>) listIterator.next();
            next.put("score_year", substring);
        }
        try {
            getSpecialize.addBatchToSql(list);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }
//        getSpecialize.errorList.forEach(System.out::println);


//    private List<String> getAllSchoolId(){
//        SqlSessionFactory factory = SSF.getFactory();
//        SqlSession sqlSession = factory.openSession();
//        EnrollDao mapper = sqlSession.getMapper(EnrollDao.class);
//        return mapper.selectAllSchoolIds();
//    }

    private JSONObject getData(String path) {
        RestTemplate restTemplate = new RestTemplate();
        String context = restTemplate.getForObject(path, String.class);
        if ("\"\"".equals(context) || context.length() == 2) {
            errorList.add(path);
            return null;
        }
//        System.out.println(context.length());
        JSONObject jsonAll = JSON.parseObject(context);
        return (JSONObject) getValue("data", jsonAll);
    }

    private void addBatchToSql(List<HashMap<String, Object>> mapList) throws IOException {
        SqlSessionFactory factory = SSF.getFactory();
        SqlSession sqlSession = factory.openSession();
        SpecialDao mapper = sqlSession.getMapper(SpecialDao.class);
        // 将查询到的map传入
        mapper.batchAddObjs(mapList);
        sqlSession.commit();
        sqlSession.close();
        System.out.println("-------------");
    }

    private void addToSql(Enroll enroll) {
        SqlSessionFactory factory = SSF.getFactory();
        SqlSession sqlSession = factory.openSession();
        EnrollDao mapper = sqlSession.getMapper(EnrollDao.class);
        int i = mapper.addObj(enroll);
        if (i != 1) {
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

    public static void generateAllUrl(int min, int max) {
        for (int i = min; i < max; i++) {
            StringBuilder urlStr = new StringBuilder();
            for (int j = 2014; j < 2021; j++) {
                for (int k = 1; k < 10; k++) {
//                    "https://static-data.eol.cn/www/2.0/schoolspecialindex/2018/487/41/1/8/1.json"
                    urlStr.append("https://static-data.eol.cn/www/2.0/schoolspecialindex/");
                    urlStr.append(String.valueOf(j));
                    urlStr.append("/");
                    urlStr.append(String.valueOf(i));
                    urlStr.append("/41/1/8/");
                    urlStr.append(String.valueOf(k));
                    urlStr.append(".json");
                    pathList.add(urlStr.toString());
                    urlStr.delete(0, urlStr.length());
                }
            }
        }
    }

    private JSON getValue(String key, JSONObject obj) {
        Set<Map.Entry<String, Object>> entries = obj.entrySet();
        Iterator<Map.Entry<String, Object>> iterator = entries.iterator();
        Object value = null;
        while (iterator.hasNext()) {
            Map.Entry<String, Object> next = iterator.next();
            if (key.equals(next.getKey())) {
                value = next.getValue();
            }
        }
//        System.out.println(value);
        return (JSON) value;
    }
}
