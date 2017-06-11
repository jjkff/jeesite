/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.test_audit.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.test_audit.entity.Test_audit;
import com.thinkgem.jeesite.modules.test_audit.dao.Test_auditDao;

/**
 * crudService
 * @author wgc
 * @version 2017-02-11
 */
@Service
@Transactional(readOnly = true)
public class Test_auditService extends CrudService<Test_auditDao, Test_audit> {

	public Test_audit get(String id) {
		return super.get(id);
	}
	
	public List<Test_audit> findList(Test_audit test_audit) {
		return super.findList(test_audit);
	}
	
	public Page<Test_audit> findPage(Page<Test_audit> page, Test_audit test_audit) {
		return super.findPage(page, test_audit);
	}
	
	@Transactional(readOnly = false)
	public void save(Test_audit test_audit) {
		super.save(test_audit);
	}
	
	@Transactional(readOnly = false)
	public void delete(Test_audit test_audit) {
		super.delete(test_audit);
	}
	
}