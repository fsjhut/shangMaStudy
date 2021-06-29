package com.javasm.commons.http;

import com.alibaba.fastjson.JSON;
import com.javasm.commons.entity.AxiosResult;
import org.springframework.web.client.RestTemplate;

/**
 * @className: TestRestTemplate
 * @description:   
 * @author SunHang
 * @createTime 2021/6/24 21:15
 */
public class TestRestTemplate {
    public static void main(String[] args) {
//        String path = "http://api.tianapi.com/txapi/tianqi/index?key=db3d22eebbff236d1b3b424ea12c3dd6&city=郑州市";
        RestTemplate t = new RestTemplate();
//        String forObject = t.getForObject(path, String.class);
//        System.out.println(forObject);

//        AxiosResult forObject = t.getForObject(path, AxiosResult.class);
//        System.out.println(JSON.toJSONString(forObject));
        String path = "http://localhost:8080/sysuser/valicode/{0}";
        String forObject = t.getForObject(path, String.class, "2323242444");
        System.out.println(forObject);
        AxiosResult axiosResult = JSON.parseObject(forObject, AxiosResult.class);
        System.out.println(axiosResult);

    }
}
