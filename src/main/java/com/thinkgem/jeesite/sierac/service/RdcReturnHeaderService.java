/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.sierac.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.sierac.entity.RdcReturnHeader;
import com.thinkgem.jeesite.sierac.dao.RdcReturnHeaderDao;

/**
 * CRUD操作Service
 * @author mjj
 * @version 2017-02-14
 */
@Service
@Transactional(readOnly = true)
public class RdcReturnHeaderService extends CrudService<RdcReturnHeaderDao, RdcReturnHeader> {

	public RdcReturnHeader get(String id) {
		return super.get(id);
	}
	
	public List<RdcReturnHeader> findList(RdcReturnHeader rdcReturnHeader) {
		return super.findList(rdcReturnHeader);
	}
	
	public Page<RdcReturnHeader> findPage(Page<RdcReturnHeader> page, RdcReturnHeader rdcReturnHeader) {
		return super.findPage(page, rdcReturnHeader);
	}
	
	@Transactional(readOnly = false)
	public void save(RdcReturnHeader rdcReturnHeader) {
		super.save(rdcReturnHeader);
	}
	
	@Transactional(readOnly = false)
	public void delete(RdcReturnHeader rdcReturnHeader) {
		super.delete(rdcReturnHeader);
	}
	
}