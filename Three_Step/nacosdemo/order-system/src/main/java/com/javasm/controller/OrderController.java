package com.javasm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @className: OrderController
 * @description:   
 * @author SunHang
 * @createTime 2021/7/20 10:27
 */
@RestController
public class OrderController {
    @Autowired
    private DiscoveryClient client;
    @Autowired
    private RestTemplate template;
    @GetMapping("query/{uid}")
    public String getOrderInfo(@PathVariable Integer uid){
        List<ServiceInstance> instances = client.getInstances("user-nacos");
        String info = "我是订单表，订单信息是："+uid;
        if(instances!=null&&instances.size()>0){
            ServiceInstance serviceInstance = instances.get(0);
            String host = serviceInstance.getHost();
            int port = serviceInstance.getPort();
            String path = "http://"+host+":"+port+"/query/"+uid;
            String forObject = template.getForObject(path, String.class);
            info = info + forObject;
        }
        return info;
    }
}
