package javasm.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @className: UserContorller
 * @description:   
 * @author SunHang
 * @createTime 2021/7/20 10:26
 */
@RestController
public class UserController {

    @GetMapping("/query/{uid}")
    public String getUserInfo(@PathVariable Integer uid){
        return "我是nacos的用户模块：" + uid;
    }
}
