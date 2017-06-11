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
import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * Description: <br/>
 * Date: 2017年2月15日 下午6:35:42 <br/>
 * 
 * @author majiaJun
 * @version
 * @see
 */
public class QueryReportDetail extends DataEntity<QueryReportDetail> {
    private static final long serialVersionUID = 1L;

    private String qrId;// 查询报表id

    private Date queryTime;// 查询时间

    private String queryIp;// 查询ip

    private String location;// 所在地

    private String queryReportId;// queryReportId

    public String getQrId() {
        return qrId;
    }

    public void setQrId(String qrId) {
        this.qrId = qrId;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getQueryTime() {
        return queryTime;
    }

    public void setQueryTime(Date queryTime) {
        this.queryTime = queryTime;
    }

    public String getQueryIp() {
        return queryIp;
    }

    public void setQueryIp(String queryIp) {
        this.queryIp = queryIp;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getQueryReportId() {
        return queryReportId;
    }

    public void setQueryReportId(String queryReportId) {
        this.queryReportId = queryReportId;
    }

    @Override
    public String toString() {
        return "QueryReportDetail [qrId=" + qrId + ", queryTime=" + queryTime + ", queryIp=" + queryIp + ", location="
                + location + ", queryReportId=" + queryReportId + "]";
    }

}
