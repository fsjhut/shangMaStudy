package com.javasm.commons.http;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @author:巴晓磊
 * @className:TestRestTemplate_put
 * @description:
 * @date:2021/6/24 22:03
 * @version:0.1
 * @since:1.8
 */
public class TestRestTemplate_put {
    public static void main(String[] args) {
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJ1bmFtZSI6ImptIiwiaWF0IjoxNjI0NTQ1NDYzLCJleHAiOjE2MjcxMzc0NjN9.2jBMFrzDOqyijSIfZUfurxWeEEOOGsuRCwltRrYtuMg";

        RestTemplate t = new RestTemplate();
        String path = "http://localhost:8080/sysuser";
        Map<String, Object> map = new HashMap<>();
        map.put("uid", "100101");
        map.put("upwd", "12345");
        t.put(path,map);//简单的put请求，不需要添加请求头，不需要得到相应数据

        HttpHeaders headers = new HttpHeaders();
        headers.add("token", token);
        HttpEntity he = new HttpEntity(map,headers);

        ResponseEntity<String> exchange = t.exchange(path, HttpMethod.PUT, he, String.class);
        System.out.println(exchange.getBody());


    }
}
