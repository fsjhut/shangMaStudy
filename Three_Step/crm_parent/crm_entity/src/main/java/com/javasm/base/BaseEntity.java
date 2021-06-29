package com.javasm.base;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @className: BaseEntity
 * @description:   
 * @author SunHang
 * @createTime 2021/6/17 20:51
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseEntity {
    private String createTime;
    private String updateTime;
    private String updateBy;
    private String createBy;

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
}
