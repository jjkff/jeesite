/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.sierac.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.sierac.dao.RdcOutDetailDao;
import com.thinkgem.jeesite.sierac.entity.RdcOutDetail;

/**
 * CRUD操作Service
 * 
 * @author mjj
 * @version 2017-02-13
 */
@Service
@Transactional(readOnly = true)
public class RdcOutDetailService extends CrudService<RdcOutDetailDao, RdcOutDetail> {

    public RdcOutDetail get(String id) {
        return super.get(id);
    }

    public List<RdcOutDetail> findList(RdcOutDetail rdcOutDetail) {
        return super.findList(rdcOutDetail);
    }

    public Page<RdcOutDetail> findPage(Page<RdcOutDetail> page, RdcOutDetail rdcOutDetail) {
        return super.findPage(page, rdcOutDetail);
    }

    @Transactional(readOnly = false)
    public void save(RdcOutDetail rdcOutDetail) {
        super.save(rdcOutDetail);
    }

    @Transactional(readOnly = false)
    public void delete(RdcOutDetail rdcOutDetail) {
        super.delete(rdcOutDetail);
    }
    // @Transactional(readOnly = false)
    // public void findForm(RdcOutDetail rdcOutDetail) {
    // super.findForm(rdcOutDetail);
    // }
}