/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.sierac.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * CRUD操作Entity
 * 
 * @author mjj
 * @version 2017-02-13
 */
@JsonInclude(JsonInclude.Include.ALWAYS)
public class ApiFilesUpload {

    private String code;

    private String errorMsg;

    private List<ApiData> data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public List<ApiData> getData() {
        return data;
    }

    public void setData(List<ApiData> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ApiFilesUpload [code=" + code + ", errorMsg=" + errorMsg + ", data=" + data + "]";
    }

}