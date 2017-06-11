/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.sierac.dao;

import java.util.List;
import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.sierac.entity.ProductionTask;

/**
 * 生产任务查询DAO接口
 * @author wgc
 * @version 2017-03-01
 */
@MyBatisDao
public interface ProductionTaskDao extends CrudDao<ProductionTask> {
	public List<ProductionTask> findProductionTaskByProductId(ProductionTask productionTask);
}