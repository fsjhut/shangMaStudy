package com.javasm.sys.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.javasm.commons.base.BaseEntity;

/**
 * (CrmArea)实体类
 *
 * @author makejava
 * @since 2021-07-05 17:54:17
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CrmArea extends BaseEntity implements Serializable {
    private static final long serialVersionUID = -78074284612347977L;

    private Integer id;

    private String name;

    private Integer pid;

    private List<CrmArea> list=new ArrayList<>();

    public CrmArea(Integer id, String name, Integer pid, List<CrmArea> list) {
        this.id = id;
        this.name = name;
        this.pid = pid;
        this.list = list;
    }

    @Override
    public String toString() {
        return "CrmArea{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pid=" + pid +
                ", list=" + list +
                '}';
    }

    public CrmArea() {
    }


    public CrmArea(Integer id, Integer pid) {
        this.id = id;
        this.pid = pid;
    }

    public List<CrmArea> getList() {
        return list;
    }

    public void setList(List<CrmArea> list) {
        this.list = list;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

}
