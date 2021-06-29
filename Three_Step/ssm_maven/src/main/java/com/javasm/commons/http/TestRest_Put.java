package com.javasm.commons.http;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @author SunHang
 * @className: TestRest_Put
 * @description:
 * @createTime 2021/6/24 21:47
 */
public class TestRest_Put {

    public static void main(String[] args) {
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJ1bmFtZSI6ImFkbWluIiwiaWF0IjoxNjI0NTE3OTE1LCJleHAiOjE2MjcxMDk5MTV9.mtqMYvsd7VVtn5cELuBHT71NN1-rkrVAAO6vIJimGNc";
        RestTemplate t = new RestTemplate();
        String path = "http://localhost:8080/sysuser";
        Map<String, Object> map = new HashMap<>();
        map.put("uid",21);
        map.put("upwd","11111");
        //t.put(path,map);//简单的put请求(不需要添加请求头,不需要得到响应数据)

        //复杂请求,需要添加请求头,需要获取返回数据
        HttpHeaders headers = new HttpHeaders();
        headers.add("token",token);
        HttpEntity reqEntity = new HttpEntity(map, headers);
        ResponseEntity<String> exchange = t.exchange(path, HttpMethod.PUT, reqEntity, String.class);
        System.out.println(exchange.getBody());
    }

}
