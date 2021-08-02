package com.javasm.dynamic.dao;

import com.javasm.dynamic.entity.Dynamic;
import com.javasm.dynamic.entity.UserComment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

public interface DynamicDao extends BaseMapper<Dynamic> {
    public List<Dynamic> selectListDetail(Dynamic obj);
}
