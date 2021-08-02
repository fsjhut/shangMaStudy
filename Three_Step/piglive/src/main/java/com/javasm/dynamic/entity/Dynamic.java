package com.javasm.dynamic.entity;

import java.io.Serializable;
import java.util.List;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * (Dynamic)实体类
 *
 * @author makejava
 * @since 2021-07-18 14:52:59
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@TableName("Dynamic")
public class Dynamic implements Serializable {
    private static final long serialVersionUID = -77467043829384293L;
    /**
     * 动态的id
     */
    @TableId(type = IdType.AUTO)
    private Integer dynamicId;

    private Integer uid;
    /**
     * 发布动态的内容
     */
    private String dynamicText;
    /**
     * 发布动态的时间
     */
    private String createTime;
    /**
     * 1:系统通知消息(加守护)2：系统通知消息(主播升级)，3：主播发布的文字动态 4：主播发布的带照片动态
     */
    private Integer type;
    /**
     * 1.手机发布 2：电脑发布
     */
    private Integer equipment;
    /**
     * 喜欢的数量
     */
    private Integer likeNum;
    /**
     * 评论的数量
     */
    private Integer commentNum;
    /**
     * 1：草稿 2：审核中 3：审核通过 4: 审核未通过
     */
    private Integer dynamicStatus;
    @TableField(exist = false)
    private String nickName;
    @TableField(exist = false)
    private List<String> imgList;
    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public List<String> getImgList() {
        return imgList;
    }

    public void setImgList(List<String> imgList) {
        this.imgList = imgList;
    }

    @Override
    public String toString() {
        return "Dynamic{" +
                "dynamicId=" + dynamicId +
                ", uid=" + uid +
                ", dynamicText='" + dynamicText + '\'' +
                ", createTime='" + createTime + '\'' +
                ", type=" + type +
                ", equipment=" + equipment +
                ", likeNum=" + likeNum +
                ", commentNum=" + commentNum +
                ", dynamicStatus=" + dynamicStatus +
                '}';
    }

    public Integer getDynamicId() {
        return dynamicId;
    }

    public void setDynamicId(Integer dynamicId) {
        this.dynamicId = dynamicId;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getDynamicText() {
        return dynamicText;
    }

    public void setDynamicText(String dynamicText) {
        this.dynamicText = dynamicText;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getEquipment() {
        return equipment;
    }

    public void setEquipment(Integer equipment) {
        this.equipment = equipment;
    }

    public Integer getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(Integer likeNum) {
        this.likeNum = likeNum;
    }

    public Integer getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(Integer commentNum) {
        this.commentNum = commentNum;
    }

    public Integer getDynamicStatus() {
        return dynamicStatus;
    }

    public void setDynamicStatus(Integer dynamicStatus) {
        this.dynamicStatus = dynamicStatus;
    }

}
