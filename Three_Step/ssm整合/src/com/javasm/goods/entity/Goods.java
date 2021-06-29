package com.javasm.goods.entity;
/**
 * @className: Goods
 * @description:   
 * @author SunHang
 * @createTime 2021/6/16 19:05
 */
public class Goods {
    private Integer gid;
    private String gname;
    private Integer gnum;
    private Double gprice;
    private String createTime;


    @Override
    public String toString() {
        return "Goods{" +
                "gid=" + gid +
                ", gname='" + gname + '\'' +
                ", gnum=" + gnum +
                ", gprice=" + gprice +
                ", createTime='" + createTime + '\'' +
                '}';
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public Integer getGnum() {
        return gnum;
    }

    public void setGnum(Integer gnum) {
        this.gnum = gnum;
    }

    public Double getGprice() {
        return gprice;
    }

    public void setGprice(Double gprice) {
        this.gprice = gprice;
    }
}
