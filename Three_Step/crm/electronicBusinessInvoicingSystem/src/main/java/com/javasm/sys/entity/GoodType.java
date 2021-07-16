package com.javasm.sys.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.javasm.commons.base.BaseEntity;

import java.io.Serializable;
import java.util.List;

/**
 * (GoodType)实体类
 *
 * @author makejava
 * @since 2021-06-30 16:21:43
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GoodType extends BaseEntity implements Serializable {
    private static final long serialVersionUID = -21383990212143060L;
    /**
     * 商品类型id
     */
    private Integer tid;
    /**
     * 商品类型名称
     */
    private String typeName;
    /**
     * 品牌类型描述
     */
    private String typeDesc;

    private Integer pid;

    private List<GoodType> children;

    public List<GoodType> getChildren() {
        return children;
    }

    public void setChildren(List<GoodType> children) {
        this.children = children;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeDesc() {
        return typeDesc;
    }

    public void setTypeDesc(String typeDesc) {
        this.typeDesc = typeDesc;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    @Override
    public String toString() {
        return "GoodType{" +
                "tid=" + tid +
                ", typeName='" + typeName + '\'' +
                ", typeDesc='" + typeDesc + '\'' +
                ", pid=" + pid +
                ", children=" + children +
                '}';
    }

}
