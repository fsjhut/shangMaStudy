package com.javasm.client;

import com.javasm.entity.UserInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @className: UserClient
 * @description:   
 * @author SunHang
 * @createTime 2021/7/20 11:28
 */
@FeignClient(name = "user-system")
public interface UserClient {

    @GetMapping("/user/query/{id}")
    String getUserInfo(@PathVariable("id") Integer id);
    @GetMapping("/user/select/{id}")
    UserInfo selectUserById(@PathVariable("id") Integer id);
}
