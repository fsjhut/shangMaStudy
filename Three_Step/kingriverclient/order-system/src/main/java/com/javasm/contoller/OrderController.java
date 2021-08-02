package com.javasm.contoller;

import com.javasm.client.UserClient;
import com.javasm.entity.UserInfo;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author SunHang
 * @className: OrderController
 * @description:
 * @createTime 2021/7/19 14:59
 */
@RestController()
@RequestMapping("order")
public class OrderController {
    // 想要在订单信息中调用user中的服务
    @Resource
    private EurekaClient client;

    @Resource
    private UserClient userClient;
//    @GetMapping("/query/{uid}")
//    public String getOrder(@PathVariable Integer uid) {
//        String orderInfo = "这个是订单的信息:" + uid;
//        // 去注册中心获取这个名字的应用
//        Application application = client.getApplication("user-system");
//        List<InstanceInfo> instances = application.getInstances();
//        String userInfo = "";
//        if (instances != null && instances.size() > 0) {
//            InstanceInfo instanceInfo = instances.get(0);
//            // 获取目标的ip地址
//            String hostName = instanceInfo.getHostName();
//            // 获取目标的端口号
//            int port = instanceInfo.getPort();
//            // 进行拼接 http://127.0.0.1:8085/qeury/1
//            String url = "http://" + hostName + ":" + port + "/user/query/" + uid;
//            // 远程接口调用
//            RestTemplate restTemplate = new RestTemplate();
//            String forObject = restTemplate.getForObject(url, String.class);
//            userInfo = "用户接口返回的内容：" + forObject;
//        }
//        return userInfo + "\n" + orderInfo;
//    }
    @GetMapping("/query/{uid}")
    public String getOrder2(@PathVariable Integer uid){
        String userInfo = userClient.getUserInfo(uid);
        return userInfo + "----order-----";
    }
    @GetMapping("/select/{uid}")
    public Map<String,Object> getOrderUserInfo(@PathVariable Integer uid){
        UserInfo userInfo = userClient.selectUserById(uid);
        HashMap<String, Object> map = new HashMap<>();
        map.put("UserInfo",userInfo);
        map.put("orderInfo","----order-----");
        return map;
    }
}
