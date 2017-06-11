/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.sierac.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.sierac.dao.QueryFakeDao;
import com.thinkgem.jeesite.sierac.entity.QueryFake;

/**
 * CRUD操作Service
 * 
 * @author mjj
 * @version 2017-02-13
 */
@Service
@Transactional(readOnly = true)
public class QueryFakeService extends CrudService<QueryFakeDao, QueryFake> {

    public QueryFake get(String id) {
        return super.get(id);
    }

    public List<QueryFake> findList(QueryFake queryFake) {
        return super.findList(queryFake);
    }

    public Page<QueryFake> findPage(Page<QueryFake> page, QueryFake queryFake) {
        return super.findPage(page, queryFake);
    }

    @Transactional(readOnly = false)
    public void save(QueryFake queryFake) {
        super.save(queryFake);
    }

    @Transactional(readOnly = false)
    public void delete(QueryFake queryFake) {
        super.delete(queryFake);
    }
    // @Transactional(readOnly = false)
    // public void findForm(RdcOutDetail rdcOutDetail) {
    // super.findForm(rdcOutDetail);
    // }
}