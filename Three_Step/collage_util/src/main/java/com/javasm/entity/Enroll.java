package com.javasm.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * (Enroll)实体类
 *
 * @author makejava
 * @since 2021-06-26 19:45:37
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Enroll  implements Serializable {
    private static final long serialVersionUID = 305490522002446146L;

    private String schoolId;

    private String batch;

    private String zslx;

    private String xclevel;

    private String max;

    private String minSection;

    private String min;

    private String average;

    private String filing;

    private String firstKm;

    private String localBatchName;

    private String zslxName;

    private String xclevelName;

    private String proscore;

    private String year;


    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getZslx() {
        return zslx;
    }

    public void setZslx(String zslx) {
        this.zslx = zslx;
    }

    public String getXclevel() {
        return xclevel;
    }

    public void setXclevel(String xclevel) {
        this.xclevel = xclevel;
    }

    public String getMax() {
        return max;
    }

    public void setMax(String max) {
        this.max = max;
    }

    public String getMinSection() {
        return minSection;
    }

    public void setMinSection(String minSection) {
        this.minSection = minSection;
    }

    public String getMin() {
        return min;
    }

    public void setMin(String min) {
        this.min = min;
    }

    public String getAverage() {
        return average;
    }

    public void setAverage(String average) {
        this.average = average;
    }

    public String getFiling() {
        return filing;
    }

    public void setFiling(String filing) {
        this.filing = filing;
    }

    public String getFirstKm() {
        return firstKm;
    }

    public void setFirstKm(String firstKm) {
        this.firstKm = firstKm;
    }

    public String getLocalBatchName() {
        return localBatchName;
    }

    public void setLocalBatchName(String localBatchName) {
        this.localBatchName = localBatchName;
    }

    public String getZslxName() {
        return zslxName;
    }

    public void setZslxName(String zslxName) {
        this.zslxName = zslxName;
    }

    public String getXclevelName() {
        return xclevelName;
    }

    public void setXclevelName(String xclevelName) {
        this.xclevelName = xclevelName;
    }

    public String getProscore() {
        return proscore;
    }

    public void setProscore(String proscore) {
        this.proscore = proscore;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Enroll{" +
                "schoolId='" + schoolId + '\'' +
                ", batch='" + batch + '\'' +
                ", zslx='" + zslx + '\'' +
                ", xclevel='" + xclevel + '\'' +
                ", max='" + max + '\'' +
                ", minSection='" + minSection + '\'' +
                ", min='" + min + '\'' +
                ", average='" + average + '\'' +
                ", filing='" + filing + '\'' +
                ", firstKm='" + firstKm + '\'' +
                ", localBatchName='" + localBatchName + '\'' +
                ", zslxName='" + zslxName + '\'' +
                ", xclevelName='" + xclevelName + '\'' +
                ", proscore='" + proscore + '\'' +
                ", year='" + year + '\'' +
                '}';
    }
}
