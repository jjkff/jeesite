/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.sierac.entity;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * CRUD操作Entity
 * 
 * @author mjj
 * @version 2017-02-13
 */
// @JsonInclude(JsonInclude.Include.ALWAYS)
public class ApiWarehouseOutScanCheck extends DataEntity<ApiWarehouseOutScanCheck> {

    /**
     * serialVersionUID:(用一句话描述这个变量表示什么).
     */
    private static final long serialVersionUID = 1L;

    private String cDe;

    private String orderCode;

    private String ctnCode;

    private String batchCode;

    private String productId;

    private String productName;

    public String getcDe() {
        return cDe;
    }

    public void setcDe(String cDe) {
        this.cDe = cDe;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getCtnCode() {
        return ctnCode;
    }

    public void setCtnCode(String ctnCode) {
        this.ctnCode = ctnCode;
    }

    public String getBatchCode() {
        return batchCode;
    }

    public void setBatchCode(String batchCode) {
        this.batchCode = batchCode;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

}