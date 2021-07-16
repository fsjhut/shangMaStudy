package com.javasm.sys.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.javasm.commons.base.BaseEntity;

import java.io.Serializable;
import java.util.Objects;

/**
 * (Log)实体类
 *
 * @author makejava
 * @since 2021-07-01 15:42:26
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Log extends BaseEntity implements Serializable {
    private static final long serialVersionUID = -85842479499305975L;
    /**
     * 日志id
     */
    private Integer id;
    /**
     * 访问用户
     */
    private String accessuser;
    /**
     * 访问模块
     */
    private String accessmodule;
    /**
     * 访问类型
     */
    private String accesstype;
    /**
     * 访问内容
     */
    private String operatingcontents;
    /**
     * 操作时间
     */
    private String operatingTime;

    /**
     * 操作范围时间
     */

    private String operatingEndTime;
    /**
     * 访问的ip地址
     */
    private String ipAddress;
    /**
     * 端口号
     */
    private String port;
    /**
     * 操作结果
     */
    private String operatingresult;

    /**
     * 存放临时部门名称
     */
    private String deptName;

    /**
     * 用户真实名称
     */
    private String realUserName;

    public String getRealUserName() {
        return realUserName;
    }

    public void setRealUserName(String realUserName) {
        this.realUserName = realUserName;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getOperatingEndTime() {
        return operatingEndTime;
    }

    public void setOperatingEndTime(String operatingEndTime) {
        this.operatingEndTime = operatingEndTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccessuser() {
        return accessuser;
    }

    public void setAccessuser(String accessuser) {
        this.accessuser = accessuser;
    }

    public String getAccessmodule() {
        return accessmodule;
    }

    public void setAccessmodule(String accessmodule) {
        this.accessmodule = accessmodule;
    }

    public String getAccesstype() {
        return accesstype;
    }

    public void setAccesstype(String accesstype) {
        this.accesstype = accesstype;
    }

    public String getOperatingcontents() {
        return operatingcontents;
    }

    public void setOperatingcontents(String operatingcontents) {
        this.operatingcontents = operatingcontents;
    }

    public String getOperatingTime() {
        return operatingTime;
    }

    public void setOperatingTime(String operatingTime) {
        this.operatingTime = operatingTime;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getOperatingresult() {
        return operatingresult;
    }

    public void setOperatingresult(String operatingresult) {
        this.operatingresult = operatingresult;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Log log = (Log) o;
        return Objects.equals(id, log.id) &&
                Objects.equals(accessuser, log.accessuser) &&
                Objects.equals(accessmodule, log.accessmodule) &&
                Objects.equals(accesstype, log.accesstype) &&
                Objects.equals(operatingcontents, log.operatingcontents) &&
                Objects.equals(operatingTime, log.operatingTime) &&
                Objects.equals(operatingEndTime, log.operatingEndTime) &&
                Objects.equals(ipAddress, log.ipAddress) &&
                Objects.equals(port, log.port) &&
                Objects.equals(operatingresult, log.operatingresult);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, accessuser, accessmodule, accesstype, operatingcontents, operatingTime, operatingEndTime, ipAddress, port, operatingresult);
    }

    @Override
    public String toString() {
        return "Log{" +
                "id=" + id +
                ", accessuser='" + accessuser + '\'' +
                ", accessmodule='" + accessmodule + '\'' +
                ", accesstype='" + accesstype + '\'' +
                ", operatingcontents='" + operatingcontents + '\'' +
                ", operatingTime='" + operatingTime + '\'' +
                ", operatingEndTime='" + operatingEndTime + '\'' +
                ", ipAddress='" + ipAddress + '\'' +
                ", port='" + port + '\'' +
                ", operatingresult='" + operatingresult + '\'' +
                ", deptName='" + deptName + '\'' +
                ", realUserName='" + realUserName + '\'' +
                '}';
    }
}
