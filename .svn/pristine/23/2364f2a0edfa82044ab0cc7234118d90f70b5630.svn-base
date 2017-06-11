/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.sierac.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.sierac.dao.ApiDataDao;
import com.thinkgem.jeesite.sierac.entity.ApiData;

/**
 * CRUD操作Service
 * 
 * @author mjj
 * @version 2017-02-13
 */
@Service
@Transactional(readOnly = true)
public class ApiDataService extends CrudService<ApiDataDao, ApiData> {

    public ApiData get(String id) {
        return super.get(id);
    }

    public List<ApiData> findList(ApiData apiData) {
        return super.findList(apiData);
    }

    public Page<ApiData> findPage(Page<ApiData> page, ApiData apiData) {
        return super.findPage(page, apiData);
    }

    @Transactional(readOnly = false)
    public void save(ApiData apiData) {
        super.save(apiData);
    }

    @Transactional(readOnly = false)
    public void delete(ApiData apiData) {
        super.delete(apiData);
    }

}