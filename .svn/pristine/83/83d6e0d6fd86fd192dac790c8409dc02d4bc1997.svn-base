/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.sierac.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.sierac.dao.ApiRdcOutDetailDao;
import com.thinkgem.jeesite.sierac.entity.ApiRdcOutDetail;

/**
 * CRUD操作Service
 * 
 * @author mjj
 * @version 2017-02-13
 */
@Service
@Transactional(readOnly = true)
public class ApiRdcOutDetailService extends CrudService<ApiRdcOutDetailDao, ApiRdcOutDetail> {

    public ApiRdcOutDetail get(String id) {
        return super.get(id);
    }

    public List<ApiRdcOutDetail> findList(ApiRdcOutDetail apiRdcOutDetail) {
        return super.findList(apiRdcOutDetail);
    }

    public Page<ApiRdcOutDetail> findPage(Page<ApiRdcOutDetail> page, ApiRdcOutDetail apiRdcOutDetail) {
        return super.findPage(page, apiRdcOutDetail);
    }

    @Transactional(readOnly = false)
    public void save(ApiRdcOutDetail apiRdcOutDetail) {
        super.save(apiRdcOutDetail);
    }

    @Transactional(readOnly = false)
    public void delete(ApiRdcOutDetail apiRdcOutDetail) {

        super.delete(apiRdcOutDetail);
    }

    @Transactional(readOnly = false)
    public List<ApiRdcOutDetail> findAll(ApiRdcOutDetail apiRdcOutDetail) {
        return super.findAll(apiRdcOutDetail);
    }

    @Transactional(readOnly = false)
    public void updateAll(ApiRdcOutDetail apiRdcOutDetail) {
        super.updateAll(apiRdcOutDetail);
    }
}