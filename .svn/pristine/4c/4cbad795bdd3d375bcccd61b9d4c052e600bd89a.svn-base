package com.thinkgem.jeesite.sierac.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.sierac.dao.ProductDao;


import com.thinkgem.jeesite.sierac.entity.Product;

/**
 * 产品管理Service
 * 
 * @author wgc
 * @version 2017-02-13
 */
@Service
@Transactional(readOnly = true)
public class ProductService extends CrudService<ProductDao, Product> {

    public Product get(String id) {
        return super.get(id);
    }

    public List<Product> findList(Product product) {
        return super.findList(product);
    }

    /**
     * @author wgc 查询所需要显示的数据
     */
    public List<Product> findAll(Product product) {
        return super.findAll(product);
    }
    public List<Product> findByname(){
    	return super.findByname();
    }

    public Page<Product> findPage(Page<Product> page, Product product) {
        return super.findPage(page, product);
    }

    @Transactional(readOnly = false)
    public void save(Product product) {
        super.save(product);
    }

    @Transactional(readOnly = false)
    public void delete(Product product) {
        super.delete(product);
    }

    @Transactional(readOnly = false)
    public Product findByCode(String code) {
        return super.findByCode(code);
    }
}