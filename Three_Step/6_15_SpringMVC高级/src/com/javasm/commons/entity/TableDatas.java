package com.javasm.commons.entity;

//分页表格实体对象
public class TableDatas {
    private Object list;
    private Integer pageNum;
    private Integer pageSize;
    private Integer total;

    public TableDatas() {
    }

    public TableDatas(Object list, Integer pageNum, Integer pageSize, Integer total) {
        this.list = list;
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.total = total;
    }

    public Object getList() {
        return list;
    }

    public void setList(Object list) {
        this.list = list;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
