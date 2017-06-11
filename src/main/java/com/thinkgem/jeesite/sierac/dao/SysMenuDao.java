
package com.thinkgem.jeesite.sierac.dao;

import java.util.List;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;

import com.thinkgem.jeesite.sierac.entity.SysMenu;

/**
 * 模块管理DAO接口
 * @author wgc
 * @version 2017-02-15
 */
@MyBatisDao
public interface SysMenuDao extends CrudDao<SysMenu> {
	public List<SysMenu> findByUserId(SysMenu menu);
	
}