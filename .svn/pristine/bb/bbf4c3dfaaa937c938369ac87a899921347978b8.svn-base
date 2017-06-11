/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.sierac.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * CRUD操作Entity
 * 
 * @author mjj
 * @version 2017-02-13
 */
public class ApiRdcOutData extends DataEntity<ApiRdcOutData> {

    /**
     * serialVersionUID:(用一句话描述这个变量表示什么).
     */
    private static final long serialVersionUID = 1L;

    private String header_id;//

    private String detail_id;//

    private String ctn_code;// 箱码

    private String product_id;// 产品id

    private String batch_code;// 批号

    private String scan_code;// 扫描码

    private String scan_by;// 扫描者

    private Date scan_time;// 扫描时间

    private Integer qty;// 数量

    private Integer is_local_int;// 是否本地

    public String getHeader_id() {
        return header_id;
    }

    public void setHeader_id(String header_id) {
        this.header_id = header_id;
    }

    public String getDetail_id() {
        return detail_id;
    }

    public void setDetail_id(String detail_id) {
        this.detail_id = detail_id;
    }

    public String getCtn_code() {
        return ctn_code;
    }

    public void setCtn_code(String ctn_code) {
        this.ctn_code = ctn_code;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getBatch_code() {
        return batch_code;
    }

    public void setBatch_code(String batch_code) {
        this.batch_code = batch_code;
    }

    public String getScan_code() {
        return scan_code;
    }

    public void setScan_code(String scan_code) {
        this.scan_code = scan_code;
    }

    public String getScan_by() {
        return scan_by;
    }

    public void setScan_by(String scan_by) {
        this.scan_by = scan_by;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getScan_time() {
        return scan_time;
    }

    public void setScan_time(Date scan_time) {
        this.scan_time = scan_time;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Integer getIs_local_int() {
        return is_local_int;
    }

    public void setIs_local_int(Integer is_local_int) {
        this.is_local_int = is_local_int;
    }

    @Override
    public String toString() {
        return "ApiRdcOutData [header_id=" + header_id + ", detail_id=" + detail_id + ", ctn_code=" + ctn_code
                + ", product_id=" + product_id + ", batch_code=" + batch_code + ", scan_code=" + scan_code
                + ", scan_by=" + scan_by + ", scan_time=" + scan_time + ", qty=" + qty + ", is_local_int="
                + is_local_int + "]";
    }

}