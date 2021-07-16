package com.javasm;
/**
 * @className: Node
 * @description:   
 * @author SunHang
 * @createTime 2021/7/6 19:31
 */
public class Node {
    private String cityName;
    private Integer cityCode;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    private Integer pid;
    private Node node;


    @Override
    public String toString() {
        return "Node{" +
                "cityName='" + cityName + '\'' +
                ", cityCode=" + cityCode +
                ", pid=" + pid +
                ", node=" + node +
                '}';
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Integer getCityCode() {
        return cityCode;
    }

    public void setCityCode(Integer cityCode) {
        this.cityCode = cityCode;
    }

    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
    }
}
