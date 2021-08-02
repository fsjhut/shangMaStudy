package com.javasm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @className: OrderController
 * @description:   
 * @author SunHang
 * @createTime 2021/7/19 18:04
 */
@RestController
public class OrderController {
    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    RestTemplate restTemplate;
    @RequestMapping("query/{uid}")
    public String queryOrder(@PathVariable Integer uid){
        List<ServiceInstance> instances = discoveryClient.getInstances("consul-user");
        String userInfo = "";
        String orderInfo = "这个是订单的信息:" + uid;
        if(instances!=null&&instances.size()>0){
            ServiceInstance serviceInstance = instances.get(0);
            String host = serviceInstance.getHost();
            int port = serviceInstance.getPort();
            String url = "http://"+host+":"+port+"/query/"+uid;
            String forObject = restTemplate.getForObject(url, String.class);
            userInfo = "用户接口返回的内容：" + forObject;
        }
        return userInfo+ "\n" + orderInfo;

    }
}
