/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.sierac.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.sierac.dao.CodeDataDao;
import com.thinkgem.jeesite.sierac.entity.CodeData;

/**
 * 生产数据查询Service
 * 
 * @author wgc
 * @version 2017-02-14
 */
@Service
@Transactional(readOnly = true)
public class CodeDataService extends CrudService<CodeDataDao, CodeData> {

    public CodeData get(String id) {
        return super.get(id);
    }

    public List<CodeData> findList(CodeData codeData) {
        return super.findList(codeData);
    }

    public List<CodeData> findAll(CodeData codeData) {
        return super.findAll(codeData);
    }

    public Page<CodeData> findPage(Page<CodeData> page, CodeData codeData) {
        return super.findPage(page, codeData);
    }

    @Transactional(readOnly = false)
    public void save(CodeData codeData) {
        super.save(codeData);
    }

    @Transactional(readOnly = false)
    public void delete(CodeData codeData) {
        super.delete(codeData);
    }

    @Transactional(readOnly = false)
    public void updateAll(CodeData codeData) {
        super.updateAll(codeData);
    }
}