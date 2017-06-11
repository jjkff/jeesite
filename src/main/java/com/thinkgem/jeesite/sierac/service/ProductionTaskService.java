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
import com.thinkgem.jeesite.sierac.entity.ProductionTask;
import com.thinkgem.jeesite.sierac.dao.ProductionTaskDao;

/**
 * 生产任务查询Service
 * @author wgc
 * @version 2017-03-01
 */
@Service
@Transactional(readOnly = true)
public class ProductionTaskService extends CrudService<ProductionTaskDao, ProductionTask> {

	public ProductionTask get(String id) {
		return super.get(id);
	}
	
	public List<ProductionTask> findList(ProductionTask productiontask) {
		return super.findList(productiontask);
	}
	
	public Page<ProductionTask> findPage(Page<ProductionTask> page, ProductionTask productiontask) {
		return super.findPage(page, productiontask);
	}
	
	@Transactional(readOnly = false)
	public void save(ProductionTask productiontask) {
		super.save(productiontask);
	}
	
	@Transactional(readOnly = false)
	public void delete(ProductionTask productiontask) {
	}
	/**
	 * 通过产品Id获取产品id和name
	 */

	public List<ProductionTask> findProductionTaskByProductId(String productid) {
		ProductionTask productionTask = new ProductionTask();
		productionTask.setProductid(productid);
		List<ProductionTask> list = super.findProductionTaskByProductId(productionTask);
		
		return list;
	}

	@Transactional(readOnly = false)
	public ProductionTask findByCode(String code) {
		return super.findByCode(code);
	}
}