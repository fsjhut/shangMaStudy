package com.javasm.dynamic.service;

import com.javasm.dynamic.entity.UserComment;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.transaction.annotation.Transactional;

public interface UserCommentService extends IService<UserComment> {

    // 返回某个主播的某个动态下的所有评论
    // 返回的是一个评论的列表，列表中的每个评论都是树状结构
    // 该评论的状态必须是通过审核的
    // 连表(用户表)查询出用户的昵称
    List<UserComment> selectListDetail(UserComment obj);

    @Transactional
    Boolean insertComment(UserComment obj);
}
