package com.javasm.commons.http;

import com.javasm.commons.entity.AxiosResult;
import com.javasm.sys.entity.Sysuser;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @className: TestRest_Post
 * @description:   
 * @author SunHang
 * @createTime 2021/6/24 21:31
 */
public class TestRest_Post {

    public static void main(String[] args) {
        RestTemplate t = new RestTemplate();
        String path = "http://localhost:8080/sysuser/loginByPhone/2323242444/162859";
        Sysuser sysuser = new Sysuser();
        sysuser.setUname("admin");
        sysuser.setUpwd("11111");
//        String s = t.postForObject(path, sysuser, String.class);
//        AxiosResult axiosResult = t.postForObject(path, sysuser, AxiosResult.class);
//        System.out.println(axiosResult);
        ResponseEntity<String> stringResponseEntity = t.postForEntity(path, sysuser, String.class);
        HttpHeaders headers = stringResponseEntity.getHeaders();
        List<String> list = headers.get("token");
        System.out.println(list.get(0));
        String body = stringResponseEntity.getBody();
        System.out.println(body);
    }
}
