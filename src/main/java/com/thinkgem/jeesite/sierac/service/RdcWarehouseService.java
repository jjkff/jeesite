/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.sierac.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.sierac.dao.RdcWarehouseDao;
import com.thinkgem.jeesite.sierac.entity.RdcWarehouse;

/**
 * CRUD操作Service
 * 
 * @author mjj
 * @version 2017-02-13
 */
@Service
@Transactional(readOnly = true)
public class RdcWarehouseService extends CrudService<RdcWarehouseDao, RdcWarehouse> {

    public RdcWarehouse get(String id) {
        return super.get(id);
    }

    public List<RdcWarehouse> findList(RdcWarehouse rdcWarehouse) {
        return super.findList(rdcWarehouse);
    }

    public Page<RdcWarehouse> findPage(Page<RdcWarehouse> page, RdcWarehouse rdcWarehouse) {
        return super.findPage(page, rdcWarehouse);
    }

    public Page<RdcWarehouse> findPageuser(Page<RdcWarehouse> page, RdcWarehouse rdcWarehouse) {
        return super.findPageuser(page, rdcWarehouse);
    }

    @Transactional(readOnly = false)
    public void save(RdcWarehouse rdcWarehouse) {
        super.save(rdcWarehouse);
    }

    @Transactional(readOnly = false)
    public void delete(RdcWarehouse rdcWarehouse) {
        super.delete(rdcWarehouse);
    }

    @Transactional(readOnly = false)
    public RdcWarehouse findByCode(String code) {
        return super.findByCode(code);
    }

}