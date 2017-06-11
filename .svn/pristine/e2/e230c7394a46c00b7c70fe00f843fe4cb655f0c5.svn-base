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
import com.thinkgem.jeesite.sierac.dao.QueryReportDetailDao;
import com.thinkgem.jeesite.sierac.entity.QueryReportDetail;

/**
 * CRUD操作Service
 * 
 * @author mjj
 * @version 2017-02-13
 */
@Service
@Transactional(readOnly = true)
public class QueryReportDetailService extends CrudService<QueryReportDetailDao, QueryReportDetail> {
    @Autowired
    QueryReportDetailDao QueryReportDetailDao;

    public Page<QueryReportDetail> getBy(Page<QueryReportDetail> page, QueryReportDetail queryReportDetail) {
        return super.getByPage(page, queryReportDetail);
    }

    public List<QueryReportDetail> findList(QueryReportDetail queryReportDetail) {
        return super.findList(queryReportDetail);
    }

    public Page<QueryReportDetail> findPage(Page<QueryReportDetail> page, QueryReportDetail queryReportDetail) {
        return super.findPage(page, queryReportDetail);
    }

    @Transactional(readOnly = false)
    public void save(QueryReportDetail queryReportDetail) {
        super.save(queryReportDetail);
    }

    @Transactional(readOnly = false)
    public void delete(QueryReportDetail queryReportDetail) {
        super.delete(queryReportDetail);
    }

    // @Transactional(readOnly = false)
    // public void findForm(RdcOutDetail rdcOutDetail) {
    // super.findForm(rdcOutDetail);
    // }
}