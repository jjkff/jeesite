/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.sierac.entity;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.thinkgem.jeesite.common.persistence.DataEntity;
import com.thinkgem.jeesite.common.utils.excel.annotation.ExcelField;

/**
 * CRUD操作Entity
 * 
 * @author mjj
 * @version 2017-02-13
 */
@JsonInclude(JsonInclude.Include.ALWAYS)
public class RdcOutHeader extends DataEntity<RdcOutHeader> {

    private static final long serialVersionUID = 1L;

    private String code; // 业务代码

    private String orderCode; // 出库单号

    private String outTypeCode; // 出库类型代码

    private String uploadId; // 上传id

    private Date uploadTime; // 上传日期

    private String scanBy; // 扫描者

    private Date scanBeginTime; // 扫描开始时间

    private Integer billType; // 单据类型

    private String billStatus; // 单据状态

    private String submitBy; // 提交者

    private Date submitDate; // 出库单日期

    private String sendId; // 发货仓id

    private String sendCode; // 发货仓代码

    private String sendName; // 发货仓名称

    private String receiveId; // 收货人id

    private String receiveName; // 客户姓名

    private String receivePhone; // 客户手机号

    private String receiveAddress; // 客户地址

    private Integer expectPcsQty;// 计划数量

    private Integer actualPcsQty;// 实际数量

    private Date beginSubmitDate; // 开始 出库单日期

    private Date endSubmitDate; // 结束 出库单日期

    /**
     * api附加
     */

    private String headerId;

    private String productId;

    private String pCode;// 产品代码

    private String pSku;// 产品sku

    private String pName;// 产品名称

    private String batchCode;// 批号

    public RdcOutHeader() {
        super();
    }

    public RdcOutHeader(String id) {
        super(id);
    }

    @Length(min = 0, max = 64, message = "业务代码长度必须介于 0 和 64 之间")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @JsonIgnore
    @ExcelField(title = "出库单号", align = 2, sort = 1)
    @NotNull(message = "出库单号不能为空")
    @Length(min = 3, max = 10, message = "出库单号长度必须介于 3 和 10 之间")
    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    @JsonIgnore
    @Length(min = 0, max = 64, message = "出库类型代码长度必须介于 0 和 64 之间")
    public String getOutTypeCode() {
        return outTypeCode;
    }

    public void setOutTypeCode(String outTypeCode) {
        this.outTypeCode = outTypeCode;
    }

    @JsonIgnore
    @Length(min = 0, max = 64, message = "上传id长度必须介于 0 和 64 之间")
    public String getUploadId() {
        return uploadId;
    }

    public void setUploadId(String uploadId) {
        this.uploadId = uploadId;
    }

    @NotNull(message = "上传日期不能为空")
    // @Pattern(regexp =
    // "(\\d{2}|\\d{4})(?:\\-)?([0]{1}\\d{1}|[1]{1}[0-2]{1})(?:\\-)?([0-2]{1}\\d{1}|[3]{1}[0-1]{1})(?:\\s)?([0-1]{1}\\d{1}|[2]{1}[0-3]{1})(?::)?([0-5]{1}\\d{1})(?::)?([0-5]{1}\\d{1})",
    // message = "请正确填写上传日期")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ExcelField(title = "上传日期", align = 2, sort = 10)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }

    @Length(min = 0, max = 64, message = "扫描者长度必须介于 0 和 64 之间")
    public String getScanBy() {
        return scanBy;
    }

    public void setScanBy(String scanBy) {
        this.scanBy = scanBy;
    }

    @JsonIgnore
    @NotNull(message = "扫描开始时间不能为空")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ExcelField(title = "扫描开始时间", align = 2, sort = 9)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getScanBeginTime() {
        return scanBeginTime;
    }

    public void setScanBeginTime(Date scanBeginTime) {
        this.scanBeginTime = scanBeginTime;
    }

    public Integer getBillType() {
        return billType;
    }

    public void setBillType(Integer billType) {
        this.billType = billType;
    }

    @NotNull(message = "单据状态不能为空")
    @Pattern(regexp = "^\\d$", message = "请正确填写单据状态")
    @ExcelField(title = "单据状态", align = 2, sort = 7)
    public String getBillStatus() {
        return billStatus;
    }

    public void setBillStatus(String billStatus) {
        this.billStatus = billStatus;
    }

    @Length(min = 0, max = 255, message = "提交者长度必须介于 0 和 255 之间")
    public String getSubmitBy() {
        return submitBy;
    }

    public void setSubmitBy(String submitBy) {
        this.submitBy = submitBy;
    }

    @JsonIgnore
    @NotNull(message = "出库日期不能为空")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ExcelField(title = "出库日期", align = 2, sort = 8)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getSubmitDate() {
        return submitDate;
    }

    public void setSubmitDate(Date submitDate) {
        this.submitDate = submitDate;
    }

    @Length(min = 0, max = 64, message = "发货仓id长度必须介于 0 和 64 之间")
    public String getSendId() {
        return sendId;
    }

    public void setSendId(String sendId) {
        this.sendId = sendId;
    }

    @NotNull(message = "发货仓代码不能为空")
    @ExcelField(title = "发货仓代码", align = 2, sort = 2)
    @Length(min = 3, max = 10, message = "发货仓代码长度必须介于 3 和 10 之间")
    public String getSendCode() {
        return sendCode;
    }

    public void setSendCode(String sendCode) {
        this.sendCode = sendCode;
    }

    @JsonIgnore
    @NotNull(message = "发货仓名称不能为空")
    @ExcelField(title = "发货仓名称", align = 2, sort = 3)
    @Length(min = 3, max = 10, message = "发货仓名称长度必须介于 0 和 255 之间")
    public String getSendName() {
        return sendName;
    }

    public void setSendName(String sendName) {
        this.sendName = sendName;
    }

    @Length(min = 0, max = 64, message = "收货人id长度必须介于 0 和 64 之间")
    public String getReceiveId() {
        return receiveId;
    }

    public void setReceiveId(String receiveId) {
        this.receiveId = receiveId;
    }

    @ExcelField(title = "客户姓名", align = 2, sort = 4)
    @NotNull(message = "客户姓名不能为空")
    @Pattern(regexp = "^[A-Za-z0-9\u4e00-\u9fa5]+$", message = "请正确填写客户姓名")
    public String getReceiveName() {
        return receiveName;
    }

    public void setReceiveName(String receiveName) {
        this.receiveName = receiveName;
    }

    @JsonIgnore
    @NotNull(message = "客户手机号不能为空")
    @Pattern(regexp = "^1[34578]\\d{9}$", message = "请正确填写客户手机号")
    @ExcelField(title = "客户手机号", align = 2, sort = 5)
    public String getReceivePhone() {
        return receivePhone;
    }

    public void setReceivePhone(String receivePhone) {
        this.receivePhone = receivePhone;
    }

    @JsonIgnore
    @NotNull(message = "客户地址不能为空")
    @ExcelField(title = "客户地址", align = 2, sort = 6)
    public String getReceiveAddress() {
        return receiveAddress;
    }

    public void setReceiveAddress(String receiveAddress) {
        this.receiveAddress = receiveAddress;
    }

    @JsonIgnore
    public Date getBeginSubmitDate() {
        return beginSubmitDate;
    }

    public void setBeginSubmitDate(Date beginSubmitDate) {
        this.beginSubmitDate = beginSubmitDate;
    }

    @JsonIgnore
    public Date getEndSubmitDate() {
        return endSubmitDate;
    }

    public void setEndSubmitDate(Date endSubmitDate) {
        this.endSubmitDate = endSubmitDate;
    }

    /**
     * api附加
     */

    public String getHeaderId() {
        return headerId;
    }

    public void setHeaderId(String headerId) {
        this.headerId = headerId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getpCode() {
        return pCode;
    }

    public void setpCode(String pCode) {
        this.pCode = pCode;
    }

    public String getpSku() {
        return pSku;
    }

    public void setpSku(String pSku) {
        this.pSku = pSku;
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

    public Integer getExpectPcsQty() {
        return expectPcsQty;
    }

    public void setExpectPcsQty(Integer expectPcsQty) {
        this.expectPcsQty = expectPcsQty;
    }

    public void setActualPcsQty(Integer actualPcsQty) {
        this.actualPcsQty = actualPcsQty;
    }

    public Integer getActualPcsQty() {
        return actualPcsQty;
    }

    @Override
    public String toString() {
        return "RdcOutHeader [code=" + code + ", orderCode=" + orderCode + ", outTypeCode=" + outTypeCode
                + ", uploadId=" + uploadId + ", uploadTime=" + uploadTime + ", scanBy=" + scanBy + ", scanBeginTime="
                + scanBeginTime + ", billType=" + billType + ", billStatus=" + billStatus + ", submitBy=" + submitBy
                + ", submitDate=" + submitDate + ", sendId=" + sendId + ", sendCode=" + sendCode + ", sendName="
                + sendName + ", receiveId=" + receiveId + ", receiveName=" + receiveName + ", receivePhone="
                + receivePhone + ", receiveAddress=" + receiveAddress + ", expectPcsQty=" + expectPcsQty
                + ", actualPcsQty=" + actualPcsQty + ", beginSubmitDate=" + beginSubmitDate + ", endSubmitDate="
                + endSubmitDate + ", headerId=" + headerId + ", productId=" + productId + ", pCode=" + pCode
                + ", pSku=" + pSku + ", pName=" + pName + ", batchCode=" + batchCode + "]";
    }

}