/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.sierac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.sierac.dao.QueryReportDao;
import com.thinkgem.jeesite.sierac.entity.QueryReport;

/**
 * CRUD操作Service
 * 
 * @author mjj
 * @version 2017-02-13
 */
@Service
@Transactional(readOnly = true)
public class QueryReportService extends CrudService<QueryReportDao, QueryReport> {
    @Autowired
    QueryReportDao queryReportDao;

    public QueryReport get(String id) {
        return super.get(id);
    }

    public List<QueryReport> findList(QueryReport queryReport) {
        return super.findList(queryReport);
    }

    public Page<QueryReport> findPage(Page<QueryReport> page, QueryReport queryReport) {
        return super.findPage(page, queryReport);
    }

    @Transactional(readOnly = false)
    public void save(QueryReport queryReport) {
        super.save(queryReport);
    }

    /**
     * 
     * 简单描述该方法的实现功能（可选）.批量更新
     * 
     * @see com.thinkgem.jeesite.common.service.CrudService#updateByMine(java.util.List)
     */
    @Transactional(readOnly = false)
    public void updateByMine(QueryReport queryReport) {
        super.updateByMine(queryReport);
    }

    @Transactional(readOnly = false)
    public void delete(QueryReport queryReport) {
        super.delete(queryReport);
    }

    public List<QueryReport> findAll(QueryReport queryReport) {
        return super.findAll(queryReport);
    }
    // @Transactional(readOnly = false)
    // public void findForm(RdcOutDetail rdcOutDetail) {
    // super.findForm(rdcOutDetail);
    // }
}