package com.thinkgem.jeesite.sierac.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.sierac.dao.rdcUserDao;
import com.thinkgem.jeesite.sierac.entity.rdcUser;


@Service
@Transactional(readOnly = true)
public class RdcUserService extends CrudService<rdcUserDao, rdcUser> {
	public rdcUser get(String id) {
		return super.get(id);
	}
	
	public List<rdcUser> findList(rdcUser rdcUser) {
		
		return super.findList(rdcUser);
	}
	/**
	 * @author wgc
	 * 查询所需要显示的数据
	 */
	public List<rdcUser> findAll(rdcUser rdcUser){
		return super.findAll(rdcUser);
	}
		
	
	
	public Page<rdcUser> findPage(Page<rdcUser> page, rdcUser rdcUser) {
		return super.findPage(page, rdcUser);
	}
	public Page<rdcUser>findPageUser(Page<rdcUser>page,rdcUser rdcUser){
		return super.findPageuser(page, rdcUser);
	}
	
	@Transactional(readOnly = false)
	public void save(rdcUser rdcUser) {
		super.save(rdcUser);
	}
	
	@Transactional(readOnly = false)
	public void delete(rdcUser rdcUser) {
		super.delete(rdcUser);
	}
	@Transactional(readOnly = false)
	public int saveUserRdcwarehouse(@Param("id")String id,@Param("userId")String userId){
		return super.saveUserWarehouse(id,userId);
	}
	
}
