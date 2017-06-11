/**
 * Project Name:JeeSite
 * File Name:QueryReport.java
 * Package Name:com.thinkgem.jeesite.sierac.entity
 * Date:2017年2月15日下午6:35:42
 * Copyright (c) 2017, bluemobi All Rights Reserved.
 *
 */

package com.thinkgem.jeesite.sierac.entity;

import com.thinkgem.jeesite.common.persistence.DataEntity;
import com.thinkgem.jeesite.common.utils.excel.annotation.ExcelField;

/**
 * Description: <br/>
 * Date: 2017年2月15日 下午6:35:42 <br/>
 * 
 * @author majiaJun
 * @version
 * @see
 */
public class QueryReport extends DataEntity<QueryReport> {
    private static final long serialVersionUID = 1L;

    private String qId;// 查询报表id

    private String qCode;// 编码

    private String pCode;// 产品代码

    private String pName;// 产品名称

    private String batchCode;// 批号

    private Integer qQty;// 查询次数

    // private String code; // 单品码

    public String getqId() {
        return qId;
    }

    public void setqId(String qId) {
        this.qId = qId;
    }

    @ExcelField(title = "编码", align = 2, sort = 1)
    public String getqCode() {
        return qCode;
    }

    public void setqCode(String qCode) {
        this.qCode = qCode;
    }

    @ExcelField(title = "产品代码", align = 2, sort = 2)
    public String getpCode() {
        return pCode;
    }

    public void setpCode(String pCode) {
        this.pCode = pCode;
    }

    @ExcelField(title = "产品名称", align = 2, sort = 3)
    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    @ExcelField(title = "批号", align = 2, sort = 4)
    public String getBatchCode() {
        return batchCode;
    }

    public void setBatchCode(String batchCode) {
        this.batchCode = batchCode;
    }

    @ExcelField(title = "查询次数", align = 2, sort = 5)
    public Integer getqQty() {
        return qQty;
    }

    public void setqQty(Integer qQty) {
        this.qQty = qQty;
    }

    @Override
    public String toString() {
        return "QueryReport [qCode=" + qCode + ", pCode=" + pCode + ", pName=" + pName + ", batchCode=" + batchCode
                + ", qQty=" + qQty + "]";
    }

}
