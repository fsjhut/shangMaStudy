package com.javasm.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * (School)实体类
 *
 * @author makejava
 * @since 2021-06-26 16:55:07
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class School implements Serializable {
    private static final long serialVersionUID = 318705520134068374L;

    private String schoolId;

    private String name;

    private String f985;

    private String f211;

    private String codeEnroll;

    private String belong;

    private String cityId;

    private String schoolNatureName;

    private String cityName;

    private String address;

    private String schoolSite;

    private String xiaoyuan;

    private String content;


    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getF985() {
        return f985;
    }

    public void setF985(String f985) {
        this.f985 = f985;
    }

    public String getF211() {
        return f211;
    }

    public void setF211(String f211) {
        this.f211 = f211;
    }

    public String getCodeEnroll() {
        return codeEnroll;
    }

    public void setCodeEnroll(String codeEnroll) {
        this.codeEnroll = codeEnroll;
    }

    public String getBelong() {
        return belong;
    }

    public void setBelong(String belong) {
        this.belong = belong;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getSchoolNatureName() {
        return schoolNatureName;
    }

    public void setSchoolNatureName(String schoolNatureName) {
        this.schoolNatureName = schoolNatureName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSchoolSite() {
        return schoolSite;
    }

    public void setSchoolSite(String schoolSite) {
        this.schoolSite = schoolSite;
    }

    public String getXiaoyuan() {
        return xiaoyuan;
    }

    public void setXiaoyuan(String xiaoyuan) {
        this.xiaoyuan = xiaoyuan;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "School{" +
                "schoolId='" + schoolId + '\'' +
                ", name='" + name + '\'' +
                ", f985='" + f985 + '\'' +
                ", f211='" + f211 + '\'' +
                ", codeEnroll='" + codeEnroll + '\'' +
                ", belong='" + belong + '\'' +
                ", cityId='" + cityId + '\'' +
                ", schoolNatureName='" + schoolNatureName + '\'' +
                ", cityName='" + cityName + '\'' +
                ", address='" + address + '\'' +
                ", schoolSite='" + schoolSite + '\'' +
                ", xiaoyuan='" + xiaoyuan + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
