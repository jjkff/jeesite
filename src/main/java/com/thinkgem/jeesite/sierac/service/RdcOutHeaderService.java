/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.sierac.service;

import java.util.List;

import com.thinkgem.jeesite.sierac.entity.Product;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.sierac.dao.RdcOutHeaderDao;
import com.thinkgem.jeesite.sierac.entity.RdcOutHeader;

/**
 * CRUD操作Service
 * 
 * @author mjj
 * @version 2017-02-13
 */
@Service
@Transactional(readOnly = true)
public class RdcOutHeaderService extends CrudService<RdcOutHeaderDao, RdcOutHeader> {

    public RdcOutHeader get(String id) {
        return super.get(id);
    }

    public List<RdcOutHeader> findList(RdcOutHeader rdcOutHeader) {
        return super.findList(rdcOutHeader);
    }

    public Page<RdcOutHeader> findPage(Page<RdcOutHeader> page, RdcOutHeader rdcOutHeader) {
        return super.findPage(page, rdcOutHeader);
    }

    @Transactional(readOnly = false)
    public void save(RdcOutHeader rdcOutHeader) {
        super.save(rdcOutHeader);
    }

    @Transactional(readOnly = false)
    public void delete(RdcOutHeader rdcOutHeader) {
        super.delete(rdcOutHeader);
    }

    public List<RdcOutHeader> findAll(RdcOutHeader rdcOutHeader) {
        return super.findAll(rdcOutHeader);
    }
    @Transactional(readOnly = false)
    public RdcOutHeader findByCode(String code) {
        return super.findByCode(code);
    }

}