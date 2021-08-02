package com.javasm.dynamic.entity;

import java.io.Serializable;
import java.util.List;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * (UserComment)实体类
 *
 * @author makejava
 * @since 2021-07-18 15:33:49
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@TableName("user_comment")
public class UserComment implements Serializable {
    private static final long serialVersionUID = 655911130671236744L;
    /**
     * 评论id
     */
    @TableId(type = IdType.AUTO)
    private Integer commentId;
    /**
     * 评论内容
     */
    private String commentContext;
    /**
     * 评论时间
     */
    private String createTime;
    /**
     * 评论的设备 1：手机 2：电脑
     */
    private Integer commentEquip;
    /**
     * 用户的id
     */
    private Integer userId;
    /**
     * 主播的id
     */
    private Integer userInfoId;
    /**
     * 主播动态的id
     */
    private Integer dynamicId;
    /**
     * 该评论的父id，若评论的是主播则，pid=0
     */
    private Integer commentPid;
    /**
     * 用户评论的审核状态 0：未审核 1：审核通过 2：审核不通过
     */
    private Integer commentStatus;

    private String backup2;

    @TableField(exist = false)
    private String userName;
    @TableField(exist = false)
    private List<UserComment> childComment;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<UserComment> getChildComment() {
        return childComment;
    }

    public void setChildComment(List<UserComment> childComment) {
        this.childComment = childComment;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public String getCommentContext() {
        return commentContext;
    }

    public void setCommentContext(String commentContext) {
        this.commentContext = commentContext;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Integer getCommentEquip() {
        return commentEquip;
    }

    public void setCommentEquip(Integer commentEquip) {
        this.commentEquip = commentEquip;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getUserInfoId() {
        return userInfoId;
    }

    public void setUserInfoId(Integer userInfoId) {
        this.userInfoId = userInfoId;
    }

    public Integer getDynamicId() {
        return dynamicId;
    }

    public void setDynamicId(Integer dynamicId) {
        this.dynamicId = dynamicId;
    }

    public Integer getCommentPid() {
        return commentPid;
    }

    public void setCommentPid(Integer commentPid) {
        this.commentPid = commentPid;
    }

    public Integer getCommentStatus() {
        return commentStatus;
    }

    public void setCommentStatus(Integer commentStatus) {
        this.commentStatus = commentStatus;
    }

    public String getBackup2() {
        return backup2;
    }

    public void setBackup2(String backup2) {
        this.backup2 = backup2;
    }

}
