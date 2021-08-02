package com.javasm.dynamic.handler;

import com.javasm.dynamic.entity.UserComment;
import com.javasm.dynamic.service.UserCommentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import com.javasm.commons.base.BaseHandler;
import com.javasm.commons.entity.AxiosResult;

import java.util.Arrays;
import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

@RestController
@RequestMapping("userComment")
public class UserCommentHandler extends BaseHandler {

    @Resource
    private UserCommentService userCommentService;

    @GetMapping("{id}")
    public AxiosResult selectById(@PathVariable("id") String id) {
        UserComment obj = this.userCommentService.getById(id);
        return suc(obj);
    }

    @GetMapping("list")
    public AxiosResult selectList(UserComment obj) {
//        startPage();
//        List<UserComment> list = this.userCommentService.list(new QueryWrapper<>(obj));
        List<UserComment> userComments = this.userCommentService.selectListDetail(obj);
        return suc(userComments);
    }

    @PostMapping
    public AxiosResult add(@RequestBody UserComment obj) {
        boolean r = this.userCommentService.insertComment(obj);
        return result(r);
    }

    @PutMapping
    public AxiosResult update(@RequestBody UserComment obj) {
        boolean r = this.userCommentService.updateById(obj);
        return result(r);
    }

    @DeleteMapping("{ids}")
    public AxiosResult delById(@PathVariable("ids") String ids) {
        String[] split = ids.split(",");
        boolean r = this.userCommentService.removeByIds(Arrays.asList(split));
        return result(r);
    }
}
