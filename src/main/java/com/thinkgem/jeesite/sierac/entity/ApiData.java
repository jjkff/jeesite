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
public class ApiData extends DataEntity<ApiData> {

    /**
     * serialVersionUID:(用一句话描述这个变量表示什么).
     */
    private static final long serialVersionUID = 1L;

    private String uploadId;

    private Integer successQty;

    public String getUploadId() {
        return uploadId;
    }

    public void setUploadId(String uploadId) {
        this.uploadId = uploadId;
    }

    public Integer getSuccessQty() {
        return successQty;
    }

    public void setSuccessQty(Integer successQty) {
        this.successQty = successQty;
    }

    @Override
    public String toString() {
        return "ApiData [uploadId=" + uploadId + ", successQty=" + successQty + "]";
    }

}