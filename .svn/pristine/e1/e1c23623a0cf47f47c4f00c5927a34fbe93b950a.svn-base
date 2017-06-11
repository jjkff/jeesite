/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.sierac.entity;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * CRUD操作Entity
 * 
 * @author mjj
 * @version 2017-02-13
 */
public class ApiRdcOutHeader extends DataEntity<ApiRdcOutHeader> {

    /**
     * serialVersionUID:(用一句话描述这个变量表示什么).
     */
    private static final long serialVersionUID = 1L;

    private String id;// 主键

    private String code;// 单据号码

    private Integer bill_type;// 单据类型

    private Integer bill_status;// 单据状态

    private String send_id;// 单据状态

    private String send_name;// 单据状态

    private String receive_id;// 单据状态

    private String upload_id;// 收货方名称

    private Date upload_time;// 上传时间

    private String submit_by;// 提交者

    private String scan_by;// 扫描者

    private String product_id;//

    private List<ApiRdcOutDetail> detail_list;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getBill_status() {
        return bill_status;
    }

    public void setBill_status(Integer bill_status) {
        this.bill_status = bill_status;
    }

    public String getUpload_id() {
        return upload_id;
    }

    public void setUpload_id(String upload_id) {
        this.upload_id = upload_id;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getUpload_time() {
        return upload_time;
    }

    public void setUpload_time(Date upload_time) {
        this.upload_time = upload_time;
    }

    public String getSubmit_by() {
        return submit_by;
    }

    public void setSubmit_by(String submit_by) {
        this.submit_by = submit_by;
    }

    public String getScan_by() {
        return scan_by;
    }

    public void setScan_by(String scan_by) {
        this.scan_by = scan_by;
    }

    public List<ApiRdcOutDetail> getDetail_list() {
        return detail_list;
    }

    public void setDetail_list(List<ApiRdcOutDetail> detail_list) {
        this.detail_list = detail_list;
    }

    public Integer getBill_type() {
        return bill_type;
    }

    public void setBill_type(Integer bill_type) {
        this.bill_type = bill_type;
    }

    public String getSend_id() {
        return send_id;
    }

    public void setSend_id(String send_id) {
        this.send_id = send_id;
    }

    public String getSend_name() {
        return send_name;
    }

    public void setSend_name(String send_name) {
        this.send_name = send_name;
    }

    public String getReceive_id() {
        return receive_id;
    }

    public void setReceive_id(String receive_id) {
        this.receive_id = receive_id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

}