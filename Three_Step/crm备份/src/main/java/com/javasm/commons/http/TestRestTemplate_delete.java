package com.bjpowernode.commons.http;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


public class TestRestTemplate_delete {
    public static void main(String[] args) {
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJ1bmFtZSI6ImptIiwiaWF0IjoxNjI0NTQ1NDYzLCJleHAiOjE2MjcxMzc0NjN9.2jBMFrzDOqyijSIfZUfurxWeEEOOGsuRCwltRrYtuMg";

        RestTemplate t = new RestTemplate();
        String path = "http://localhost:8080/sysuser/{0}";
        //t.delete("11111111,22222222");
        HttpHeaders headers = new HttpHeaders();
        headers.add("token", token);
        HttpEntity e = new HttpEntity(headers);
        ResponseEntity<String> exchange = t.exchange(path, HttpMethod.DELETE, e, String.class,"111,222");
        System.out.println(exchange.getBody());
    }
}
