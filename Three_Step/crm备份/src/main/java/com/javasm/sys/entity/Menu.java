package com.javasm.sys.entity;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.javasm.commons.base.BaseEntity;

/**
 * (Menu)实体类
 *
 * @author makejava
 * @since 2021-06-30 14:44:53
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Menu extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 401536855059364986L;
    /**
     * 菜单id
     */
    private Integer menuId;
    /**
     * 菜单名称
     */
    private String menuName;
    /**
     * 上级菜单
     */
    private Integer parentId;
    private String menuUrl;

    private List<Menu> submenu;

    public List<Menu> getSubmenu() {
        return submenu;
    }

    public void setSubmenu(List<Menu> submenu) {
        this.submenu = submenu;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "menuId=" + menuId +
                ", menuName='" + menuName + '\'' +
                ", parentId=" + parentId +
                ", submenu=" + submenu +
                '}';
    }
}
