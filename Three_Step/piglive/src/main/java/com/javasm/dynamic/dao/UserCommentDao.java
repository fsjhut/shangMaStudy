package com.javasm.dynamic.dao;

import com.javasm.dynamic.entity.UserComment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

public interface UserCommentDao extends BaseMapper<UserComment> {
    public List<UserComment> selectListDetail(UserComment obj);
}
