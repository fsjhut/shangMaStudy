package com.javasm.commons.http;


import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public class TestRestTemplate_post {
    public static void main(String[] args) {
        RestTemplate t = new RestTemplate();

        String path = "http://localhost:8080/sysuser/login";

//        Sysuser u = new Sysuser();
//        u.setUname("jm");
//        u.setUpwd("123");
//        String s = t.postForObject(path, u, String.class);
//        //AxiosResult s = t.postForObject(path, u, AxiosResult.class);
//        System.out.println(s);


        Map<String, String> map = new HashMap<>();
        map.put("uname", "jm");
        map.put("upwd", "123");
        ResponseEntity<String> re = t.postForEntity(path, map, String.class);
        String body = re.getBody();
        HttpHeaders headers = re.getHeaders();
        System.out.println("响应体:" + body);
        System.out.println("响应头:"+headers.get("token").get(0));
        String s = t.postForObject(path, re, String.class);
        System.out.println(s);

    }
}
