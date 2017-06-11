/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.sierac.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.sierac.dao.ApiRdcOutHeaderDao;
import com.thinkgem.jeesite.sierac.entity.ApiRdcOutHeader;

/**
 * CRUD操作Service
 * 
 * @author mjj
 * @version 2017-02-13
 */
@Service
@Transactional(readOnly = true)
public class ApiRdcOutHeaderService extends CrudService<ApiRdcOutHeaderDao, ApiRdcOutHeader> {

    public ApiRdcOutHeader get(String id) {
        return super.get(id);
    }

    public List<ApiRdcOutHeader> findList(ApiRdcOutHeader apiRdcOutHeader) {
        return super.findList(apiRdcOutHeader);
    }

    public Page<ApiRdcOutHeader> findPage(Page<ApiRdcOutHeader> page, ApiRdcOutHeader apiRdcOutHeader) {
        return super.findPage(page, apiRdcOutHeader);
    }

    @Transactional(readOnly = false)
    public void save(ApiRdcOutHeader apiRdcOutHeader) {
        super.save(apiRdcOutHeader);
    }

    @Transactional(readOnly = false)
    public void delete(ApiRdcOutHeader apiRdcOutHeader) {
        super.delete(apiRdcOutHeader);
    }

    @Transactional(readOnly = false)
    public void updateAll(ApiRdcOutHeader apiRdcOutHeader) {
        super.updateAll(apiRdcOutHeader);
    }
}