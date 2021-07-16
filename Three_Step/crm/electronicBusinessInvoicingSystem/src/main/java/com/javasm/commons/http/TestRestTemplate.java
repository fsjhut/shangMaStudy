package com.javasm.commons.http;



import com.javasm.commons.entity.AxiosResult;
import org.springframework.web.client.RestTemplate;

public class TestRestTemplate {
    public static void main(String[] args) {
        RestTemplate t = new RestTemplate();
        //1、普通get请求，参数k=v
//        String path= "http://api.tianapi.com/txapi/tianqi/index?key=db3d22eebbff236d1b3b424ea12c3dd6&city=郑州市";
//        RestTemplate t = new RestTemplate();
//        String result = t.getForObject(path, String.class);
//        System.out.println(result);


//        String path = "http://localhost:8080/sysuser/valicode/123";
//        String forObject = t.getForObject(path, String.class);
//        System.out.println(forObject);


        //2、通过fastjosn组件，手工把JSON字符串转目标对象
//        String path = "http://localhost:8080/sysuser/valicode/123";
//        String forObject = t.getForObject(path, String.class);
//        System.out.println(forObject);
//        AxiosResult axiosResult = JSON.parseObject(forObject, AxiosResult.class);
//        System.out.println(axiosResult);
        String path = "http://localhost:8080/sysuser/valicode/123";


        //3、底层自动把JSON字符串转化为目标对象
        AxiosResult forObject = t.getForObject(path, AxiosResult.class);
        System.out.println(forObject);


    }
}
