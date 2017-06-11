/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.common.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.DataEntity;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.sierac.entity.QueryReport;

/**
 * Service基类
 * 
 * @author ThinkGem
 * @version 2014-05-16
 */
@Transactional(readOnly = true)
public abstract class CrudService<D extends CrudDao<T>, T extends DataEntity<T>> extends BaseService {

    /**
     * 持久层对象
     */
    @Autowired
    protected D dao;

    /**
     * 获取单条数据
     * 
     * @param id
     * @return
     */
    public T get(String id) {
        return dao.get(id);
    }

    /**
     * 获取单条数据
     * 
     * @param id
     * @return
     */
    public Page<T> getByPage(Page<T> page, T entity) {
        entity.setPage(page);
        page.setList(dao.findById(entity));
        return page;
    }
    public List<T> findByname(){
    	return dao.findByname();
    }

    /**
     * 
     * Description: 通过id查询多条详情<br/>
     * 
     * @author majiaJun
     * @param id
     * @return
     */
    public List<T> getById(T entity, String id) {
        return dao.findById(entity);
    }

    /**
     * 查询列表数据
     * 
     * @param entity
     * @return
     */
    public List<T> findList(T entity) {
        return dao.findList(entity);
    }

    public List<T> findProductionTaskByProductId(T entity) {
        return dao.findProductionTaskByProductId(entity);
    }

    /**
     * 查询分页数据
     * 
     * @param page 分页对象
     * @param entity
     * @return
     */
    public Page<T> findPage(Page<T> page, T entity) {
        entity.setPage(page);
        page.setList(dao.findList(entity));
        return page;
    }

    public Page<T> findPagebillStatusReady(Page<T> page, T entity) {
        entity.setPage(page);
        page.setList(dao.findListBillStatusready(entity));
        return page;
    }
    public Page<T> findPagebillStatusNotReady(Page<T> page, T entity) {
        entity.setPage(page);
        page.setList(dao.findListBillStatusnotready(entity));
        return page;
    }



    public Page<T> findPageuser(Page<T> page, T entity) {
        entity.setPage(page);
        page.setList(dao.findListuser(entity));
        return page;
    }

    public Page<T> findPageuserType(Page<T> page, T entity) {
        entity.setPage(page);
        page.setList(dao.findListuserType(entity));
        return page;
    }

    /**
     * 保存数据（插入或更新）
     * 
     * @param entity
     */
    @Transactional(readOnly = false)
    public void save(T entity) {
        if (entity.getIsNewRecord()) {
            entity.preInsert();
            dao.insert(entity);
        } else {
            entity.preUpdate();
            dao.update(entity);
        }
    }

    public int saveUserWarehouse(String id, String userId) {
        return dao.insertuserRdcwarehouse(id, userId);
    }

    /**
     * 
     * Description:批量更新 <br/>
     * 
     * @author majiaJun
     * @param list
     */
    @Transactional(readOnly = false)
    public void updateByMine(QueryReport queryReport) {
        dao.updateByMine(queryReport);
    }

    /**
     * 删除数据
     * 
     * @param entity
     */
    @Transactional(readOnly = false)
    public void delete(T entity) {
        dao.delete(entity);
    }

    /**
     * 查询所需要显示的数据
     */
    public List<T> findAll(T entity) {
        return dao.findAll(entity);
    }

    public void updateAll(T entity) {
        dao.updateAll(entity);
    }

    public T findByCode(String code) {
        return dao.findByCode(code);
    }
}
