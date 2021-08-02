package com.javasm.dynamic.service;

import com.javasm.dynamic.entity.Dynamic;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.javasm.dynamic.entity.UserComment;

public interface DynamicService extends IService<Dynamic> {

    // 返回某个主播的全部动态
    // 该动态的状态必须是通过审核的
    // 需要和主播表进行连表查询出主播的昵称
    // 需要和图片表连表查询出每个动态下的所有图片
    List<Dynamic> selectListDetail(Dynamic obj);

    boolean insertDynamic(Dynamic obj);
}
