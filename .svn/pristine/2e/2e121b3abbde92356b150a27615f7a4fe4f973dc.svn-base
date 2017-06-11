/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.sierac.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.sierac.dao.RdcReturnDetailDao;
import com.thinkgem.jeesite.sierac.entity.RdcReturnDetail;

/**
 * CRUD操作Service
 * 
 * @author mjj
 * @version 2017-02-13
 */
@Service
@Transactional(readOnly = true)
public class RdcReturnDetailService extends CrudService<RdcReturnDetailDao, RdcReturnDetail> {

    public RdcReturnDetail get(String id) {
        return super.get(id);
    }

    public List<RdcReturnDetail> findList(RdcReturnDetail rdcReturnDetail) {
        return super.findList(rdcReturnDetail);
    }

    public Page<RdcReturnDetail> findPage(Page<RdcReturnDetail> page, RdcReturnDetail rdcReturnDetail) {
        return super.findPage(page, rdcReturnDetail);
    }

    @Transactional(readOnly = false)
    public void save(RdcReturnDetail rdcReturnDetail) {
        super.save(rdcReturnDetail);
    }

    @Transactional(readOnly = false)
    public void delete(RdcReturnDetail rdcReturnDetail) {
        super.delete(rdcReturnDetail);
    }
    // @Transactional(readOnly = false)
    // public void findForm(RdcOutDetail rdcOutDetail) {
    // super.findForm(rdcOutDetail);
    // }
}