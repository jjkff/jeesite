/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.sierac.entity;

import java.util.List;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * CRUD操作Entity
 * 
 * @author mjj
 * @version 2017-02-13
 */
public class ApiRdcOutDetail extends DataEntity<ApiRdcOutDetail> {

    /**
     * serialVersionUID:(用一句话描述这个变量表示什么).
     */
    private static final long serialVersionUID = 1L;

    private String id;// 主键

    private String header_id;

    private String order_code;// 单据号码

    private String product_id;// 产品id

    private String batch_code;// 批号

    private Integer expect_qty_pcs;// 计划出库单品数

    private Integer actual_qty_pcs;// 实际出库单品数

    private List<ApiRdcOutData> data_list;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHeader_id() {
        return header_id;
    }

    public void setHeader_id(String header_id) {
        this.header_id = header_id;
    }

    public String getOrder_code() {
        return order_code;
    }

    public void setOrder_code(String order_code) {
        this.order_code = order_code;
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

    public Integer getActual_qty_pcs() {
        return actual_qty_pcs;
    }

    public void setActual_qty_pcs(Integer actual_qty_pcs) {
        this.actual_qty_pcs = actual_qty_pcs;
    }

    public List<ApiRdcOutData> getData_list() {
        return data_list;
    }

    public void setData_list(List<ApiRdcOutData> data_list) {
        this.data_list = data_list;
    }

    public Integer getExpect_qty_pcs() {
        return expect_qty_pcs;
    }

    public void setExpect_qty_pcs(Integer expect_qty_pcs) {
        this.expect_qty_pcs = expect_qty_pcs;
    }

}