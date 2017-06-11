/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.sierac.entity;

import java.util.Date;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 生产数据查询Entity
 * 
 * @author wgc
 * @version 2017-02-14
 */
public class CodeData extends DataEntity<CodeData> {

   

    private static final long serialVersionUID = 1L;

    private String code; // 单品码

    private String eptCode; // 单品码加密

    private String ctnCode; // 箱码

    private String pltCode; // 托码

    private String lineCode; // 生产线号

    private String batchCode; // 生产批号

    private Date packDate; // 包装时间

    private Date validPeriod; // 有效期

    private Date printDate; // 打印时间

    private String workerCode; // 工人代码

    private String teamCode; // 班组代码

    private String active; // 激活

    private String originId; // origin_id

    private String currentLocation; // 当前位置

    private String isTracked; // 可追溯

    private String factoryId; // factory_id

    private String productId; // product_id

    private String pcode; // 产品编码

    private String name;

    private String outHeaderId;

    private String scan_code;

    public String getPcode() {
        return pcode;
    }

    public void setPcode(String pcode) {
        this.pcode = pcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CodeData() {
        super();
    }

    public CodeData(String id) {
        super(id);
    }

    @Length(min = 0, max = 64, message = "单品码长度必须介于 0 和 64 之间")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Length(min = 0, max = 64, message = "单品码加密长度必须介于 0 和 64 之间")
    public String getEptCode() {
        return eptCode;
    }

    public void setEptCode(String eptCode) {
        this.eptCode = eptCode;
    }

    @Length(min = 0, max = 64, message = "箱码长度必须介于 0 和 64 之间")
    public String getCtnCode() {
        return ctnCode;
    }

    public void setCtnCode(String ctnCode) {
        this.ctnCode = ctnCode;
    }

    @Length(min = 0, max = 64, message = "托码长度必须介于 0 和 64 之间")
    public String getPltCode() {
        return pltCode;
    }

    public void setPltCode(String pltCode) {
        this.pltCode = pltCode;
    }

    @Length(min = 0, max = 64, message = "生产线号长度必须介于 0 和 64 之间")
    public String getLineCode() {
        return lineCode;
    }

    public void setLineCode(String lineCode) {
        this.lineCode = lineCode;
    }

    @Length(min = 0, max = 64, message = "生产批号长度必须介于 0 和 64 之间")
    public String getBatchCode() {
        return batchCode;
    }

    public void setBatchCode(String batchCode) {
        this.batchCode = batchCode;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getPackDate() {
        return packDate;
    }

    public void setPackDate(Date packDate) {
        this.packDate = packDate;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getValidPeriod() {
        return validPeriod;
    }

    public void setValidPeriod(Date validPeriod) {
        this.validPeriod = validPeriod;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getPrintDate() {
        return printDate;
    }

    public void setPrintDate(Date printDate) {
        this.printDate = printDate;
    }

    @Length(min = 0, max = 64, message = "工人代码长度必须介于 0 和 64 之间")
    public String getWorkerCode() {
        return workerCode;
    }

    public void setWorkerCode(String workerCode) {
        this.workerCode = workerCode;
    }

    @Length(min = 0, max = 64, message = "班组代码长度必须介于 0 和 64 之间")
    public String getTeamCode() {
        return teamCode;
    }

    public void setTeamCode(String teamCode) {
        this.teamCode = teamCode;
    }

    @Length(min = 0, max = 1, message = "激活长度必须介于 0 和 1 之间")
    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    @Length(min = 0, max = 64, message = "origin_id长度必须介于 0 和 64 之间")
    public String getOriginId() {
        return originId;
    }

    public void setOriginId(String originId) {
        this.originId = originId;
    }

    @Length(min = 0, max = 255, message = "当前位置长度必须介于 0 和 255 之间")
    public String getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
    }

    @Length(min = 0, max = 1, message = "可追溯长度必须介于 0 和 1 之间")
    public String getIsTracked() {
        return isTracked;
    }

    public void setIsTracked(String isTracked) {
        this.isTracked = isTracked;
    }

    @Length(min = 0, max = 64, message = "factory_id长度必须介于 0 和 64 之间")
    public String getFactoryId() {
        return factoryId;
    }

    public void setFactoryId(String factoryId) {
        this.factoryId = factoryId;
    }

    @Length(min = 1, max = 64, message = "product_id长度必须介于 1 和 64 之间")
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getOutHeaderId() {
        return outHeaderId;
    }

    public void setOutHeaderId(String outHeaderId) {
        this.outHeaderId = outHeaderId;
    }

    public String getScan_code() {
        return scan_code;
    }

    public void setScan_code(String scan_code) {
        this.scan_code = scan_code;
    }
    @Override
    public String toString() {
        return "CodeData [code=" + code + ", eptCode=" + eptCode + ", ctnCode=" + ctnCode + ", pltCode=" + pltCode
                + ", lineCode=" + lineCode + ", batchCode=" + batchCode + ", packDate=" + packDate + ", validPeriod="
                + validPeriod + ", printDate=" + printDate + ", workerCode=" + workerCode + ", teamCode=" + teamCode
                + ", active=" + active + ", originId=" + originId + ", currentLocation=" + currentLocation
                + ", isTracked=" + isTracked + ", factoryId=" + factoryId + ", productId=" + productId + ", pcode="
                + pcode + ", name=" + name + ", outHeaderId=" + outHeaderId + ", scan_code=" + scan_code + "]";
    }

}