/**
 * Project Name:JeeSite
 * File Name:QueryReport.java
 * Package Name:com.thinkgem.jeesite.sierac.entity
 * Date:2017年2月15日下午6:35:42
 * Copyright (c) 2017, bluemobi All Rights Reserved.
 *
 */

package com.thinkgem.jeesite.sierac.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * Description: <br/>
 * Date: 2017年2月15日 下午6:35:42 <br/>
 * 
 * @author majiaJun
 * @version
 * @see
 */
@JsonInclude(JsonInclude.Include.ALWAYS)
public class QueryFake extends DataEntity<QueryFake> {
    private static final long serialVersionUID = 1L;

    private String cCode;// 编码

    private String pCode;// 产品代码

    private String pName;// 产品名称

    private String spec; // 规格

    private String shelfLife;// 产品保质期

    private String batchCode;// 批号

    private Date packDate;// 包装日期

    private String orderCode;// 单据号

    private Date scanBeginTimeDate;// 扫描时间

    private Date sumbitDate;// 单据日期

    private String sendName;// 发货仓名称

    private String receiveName;// 客户姓名

    private String receivePhone;// 客户手机号

    private String receiveAddress;// 地址

    private Integer qQty;// 查询次数

    private Date validPeriod; // 有效期

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public String getcCode() {
        return cCode;
    }

    public void setcCode(String cCode) {
        this.cCode = cCode;
    }

    public String getpCode() {
        return pCode;
    }

    public void setpCode(String pCode) {
        this.pCode = pCode;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getBatchCode() {
        return batchCode;
    }

    public void setBatchCode(String batchCode) {
        this.batchCode = batchCode;
    }

    @JsonFormat(pattern = "yyyy-MM-dd")
    public Date getPackDate() {
        return packDate;
    }

    public void setPackDate(Date packDate) {
        this.packDate = packDate;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getScanBeginTimeDate() {
        return scanBeginTimeDate;
    }

    public void setScanBeginTimeDate(Date scanBeginTimeDate) {
        this.scanBeginTimeDate = scanBeginTimeDate;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getSumbitDate() {
        return sumbitDate;
    }

    public void setSumbitDate(Date sumbitDate) {
        this.sumbitDate = sumbitDate;
    }

    public String getSendName() {
        return sendName;
    }

    public void setSendName(String sendName) {
        this.sendName = sendName;
    }

    public String getReceiveName() {
        return receiveName;
    }

    public void setReceiveName(String receiveName) {
        this.receiveName = receiveName;
    }

    public String getReceivePhone() {
        return receivePhone;
    }

    public void setReceivePhone(String receivePhone) {
        this.receivePhone = receivePhone;
    }

    public String getReceiveAddress() {
        return receiveAddress;
    }

    public void setReceiveAddress(String receiveAddress) {
        this.receiveAddress = receiveAddress;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getShelfLife() {
        return shelfLife;
    }

    public void setShelfLife(String shelfLife) {
        this.shelfLife = shelfLife;
    }

    public Integer getqQty() {
        return qQty;
    }

    public void setqQty(Integer qQty) {
        this.qQty = qQty;
    }

    @JsonFormat(pattern = "yyyy-MM-dd")
    public Date getValidPeriod() {
        return validPeriod;
    }

    public void setValidPeriod(Date validPeriod) {
        this.validPeriod = validPeriod;
    }

    @Override
    public String toString() {
        return "QueryFake [cCode=" + cCode + ", pCode=" + pCode + ", pName=" + pName + ", batchCode=" + batchCode
                + ", packDate=" + packDate + ", scanBeginTimeDate=" + scanBeginTimeDate + ", sumbitDate=" + sumbitDate
                + ", sendName=" + sendName + ", receiveName=" + receiveName + ", receivePhone=" + receivePhone
                + ", receiveAddress=" + receiveAddress + "]";
    }

}
