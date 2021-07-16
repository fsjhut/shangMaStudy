package com.javasm.commons.bean;

/**
 * @className:ReturnPermission
 * @author:NO
 * @date:2021/7/310:35
 * @version:0.1
 * @since:1.8
 **/
public class ReturnPermission {
    private Integer menuId;
    private String menuName;
    private String menuDesc;
    private Integer menuState;
    private String menuHandle;
    private Integer parentId;
    private Integer rid;
    private String rname;

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
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

    public String getMenuDesc() {
        return menuDesc;
    }

    public void setMenuDesc(String menuDesc) {
        this.menuDesc = menuDesc;
    }

    public Integer getMenuState() {
        return menuState;
    }

    public void setMenuState(Integer menuState) {
        this.menuState = menuState;
    }

    public String getMenuHandle() {
        return menuHandle;
    }

    public void setMenuHandle(String menuHandle) {
        this.menuHandle = menuHandle;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }
}
