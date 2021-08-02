package com.javasm.dynamic.service.impl;

import com.javasm.commons.entity.S;
import com.javasm.commons.exception.MvcException;
import com.javasm.dynamic.dao.DynamicDao;
import com.javasm.dynamic.entity.Dynamic;
import com.javasm.dynamic.entity.UserComment;
import com.javasm.dynamic.dao.UserCommentDao;
import com.javasm.dynamic.service.UserCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;

@Service("userCommentService")
public class UserCommentServiceImpl extends ServiceImpl<UserCommentDao, UserComment> implements UserCommentService {

    @Resource
    private UserCommentDao dao;
    @Resource
    private DynamicDao dynamicDao;
    @Override
    public List<UserComment> selectListDetail(UserComment obj) {
        List<UserComment> userComments = dao.selectListDetail(obj);
        // 根据pid，进行封装，
        List<UserComment> userComments1 = selectRootComment(userComments);
        return userComments1;
    }

    @Transactional
    @Override
    public Boolean insertComment(UserComment obj){
        int insert = dao.insert(obj);
        // 新增一个评论，则动态的评论数量加1
        Integer dynamicId = obj.getDynamicId();
        Dynamic dynamic = dynamicDao.selectById(dynamicId);
        dynamic.setCommentNum(dynamic.getCommentNum()+1);
        int i = dynamicDao.updateById(dynamic);
        if(insert!=1||i!=1){
            throw new MvcException(S.ERROR);
        }
        return true;
    }
    private List<UserComment> selectRootComment(List<UserComment> userComments){
        List<UserComment> comments = new ArrayList<>();
        for (UserComment userComment : userComments) {
            // 0: 代表是根节点
            if(userComment.getCommentPid()==0){
                generateTree(userComments,userComment);
                comments.add(userComment);
            }
        }
        return comments;
    }
    private UserComment generateTree(List<UserComment> userComments, UserComment comment){
        Integer commentId = comment.getCommentId();
        List<UserComment> comments = new ArrayList<>();
        for (UserComment userComment : userComments) {
            if(userComment.getCommentPid().equals(commentId)){
                comments.add(userComment);
            }
        }
        if(comments.size() == 0){
            return null;
        }else{
            comment.setChildComment(comments);
//            comments.forEach((userComment)-{generateTree(userComments,userComment)});
            comments.forEach(comment1 -> generateTree(userComments,comment1));
        }
        return comment;
    }
}
