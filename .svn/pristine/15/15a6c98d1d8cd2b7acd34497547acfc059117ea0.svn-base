/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.sierac.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.sierac.dao.ApiWarehouseOutScanCheckDao;
import com.thinkgem.jeesite.sierac.entity.ApiWarehouseOutScanCheck;

/**
 * CRUD操作Service
 * 
 * @author mjj
 * @version 2017-02-13
 */
@Service
@Transactional(readOnly = true)
public class ApiWarehouseOutScanCheckService extends CrudService<ApiWarehouseOutScanCheckDao, ApiWarehouseOutScanCheck> {

    public ApiWarehouseOutScanCheck get(String id) {
        return super.get(id);
    }

    public List<ApiWarehouseOutScanCheck> findList(ApiWarehouseOutScanCheck apiWarehouseOutScanCheck) {
        return super.findList(apiWarehouseOutScanCheck);
    }

    public Page<ApiWarehouseOutScanCheck> findPage(Page<ApiWarehouseOutScanCheck> page,
            ApiWarehouseOutScanCheck apiWarehouseOutScanCheck) {
        return super.findPage(page, apiWarehouseOutScanCheck);
    }

    @Transactional(readOnly = false)
    public void save(ApiWarehouseOutScanCheck apiWarehouseOutScanCheck) {
        super.save(apiWarehouseOutScanCheck);
    }

    @Transactional(readOnly = false)
    public void delete(ApiWarehouseOutScanCheck apiWarehouseOutScanCheck) {
        super.delete(apiWarehouseOutScanCheck);
    }

    public List<ApiWarehouseOutScanCheck> findAll(ApiWarehouseOutScanCheck apiWarehouseOutScanCheck) {
        return super.findAll(apiWarehouseOutScanCheck);
    }
}